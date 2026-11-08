//! Cross-platform "open a native library by name/path, find a symbol"
//! - the JNI-side equivalent of FFM's `SymbolLookup`.
//!
//! Design note: rather than piggy-backing on the JVM's own loader (which has
//! no cross-platform "search all loaded modules" primitive - POSIX has
//! `dlopen(NULL, ...)`/`RTLD_DEFAULT`, Windows has no equivalent), this
//! module owns the library handle itself via its own `dlopen`/`LoadLibraryW`
//! call. Kotlin's `Native.kt` still tries a system-installed name first,
//! then a classpath-extracted path, in the same order as before - only the
//! underlying resolution mechanism moved from `System.loadLibrary`/FFM's
//! `SymbolLookup` to this module.

#[derive(Debug)]
pub struct LibraryError(pub String);

#[cfg(unix)]
mod imp {
    use super::LibraryError;
    use std::ffi::{CStr, CString};
    use std::os::raw::{c_char, c_int, c_void};

    const RTLD_NOW: c_int = 2;
    const RTLD_GLOBAL: c_int = 0x100;

    extern "C" {
        fn dlopen(filename: *const c_char, flag: c_int) -> *mut c_void;
        fn dlsym(handle: *mut c_void, symbol: *const c_char) -> *mut c_void;
        fn dlclose(handle: *mut c_void) -> c_int;
        fn dlerror() -> *mut c_char;
    }

    fn last_error() -> String {
        unsafe {
            let p = dlerror();
            if p.is_null() {
                "unknown dlopen/dlsym error".to_string()
            } else {
                CStr::from_ptr(p).to_string_lossy().into_owned()
            }
        }
    }

    pub fn open(name_or_path: &str) -> Result<usize, LibraryError> {
        let c = CString::new(name_or_path).map_err(|e| LibraryError(e.to_string()))?;
        let handle = unsafe { dlopen(c.as_ptr(), RTLD_NOW | RTLD_GLOBAL) };
        if handle.is_null() {
            Err(LibraryError(last_error()))
        } else {
            Ok(handle as usize)
        }
    }

    pub fn find_symbol(handle: usize, name: &str) -> Result<usize, LibraryError> {
        let c = CString::new(name).map_err(|e| LibraryError(e.to_string()))?;
        unsafe { dlerror() }; // clear any pending error
        let sym = unsafe { dlsym(handle as *mut c_void, c.as_ptr()) };
        if sym.is_null() {
            Err(LibraryError(last_error()))
        } else {
            Ok(sym as usize)
        }
    }

    pub fn close(handle: usize) {
        unsafe {
            dlclose(handle as *mut c_void);
        }
    }
}

#[cfg(windows)]
mod imp {
    use super::LibraryError;
    use std::os::raw::{c_char, c_void};

    #[link(name = "kernel32")]
    extern "system" {
        fn LoadLibraryW(name: *const u16) -> *mut c_void;
        fn GetProcAddress(module: *mut c_void, name: *const c_char) -> *mut c_void;
        fn FreeLibrary(module: *mut c_void) -> i32;
        fn GetLastError() -> u32;
    }

    fn widen(s: &str) -> Vec<u16> {
        s.encode_utf16().chain(std::iter::once(0)).collect()
    }

    pub fn open(name_or_path: &str) -> Result<usize, LibraryError> {
        let wide = widen(name_or_path);
        let handle = unsafe { LoadLibraryW(wide.as_ptr()) };
        if handle.is_null() {
            Err(LibraryError(format!(
                "LoadLibraryW({name_or_path:?}) failed, GetLastError={}",
                unsafe { GetLastError() }
            )))
        } else {
            Ok(handle as usize)
        }
    }

    pub fn find_symbol(handle: usize, name: &str) -> Result<usize, LibraryError> {
        let c = std::ffi::CString::new(name).map_err(|e| LibraryError(e.to_string()))?;
        let sym = unsafe { GetProcAddress(handle as *mut c_void, c.as_ptr() as *const c_char) };
        if sym.is_null() {
            Err(LibraryError(format!("GetProcAddress({name:?}) failed, GetLastError={}", unsafe {
                GetLastError()
            })))
        } else {
            Ok(sym as usize)
        }
    }

    pub fn close(handle: usize) {
        unsafe {
            FreeLibrary(handle as *mut c_void);
        }
    }
}

pub fn open(name_or_path: &str) -> Result<usize, LibraryError> {
    imp::open(name_or_path)
}

pub fn find_symbol(handle: usize, name: &str) -> Result<usize, LibraryError> {
    imp::find_symbol(handle, name)
}

pub fn close(handle: usize) {
    imp::close(handle)
}
