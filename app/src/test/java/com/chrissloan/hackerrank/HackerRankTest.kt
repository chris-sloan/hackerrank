package com.chrissloan.hackerrank

import org.junit.Test
import kotlin.math.abs

class HackerRankTest {

    @Test
    fun diagonalDifference() {
        val top = listOf(11, 2, 4).toTypedArray()
        val mid = listOf(4, 5, 6).toTypedArray()
        val bot = listOf(10, 8, -12).toTypedArray()

        val arr = listOf(top, mid, bot).toTypedArray()


        val size = arr.size
        var leftDiag = 0
        var rightDiag = 0

        for (i in 0 until size) {
            leftDiag += arr[i][i]
            rightDiag += arr[(size - 1) - i][i]
        }

        val output = abs(leftDiag - rightDiag)

        assert(leftDiag == 4)
        assert(rightDiag == 19)

        assert(output == 15)
    }

    @Test
    fun compareTriples() {
        val a = arrayOf(4, 7, 88)
        val b = arrayOf(17, 2, 95)

        val output = arrayOf(0, 0)
        for (i in a.indices) {
            if (a[i] > b[i]) {
                output[0] += 1
            } else if (a[i] < b[i]) {
                output[1] += 1
            }
        }

        assert(output[0] == 1)
        assert(output[1] == 2)

    }

    private val arr: Array<Int> = arrayOf(3, 4, 5, 0, 0, -1)
    /**
     * Given an array of integers, calculate the fractions of its elements that are positive,
     * negative, and are zeros. Print the decimal value of each fraction on a new line.
     */
    @Test
    fun plusMinus() {
        val size = arr.size
        var pos = 0
        var neg = 0
        var zero = 0

        arr.forEach {
            when {
                it > 0 -> pos++
                it < 0 -> neg++
                else -> zero++
            }
        }

        println("%.6f".format(pos.toFloat() / size))
        println("%.6f".format(neg.toFloat() / size))
        println("%.6f".format(zero.toFloat() / size))
    }

    @Test
    fun plusMinus2() {
        val output = arrayOf(0, 0, 0)

        arr.forEach {
            when {
                it > 0 -> output[0]++
                it < 0 -> output[1]++
                else -> output[2]++
            }
        }

        output.forEach { value ->
            println("%.6f".format(value.toFloat() / arr.size))
        }
    }

    @Test
    fun staircase() {
        val n = 34
        for (i in 1..n) { //lines
            var line = " ".repeat(n - i)
            line += "#".repeat(i)
            println(line)
        }
    }

    /**
     * Given five positive integers, find the minimum and maximum values that can be calculated by
     * summing exactly four of the five integers. Then print the respective minimum and maximum
     * values as a single line of two space-separated long integers.
     *
     */
    @Test
    fun minMaxSum() {
        val arr = arrayOf(426980153, 354802167, 142980735, 968217435, 734892650)
        arr.sort()
        val longArr = arr.map { it.toLong() }

        val min: Long = longArr.take(4).sum()
        val max: Long = longArr.takeLast(4).sum()

        println("$min $max")
    }

    /**
     * You are in charge of the cake for your niece's birthday and have decided the cake will have
     * one candle for each year of her total age. When she blows out the candles, she’ll only be
     * able to blow out the tallest ones. Your task is to find out how many candles she can
     * successfully blow out.
     *
     * For example, if your niece is turning 4 years old, and the cake will have candles of height
     * 4, 4, 1, 3 she will be able to blow out 2 candles successfully, since the tallest candles
     * are of height and there are such candles.
     */
    @Test
    fun birthdayCakeCandles() {
        val ar = arrayOf(7, 7, 8, 8, 6, 5, 4, 3, 6, 7, 8, 8, 8)

        val max = ar.max()
        val grouped = ar.groupBy { it }
        val countOfMax = grouped[max]!!.size

        println(countOfMax)
    }

    /**
     * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
     * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is
     * 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
     */
    @Test
    fun timeConversion() {
        val s = "12:45:00PM"
        lateinit var retVal: String
        val isPm = s.contains("PM")
        val split = s
            .replace("PM", "", true)
            .replace("AM", "", true)
            .split(":")
            .map { it.toInt() }
            .toMutableList()

        if (isPm && split[0] != 12 || !isPm && split[0] == 12) {
            split[0] += 12
        }
        if (split[0] == 24) {
            split[0] = 0
        }
        val hours = split[0].toString().padStart(2, '0')
        val mins = split[1].toString().padStart(2, '0')
        val secs = split[2].toString().padStart(2, '0')

        retVal = "$hours:$mins:$secs"
        println(retVal)
    }
}
