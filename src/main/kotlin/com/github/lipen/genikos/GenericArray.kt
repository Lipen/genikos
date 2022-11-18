package com.github.lipen.genikos

import kotlin.reflect.typeOf

interface GenericArray<T> : Iterable<T> {
    val data: List<T>
    val size: Int

    operator fun get(index: Int): T
    operator fun set(index: Int, value: T)
    override operator fun iterator(): Iterator<T>

    companion object {
        inline fun <reified T> new(size: Int): GenericArray<T> {
            @Suppress("UNCHECKED_CAST")
            return when (typeOf<T>()) {
                typeOf<Byte>() -> ByteArrayImpl(size) as GenericArray<T>
                typeOf<Short>() -> ShortArrayImpl(size) as GenericArray<T>
                typeOf<Int>() -> IntArrayImpl(size) as GenericArray<T>
                typeOf<Long>() -> LongArrayImpl(size) as GenericArray<T>
                typeOf<Float>() -> FloatArrayImpl(size) as GenericArray<T>
                typeOf<Double>() -> DoubleArrayImpl(size) as GenericArray<T>
                typeOf<Boolean>() -> BooleanArrayImpl(size) as GenericArray<T>
                typeOf<Char>() -> CharArrayImpl(size) as GenericArray<T>
                else -> ArrayImpl(size)
            }
        }

        inline fun <reified T> new(size: Int, noinline init: (Int) -> T): GenericArray<T> {
            @Suppress("UNCHECKED_CAST")
            return when (typeOf<T>()) {
                typeOf<Byte>() -> ByteArrayImpl(size, init as (Int) -> Byte) as GenericArray<T>
                typeOf<Short>() -> ShortArrayImpl(size, init as (Int) -> Short) as GenericArray<T>
                typeOf<Int>() -> IntArrayImpl(size, init as (Int) -> Int) as GenericArray<T>
                typeOf<Long>() -> LongArrayImpl(size, init as (Int) -> Long) as GenericArray<T>
                typeOf<Float>() -> FloatArrayImpl(size, init as (Int) -> Float) as GenericArray<T>
                typeOf<Double>() -> DoubleArrayImpl(size, init as (Int) -> Double) as GenericArray<T>
                typeOf<Boolean>() -> BooleanArrayImpl(size, init as (Int) -> Boolean) as GenericArray<T>
                typeOf<Char>() -> CharArrayImpl(size, init as (Int) -> Char) as GenericArray<T>
                else -> ArrayImpl(size, init)
            }
        }

        fun <T> from(array: Array<T>): GenericArray<T> = ArrayImpl(array)
        fun <T> from(list: MutableList<T>): GenericArray<T> = MutableListArrayImpl(list)
        fun from(array: IntArray): GenericArray<Int> = IntArrayImpl(array)
        fun from(array: ByteArray): GenericArray<Byte> = ByteArrayImpl(array)
        fun from(array: ShortArray): GenericArray<Short> = ShortArrayImpl(array)
        fun from(array: LongArray): GenericArray<Long> = LongArrayImpl(array)
        fun from(array: FloatArray): GenericArray<Float> = FloatArrayImpl(array)
        fun from(array: DoubleArray): GenericArray<Double> = DoubleArrayImpl(array)
        fun from(array: BooleanArray): GenericArray<Boolean> = BooleanArrayImpl(array)
        fun from(array: CharArray): GenericArray<Char> = CharArrayImpl(array)
    }
}
