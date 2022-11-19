package com.github.lipen.genikos

@JvmInline
internal value class ArrayImpl<T>(
    private val inner: Array<*>,
) : GenericArray<T> {
    @Suppress("UNCHECKED_CAST")
    val array: Array<T> get() = inner as Array<T>

    override val data: List<T> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): T {
        return array[index]
    }

    override operator fun set(index: Int, value: T) {
        array[index] = value
    }

    override operator fun iterator(): Iterator<T> {
        return array.iterator()
    }
}

@JvmInline
internal value class MutableListArrayImpl<T>(
    val inner: MutableList<T>,
) : GenericArray<T> {
    override val data: List<T> get() = inner
    override val size: Int get() = inner.size

    override operator fun get(index: Int): T {
        return inner[index]
    }

    override operator fun iterator(): Iterator<T> {
        return inner.iterator()
    }

    override operator fun set(index: Int, value: T) {
        inner[index] = value
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

@JvmInline
internal value class ByteArrayImpl(
    val array: ByteArray,
) : GenericArray<Byte> {
    override val data: List<Byte> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Byte {
        return array[index]
    }

    override operator fun set(index: Int, value: Byte) {
        array[index] = value
    }

    override operator fun iterator(): ByteIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class ShortArrayImpl(
    val array: ShortArray,
) : GenericArray<Short> {
    override val data: List<Short> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Short {
        return array[index]
    }

    override operator fun set(index: Int, value: Short) {
        array[index] = value
    }

    override operator fun iterator(): ShortIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class IntArrayImpl(
    val array: IntArray,
) : GenericArray<Int> {
    override val data: List<Int> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Int {
        return array[index]
    }

    override operator fun set(index: Int, value: Int) {
        array[index] = value
    }

    override operator fun iterator(): IntIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class LongArrayImpl(
    val array: LongArray,
) : GenericArray<Long> {
    override val data: List<Long> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Long {
        return array[index]
    }

    override operator fun set(index: Int, value: Long) {
        array[index] = value
    }

    override operator fun iterator(): LongIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class FloatArrayImpl(
    val array: FloatArray,
) : GenericArray<Float> {
    override val data: List<Float> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Float {
        return array[index]
    }

    override operator fun set(index: Int, value: Float) {
        array[index] = value
    }

    override operator fun iterator(): FloatIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class DoubleArrayImpl(
    val array: DoubleArray,
) : GenericArray<Double> {
    override val data: List<Double> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Double {
        return array[index]
    }

    override operator fun set(index: Int, value: Double) {
        array[index] = value
    }

    override operator fun iterator(): DoubleIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class BooleanArrayImpl(
    val array: BooleanArray,
) : GenericArray<Boolean> {
    override val data: List<Boolean> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Boolean {
        return array[index]
    }

    override operator fun set(index: Int, value: Boolean) {
        array[index] = value
    }

    override operator fun iterator(): BooleanIterator {
        return array.iterator()
    }
}

@JvmInline
internal value class CharArrayImpl(
    val array: CharArray,
) : GenericArray<Char> {
    override val data: List<Char> get() = array.asList()
    override val size: Int get() = array.size

    override operator fun get(index: Int): Char {
        return array[index]
    }

    override operator fun set(index: Int, value: Char) {
        array[index] = value
    }

    override operator fun iterator(): CharIterator {
        return array.iterator()
    }
}
