package com.github.lipen.genikos

import kotlin.reflect.typeOf

interface GenericArray<T> : List<T> {
    operator fun set(index: Int, value: T)

    companion object {
        inline fun <reified T> new(size: Int): GenericArray<T> {
            @Suppress("UNCHECKED_CAST")
            return when (typeOf<T>()) {
                typeOf<Byte>() -> from(ByteArray(size)) as GenericArray<T>
                typeOf<Short>() -> from(ShortArray(size)) as GenericArray<T>
                typeOf<Int>() -> from(IntArray(size)) as GenericArray<T>
                typeOf<Long>() -> from(LongArray(size)) as GenericArray<T>
                typeOf<Float>() -> from(FloatArray(size)) as GenericArray<T>
                typeOf<Double>() -> from(DoubleArray(size)) as GenericArray<T>
                typeOf<Boolean>() -> from(BooleanArray(size)) as GenericArray<T>
                typeOf<Char>() -> from(CharArray(size)) as GenericArray<T>
                else -> from(arrayOfNulls<Any>(size) as Array<T>)
            }
        }

        inline fun <reified T> new(size: Int, noinline init: (Int) -> T): GenericArray<T> {
            @Suppress("UNCHECKED_CAST")
            return when (typeOf<T>()) {
                typeOf<Byte>() -> from(ByteArray(size) { init(it) as Byte }) as GenericArray<T>
                typeOf<Short>() -> from(ShortArray(size) { init(it) as Short }) as GenericArray<T>
                typeOf<Int>() -> from(IntArray(size) { init(it) as Int }) as GenericArray<T>
                typeOf<Long>() -> from(LongArray(size) { init(it) as Long }) as GenericArray<T>
                typeOf<Float>() -> from(FloatArray(size) { init(it) as Float }) as GenericArray<T>
                typeOf<Double>() -> from(DoubleArray(size) { init(it) as Double }) as GenericArray<T>
                typeOf<Boolean>() -> from(BooleanArray(size) { init(it) as Boolean }) as GenericArray<T>
                typeOf<Char>() -> from(CharArray(size) { init(it) as Char }) as GenericArray<T>
                else -> from(Array(size) { init(it) as Any } as Array<T>)
            }
        }

        fun <T> from(array: Array<T>): GenericArray<T> = ArrayImpl(array)
        fun <T> from(list: MutableList<T>): GenericArray<T> = MutableListArrayImpl(list)
        fun from(array: ByteArray): GenericArray<Byte> = ByteArrayImpl(array)
        fun from(array: ShortArray): GenericArray<Short> = ShortArrayImpl(array)
        fun from(array: IntArray): GenericArray<Int> = IntArrayImpl(array)
        fun from(array: LongArray): GenericArray<Long> = LongArrayImpl(array)
        fun from(array: FloatArray): GenericArray<Float> = FloatArrayImpl(array)
        fun from(array: DoubleArray): GenericArray<Double> = DoubleArrayImpl(array)
        fun from(array: BooleanArray): GenericArray<Boolean> = BooleanArrayImpl(array)
        fun from(array: CharArray): GenericArray<Char> = CharArrayImpl(array)
    }
}

abstract class AbstractGenericArray<T>(data: List<T>) : GenericArray<T>, List<T> by data
