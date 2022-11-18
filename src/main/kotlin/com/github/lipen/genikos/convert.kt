package com.github.lipen.genikos

fun GenericArray<Byte>.asByteArray(): ByteArray? = (this as? ByteArrayImpl)?.array
fun GenericArray<Short>.asShortArray(): ShortArray? = (this as? ShortArrayImpl)?.array
fun GenericArray<Int>.asIntArray(): IntArray? = (this as? IntArrayImpl)?.array
fun GenericArray<Long>.asLongArray(): LongArray? = (this as? LongArrayImpl)?.array
fun GenericArray<Float>.asFloatArray(): FloatArray? = (this as? FloatArrayImpl)?.array
fun GenericArray<Double>.asDoubleArray(): DoubleArray? = (this as? DoubleArrayImpl)?.array
fun GenericArray<Boolean>.asBooleanArray(): BooleanArray? = (this as? BooleanArrayImpl)?.array
fun GenericArray<Char>.asCharArray(): CharArray? = (this as? CharArrayImpl)?.array

fun GenericArray<Byte>.toByteArray(): ByteArray = data.toByteArray()
fun GenericArray<Short>.toShortArray(): ShortArray = data.toShortArray()
fun GenericArray<Int>.toIntArray(): IntArray = data.toIntArray()
fun GenericArray<Long>.toLongArray(): LongArray = data.toLongArray()
fun GenericArray<Float>.toFloatArray(): FloatArray = data.toFloatArray()
fun GenericArray<Double>.toDoubleArray(): DoubleArray = data.toDoubleArray()
fun GenericArray<Boolean>.toBooleanArray(): BooleanArray = data.toBooleanArray()
fun GenericArray<Char>.toCharArray(): CharArray = data.toCharArray()

fun <T> GenericArray<T>.asList(): List<T> = data
fun <T> GenericArray<T>.toList(): List<T> = data.toList()
fun <T> GenericArray<T>.toMutableList(): MutableList<T> = data.toMutableList()
fun <T> MutableList<T>.asGenericArray(): GenericArray<T> = GenericArray.from(this)

fun <T> GenericArray<T>.asIterable(): Iterable<T> =
    if (isEmpty()) emptyList() else Iterable { iterator() }

fun <T> GenericArray<T>.asSequence(): Sequence<T> =
    if (isEmpty()) emptySequence() else Sequence { iterator() }
