package com.github.lipen.genikos

fun GenericArray<*>.isEmpty(): Boolean = size == 0
fun GenericArray<*>.isNotEmpty(): Boolean = !isEmpty()

val GenericArray<*>.lastIndex: Int get() = size - 1
val GenericArray<*>.indices: IntRange get() = 0..lastIndex

operator fun <T> GenericArray<out T>.component1(): T = get(0)
operator fun <T> GenericArray<out T>.component2(): T = get(1)
operator fun <T> GenericArray<out T>.component3(): T = get(2)
operator fun <T> GenericArray<out T>.component4(): T = get(3)
operator fun <T> GenericArray<out T>.component5(): T = get(4)

operator fun <T> GenericArray<T>.plus(element: T): GenericArray<T> {
    val result = ArrayList<T>(this.size + 1)
    result.addAll(this)
    result.add(element)
    return GenericArray.from(result)
}

operator fun <T> GenericArray<T>.plus(elements: Iterable<T>): GenericArray<T> {
    return if (elements is Collection) {
        val result = ArrayList<T>(this.size + elements.size)
        result.addAll(this)
        result.addAll(elements)
        GenericArray.from(result)
    } else {
        val result = ArrayList<T>(this.size)
        result.addAll(this)
        result.addAll(elements)
        GenericArray.from(result)
    }
}
