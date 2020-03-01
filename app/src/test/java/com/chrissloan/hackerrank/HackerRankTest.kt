package com.chrissloan.hackerrank

import org.junit.Assert.assertThat
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
    private val expectedPos = "0.500000"
    private val expectedZero = "0.333333"
    private val expectedNeg = "0.166667"

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

        val posValue = pos.toFloat() / size
        val negValue = neg.toFloat() / size
        val zeroValue = zero.toFloat() / size

        val actualPos = "%.6f".format(posValue)
        val actualNeg = "%.6f".format(negValue)
        val actualZero = "%.6f".format(zeroValue)

        println("%.6f".format(pos.toFloat() / size))
        println("%.6f".format(neg.toFloat() / size))
        println("%.6f".format(zero.toFloat() / size))

        assert(actualPos == expectedPos)
        assert(actualNeg == expectedNeg)
        assert(actualZero == expectedZero)
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
            var line = " ".repeat(n-i)
            line += "#".repeat(i)
            println(line)
        }
    }
}
