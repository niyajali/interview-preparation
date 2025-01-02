package com.niyaj.neetcode

/**
 *
 * Best Time to Buy and Sell Stock
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 *
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 *
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 *
 * Example 1:
 *
 * Input: prices = [10,1,5,6,7,1]
 *
 * Output: 6
 * Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
 *
 * Example 2:
 *
 * Input: prices = [10,8,7,5,2]
 *
 * Output: 0
 * Explanation: No profitable transactions can be made, thus the max profit is 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 100
 * 0 <= prices[i] <= 100
 *
 */

private object BuyAndSellStock {
    /**
     * This function returns the maximum profit you can achieve.
     * Two pointer approach is used to solve this problem.
     * Step1: Initialize the result variable to 0
     * Step2: Initialize the left pointer to 0 and the right pointer to 1
     * Step3: Iterate through the array
     * Step4: Calculate the profit
     * Step5: Update the result variable with the maximum profit
     * Step6: If the price at the left pointer is less than the price at the right pointer, increment the right pointer
     * Step7: If the price at the left pointer is greater than the price at the right pointer, increment the left pointer
     * Step8: Return the result
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param prices an array of integers
     * @return the maximum profit you can achieve
     */
    fun maxProfitTP(prices: IntArray): Int {
        var left = 0
        var right = 1
        var maxProfit = 0

        while (right < prices.size) {
            if (prices[left] < prices[right]) {
                val price = prices[right] - prices[left]
                maxProfit = maxOf(maxProfit, price)
            } else {
                left = right
            }

            right++
        }

        return maxProfit
    }

    /**
     * This function returns the maximum profit you can achieve.
     * Dynamic programming approach is used to solve this problem.
     * Step1: Initialize the minBuy variable to 0 and the maxBuy variable to Int.MAX_VALUE
     * Step2: Iterate through the array
     * Step3: Calculate the maximum profit
     * Step4: Update the maxBuy variable with the maximum profit
     * Step5: Update the minBuy variable with the minimum price
     * Step6: Return the maxBuy
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param prices an array of integers
     * @return the maximum profit you can achieve
     *
     */
    fun maxProfitDP(prices: IntArray): Int {
        var maxP = 0
        var minBuy = Int.MAX_VALUE

        for (sell in prices) {
            maxP = maxOf(maxP, sell - minBuy)
            minBuy = minOf(minBuy, sell)
        }

        return maxP
    }
}

fun main() {
    val prices = intArrayOf(10, 1, 5, 6, 7, 1)
    println(BuyAndSellStock.maxProfitTP(prices)) // 6
    println(BuyAndSellStock.maxProfitDP(prices)) // 6

    val prices1 = intArrayOf(10, 8, 7, 5, 2)
    println(BuyAndSellStock.maxProfitTP(prices1)) // 0
    println(BuyAndSellStock.maxProfitDP(prices1)) // 0

    val prices2 = intArrayOf(7, 1, 5, 3, 6, 4)
    println(BuyAndSellStock.maxProfitTP(prices2)) // 5
    println(BuyAndSellStock.maxProfitDP(prices2)) // 5
}