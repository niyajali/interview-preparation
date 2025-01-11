package com.niyaj.neetcode

import kotlin.math.ceil

/**
 * Koko Eating Bananas
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.
 *
 * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
 *
 * Return the minimum integer k such that you can eat all the bananas within h hours.
 *
 * Example 1:
 *
 * Input: piles = [1,4,3,2], h = 9
 *
 * Output: 2
 * Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.
 *
 * Example 2:
 *
 * Input: piles = [25,10,23,4], h = 4
 *
 * Output: 25
 * Constraints:
 *
 * 1 <= piles.length <= 1,000
 * piles.length <= h <= 1,000,000
 * 1 <= piles[i] <= 1,000,000,000
 */
object KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxByOrNull { it }!!
        var res = right

        while (left <= right){
            var mid = left + ((right - left) / 2)
            var totalTime = 0L

            for (i in piles){
                totalTime += ceil(i.toDouble() / mid).toLong()
            }

            if (totalTime <= h){
                res = minOf(res, mid)
                right = mid - 1
            }else{
                left = mid + 1
            }
        }

        return res
    }
}

fun main() {
    val piles = intArrayOf(1, 4, 3, 2)
    val h = 9
    println(KokoEatingBananas.minEatingSpeed(piles, h)) // 2

    val piles2 = intArrayOf(25, 10, 23, 4)
    val h2 = 4
    println(KokoEatingBananas.minEatingSpeed(piles2, h2)) // 25

    val piles3 = intArrayOf(30, 11, 23, 4, 20)
    val h3 = 5
    println(KokoEatingBananas.minEatingSpeed(piles3, h3)) // 23

    val piles4 = intArrayOf(30, 11, 23, 4, 20)
    val h4 = 6
    println(KokoEatingBananas.minEatingSpeed(piles4, h4)) // 20
}