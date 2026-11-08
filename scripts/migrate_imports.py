#!/usr/bin/env python3
"""
One-off codemod: repoints `java.lang.foreign.*` imports at the
`gg.sona.eos.internal.foreign` compatibility shim introduced by the FFM ->
JNI conversion (see internal/foreign/*.kt). Mechanical only - every type the
shim exposes is method-signature-compatible with what call sites already
use, so no other line needs to change.

Usage:
    python scripts/migrate_imports.py
"""
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
TARGETS = ["src/main/kotlin", "src/test/kotlin"]

OLD_PREFIX = "java.lang.foreign"
NEW_PREFIX = "gg.sona.eos.internal.foreign"

IMPORT_RE = re.compile(r"^import java\.lang\.foreign\.(.+)$", re.MULTILINE)


def migrate_file(path: Path) -> bool:
    text = path.read_text(encoding="utf-8")
    if OLD_PREFIX not in text:
        return False
    new_text = IMPORT_RE.sub(lambda m: f"import {NEW_PREFIX}.{m.group(1)}", text)
    if new_text != text:
        path.write_text(new_text, encoding="utf-8")
        return True
    return False


def main() -> None:
    changed = 0
    for target in TARGETS:
        for path in (ROOT / target).rglob("*.kt"):
            if migrate_file(path):
                changed += 1
    print(f"Migrated {changed} file(s).")


if __name__ == "__main__":
    main()
