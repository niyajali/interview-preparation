package com.niyaj.neetcode

/**
 * Daily Temperatures
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 *
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [30,38,30,36,35,40,28]
 *
 * Output: [1,4,1,2,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [22,21,20]
 *
 * Output: [0,0,0]
 * Constraints:
 *
 * 1 <= temperatures.length <= 1000.
 * 1 <= temperatures[i] <= 100
 */
private object DailyTemperatures {
    /**
     * Return an array where result[i] is the number of days after the ith day before a warmer temperature appears on a future day.
     * Step1: Create an array to store the result
     * Step2: Create a mutable list to store the stack
     * Step3: Iterate through the temperatures
     * Step4: Check if the stack is not empty and the current temperature is greater than the temperature at the top of the stack
     * Step5: Remove the last element from the stack
     * Step6: Calculate the difference between the current index and the index at the top of the stack
     * Step7: Add the difference to the result
     * Step8: Add the current index to the stack
     * Step9: Return the result
     * @param temperatures an array of integers
     * @return an array where result[i] is the number of days after the ith day before a warmer temperature appears on a future day
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size)
        val stack = mutableListOf<Int>()

        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val index = stack.removeAt(stack.lastIndex)
                res[index] = i - index
            }

            stack.add(i)
        }

        return res
    }
}

fun main() {

    val temperatures = intArrayOf(30, 38, 30, 36, 35, 40, 28)
    val result = DailyTemperatures.dailyTemperatures(temperatures)
    println(result.joinToString()) // Output: 1,4,1,2,1,0,0

    val temperatures2 = intArrayOf(22, 21, 20)
    val result2 = DailyTemperatures.dailyTemperatures(temperatures2)
    println(result2.joinToString()) // Output: 0,0,0

    val temperatures3 = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    val result3 = DailyTemperatures.dailyTemperatures(temperatures3)
    println(result3.joinToString()) // Output: 1,1,4,2,1,1,0,0


}