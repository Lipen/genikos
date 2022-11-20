@file:Suppress("unused")

package com.github.lipen.genikos

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 0)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
class GetBenchmark {
    private val random = Random(42)
    private val size = 100_000
    private val indices = (0 until size).shuffled(random)
    private val index = random.nextInt(0, size)

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
    fun getAllShuffledFromGenericIntArray(bh: Blackhole) {
        for (i in indices) {
            bh.consume(genericIntArray[i])
        }
    }

    @Benchmark
    fun getAllShuffledFromGenericArray(bh: Blackhole) {
        for (i in indices) {
            bh.consume(genericArray[i])
        }
    }

    @Benchmark
    fun getAllShuffledFromGenericListArray(bh: Blackhole) {
        for (i in indices) {
            bh.consume(genericListArray[i])
        }
    }

    @Benchmark
    fun getAllConsecutiveFromGenericIntArray(bh: Blackhole) {
        for (x in genericIntArray) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getAllConsecutiveFromGenericArray(bh: Blackhole) {
        for (x in genericArray) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getAllConsecutiveGenericListArray(bh: Blackhole) {
        for (x in genericListArray) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getOneIndexGenericIntArray(bh: Blackhole) {
        bh.consume(genericIntArray[index])
    }

    @Benchmark
    fun getOneIndexFromGenericArray(bh: Blackhole) {
        bh.consume(genericArray[index])
    }

    @Benchmark
    fun getOneIndexFromGenericListArray(bh: Blackhole) {
        bh.consume(genericListArray[index])
    }

    // ====================

    @Benchmark
    fun getAllShuffledFromRealIntArray(bh: Blackhole) {
        for (i in indices) {
            bh.consume(realIntArray[i])
        }
    }

    @Benchmark
    fun getAllShuffledFromRealArray(bh: Blackhole) {
        for (i in indices) {
            bh.consume(realArray[i])
        }
    }

    @Benchmark
    fun getAllShuffledFromRealList(bh: Blackhole) {
        for (i in indices) {
            bh.consume(realList[i])
        }
    }

    @Benchmark
    fun getAllConsecutiveFromRealIntArray(bh: Blackhole) {
        for (x in realIntArray) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getAllConsecutiveFromRealArray(bh: Blackhole) {
        for (x in realArray) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getAllConsecutiveRealList(bh: Blackhole) {
        for (x in realList) {
            bh.consume(x)
        }
    }

    @Benchmark
    fun getOneIndexRealIntArray(bh: Blackhole) {
        bh.consume(realIntArray[index])
    }

    @Benchmark
    fun getOneIndexFromRealArray(bh: Blackhole) {
        bh.consume(realArray[index])
    }

    @Benchmark
    fun getOneIndexFromRealList(bh: Blackhole) {
        bh.consume(realList[index])
    }
}
