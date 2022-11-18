package com.github.lipen.genikos

internal class ArrayImpl<T>(
    val array: Array<T>,
) : GenericArray<T>, List<T> by array.asList() {
    override operator fun set(index: Int, value: T) {
        array[index] = value
    }
}

internal class MutableListArrayImpl<T>(
    val data: MutableList<T>,
) : GenericArray<T>, List<T> by data {
    override operator fun set(index: Int, value: T) {
        data[index] = value
    }
}

// Byte
// Short
// Int
// Long
// Float
// Double
// Boolean
// Char

internal class ByteArrayImpl(
    val array: ByteArray,
) : GenericArray<Byte>, List<Byte> by array.asList() {
    override operator fun set(index: Int, value: Byte) {
        array[index] = value
    }
}

internal class ShortArrayImpl(
    val array: ShortArray,
) : GenericArray<Short>, List<Short> by array.asList() {
    override operator fun set(index: Int, value: Short) {
        array[index] = value
    }
}

internal class IntArrayImpl(
    val array: IntArray,
) : GenericArray<Int>, List<Int> by array.asList() {
    override operator fun set(index: Int, value: Int) {
        array[index] = value
    }
}

internal class LongArrayImpl(
    val array: LongArray,
) : GenericArray<Long>, List<Long> by array.asList() {
    override operator fun set(index: Int, value: Long) {
        array[index] = value
    }
}

internal class FloatArrayImpl(
    val array: FloatArray,
) : GenericArray<Float>, List<Float> by array.asList() {
    override operator fun set(index: Int, value: Float) {
        array[index] = value
    }
}

internal class DoubleArrayImpl(
    val array: DoubleArray,
) : GenericArray<Double>, List<Double> by array.asList() {
    override operator fun set(index: Int, value: Double) {
        array[index] = value
    }
}

internal class BooleanArrayImpl(
    val array: BooleanArray,
) : GenericArray<Boolean>, List<Boolean> by array.asList() {
    override operator fun set(index: Int, value: Boolean) {
        array[index] = value
    }
}

internal class CharArrayImpl(
    val array: CharArray,
) : GenericArray<Char>, List<Char> by array.asList() {
    override operator fun set(index: Int, value: Char) {
        array[index] = value
    }
}
