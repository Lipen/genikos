package com.github.lipen.genikos

fun <T> GenericArray<T>.asTypedArray(): Array<T>? = (this as? ArrayImpl)?.array
fun <T> GenericArray<T>.asMutableList(): MutableList<T>? = (this as? MutableListArrayImpl)?.data
fun GenericArray<Byte>.asByteArray(): ByteArray? = (this as? ByteArrayImpl)?.array
fun GenericArray<Short>.asShortArray(): ShortArray? = (this as? ShortArrayImpl)?.array
fun GenericArray<Int>.asIntArray(): IntArray? = (this as? IntArrayImpl)?.array
fun GenericArray<Long>.asLongArray(): LongArray? = (this as? LongArrayImpl)?.array
fun GenericArray<Float>.asFloatArray(): FloatArray? = (this as? FloatArrayImpl)?.array
fun GenericArray<Double>.asDoubleArray(): DoubleArray? = (this as? DoubleArrayImpl)?.array
fun GenericArray<Boolean>.asBooleanArray(): BooleanArray? = (this as? BooleanArrayImpl)?.array
fun GenericArray<Char>.asCharArray(): CharArray? = (this as? CharArrayImpl)?.array
