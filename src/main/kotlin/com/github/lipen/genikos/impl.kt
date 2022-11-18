package com.github.lipen.genikos

@PublishedApi
internal class ArrayImpl<T>(
    val array: Array<T>,
) : GenericArray<T> {
    override val data: List<T> = array.asList()
    override val size: Int = array.size

    @Suppress("UNCHECKED_CAST")
    constructor(size: Int) : this(arrayOfNulls<Any>(size) as Array<T>)

    @Suppress("UNCHECKED_CAST")
    constructor(size: Int, init: (Int) -> T) : this(Array(size) { init(it) as Any } as Array<T>)

    override fun get(index: Int): T {
        return array[index]
    }

    override fun set(index: Int, value: T) {
        array[index] = value
    }

    override fun iterator(): Iterator<T> {
        return array.iterator()
    }
}

@PublishedApi
internal class MutableListArrayImpl<T>(
    override val data: MutableList<T>,
) : GenericArray<T> {
    override val size: Int get() = data.size

    override fun get(index: Int): T {
        return data[index]
    }

    override fun set(index: Int, value: T) {
        data[index] = value
    }

    override fun iterator(): Iterator<T> {
        return data.iterator()
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

@PublishedApi
internal class ByteArrayImpl(
    val array: ByteArray,
) : GenericArray<Byte> {
    override val data: List<Byte> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(ByteArray(size))
    constructor(size: Int, init: (Int) -> Byte) : this(ByteArray(size, init))

    override fun get(index: Int): Byte {
        return array[index]
    }

    override fun set(index: Int, value: Byte) {
        array[index] = value
    }

    override fun iterator(): ByteIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class ShortArrayImpl(
    val array: ShortArray,
) : GenericArray<Short> {
    override val data: List<Short> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(ShortArray(size))
    constructor(size: Int, init: (Int) -> Short) : this(ShortArray(size, init))

    override fun get(index: Int): Short {
        return array[index]
    }

    override fun set(index: Int, value: Short) {
        array[index] = value
    }

    override fun iterator(): ShortIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class IntArrayImpl(
    val array: IntArray,
) : GenericArray<Int> {
    override val data: List<Int> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(IntArray(size))
    constructor(size: Int, init: (Int) -> Int) : this(IntArray(size, init))

    override fun get(index: Int): Int {
        return array[index]
    }

    override fun set(index: Int, value: Int) {
        array[index] = value
    }

    override fun iterator(): IntIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class LongArrayImpl(
    val array: LongArray,
) : GenericArray<Long> {
    override val data: List<Long> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(LongArray(size))
    constructor(size: Int, init: (Int) -> Long) : this(LongArray(size, init))

    override fun get(index: Int): Long {
        return array[index]
    }

    override fun set(index: Int, value: Long) {
        array[index] = value
    }

    override fun iterator(): LongIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class FloatArrayImpl(
    val array: FloatArray,
) : GenericArray<Float> {
    override val data: List<Float> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(FloatArray(size))
    constructor(size: Int, init: (Int) -> Float) : this(FloatArray(size, init))

    override fun get(index: Int): Float {
        return array[index]
    }

    override fun set(index: Int, value: Float) {
        array[index] = value
    }

    override fun iterator(): FloatIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class DoubleArrayImpl(
    val array: DoubleArray,
) : GenericArray<Double> {
    override val data: List<Double> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(DoubleArray(size))
    constructor(size: Int, init: (Int) -> Double) : this(DoubleArray(size, init))

    override fun get(index: Int): Double {
        return array[index]
    }

    override fun set(index: Int, value: Double) {
        array[index] = value
    }

    override fun iterator(): DoubleIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class BooleanArrayImpl(
    val array: BooleanArray,
) : GenericArray<Boolean> {
    override val data: List<Boolean> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(BooleanArray(size))
    constructor(size: Int, init: (Int) -> Boolean) : this(BooleanArray(size, init))

    override fun get(index: Int): Boolean {
        return array[index]
    }

    override fun set(index: Int, value: Boolean) {
        array[index] = value
    }

    override fun iterator(): BooleanIterator {
        return array.iterator()
    }
}

@PublishedApi
internal class CharArrayImpl(
    val array: CharArray,
) : GenericArray<Char> {
    override val data: List<Char> = array.asList()
    override val size: Int = array.size

    constructor(size: Int) : this(CharArray(size))
    constructor(size: Int, init: (Int) -> Char) : this(CharArray(size, init))

    override fun get(index: Int): Char {
        return array[index]
    }

    override fun set(index: Int, value: Char) {
        array[index] = value
    }

    override fun iterator(): CharIterator {
        return array.iterator()
    }
}
