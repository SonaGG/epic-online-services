package gg.sona.eos

expect class EosFuture<T>() {
    fun complete(value: T): Boolean
    fun completeExceptionally(ex: Throwable): Boolean
}
