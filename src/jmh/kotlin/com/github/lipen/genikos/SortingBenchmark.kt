@file:Suppress("unused")

package com.github.lipen.genikos

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
class SortingBenchmark {
    private val random = Random(42)
    private val size = 100_000

    private lateinit var realIntArray: IntArray
    private lateinit var realArray: Array<Int>
    private lateinit var realList: MutableList<Int>

    private lateinit var genericIntArray: GenericArray<Int>
    private lateinit var genericArray: GenericArray<Int>
    private lateinit var genericListArray: GenericArray<Int>

    @Setup
    fun setUp() {
        val data = (1..size).shuffled(random)
        realIntArray = data.toIntArray()
        genericIntArray = GenericArray.from(realIntArray)
        realArray = data.toTypedArray()
        genericArray = GenericArray.from(realArray)
        realList = data.toMutableList()
        genericListArray = GenericArray.from(realList)
    }

    @Benchmark
    fun sortGenericIntArray() {
        genericIntArray.sort()
    }

    @Benchmark
    fun sortGenericArray() {
        genericArray.sort()
    }

    @Benchmark
    fun sortGenericListArray() {
        genericListArray.sort()
    }

    // ====================

    @Benchmark
    fun sortRealIntArray() {
        realIntArray.sort()
    }

    @Benchmark
    fun sortRealArray() {
        realArray.sort()
    }

    @Benchmark
    fun sortRealListArray() {
        realList.sort()
    }
}
