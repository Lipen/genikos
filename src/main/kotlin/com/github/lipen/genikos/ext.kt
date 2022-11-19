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
