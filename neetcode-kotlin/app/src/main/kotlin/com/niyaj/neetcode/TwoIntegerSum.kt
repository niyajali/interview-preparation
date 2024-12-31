package com.niyaj.neetcode

/**
 *
 * Two Integer Sum II
 * Given an array of integers numbers that is sorted in non-decreasing order.
 *
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 *
 * There will always be exactly one valid solution.
 *
 * Your solution must use
 * O
 * (
 * 1
 * )
 * O(1) additional space.
 *
 * Example 1:
 *
 * Input: numbers = [1,2,3,4], target = 3
 *
 * Output: [1,2]
 * Explanation:
 * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 1000
 * -1000 <= numbers[i] <= 1000
 * -1000 <= target <= 1000
 *
 */

private object TwoIntegerSum {
    /**
     * Given an array of integers numbers that is sorted in non-decreasing order.
     * Two Pointer Approach
     * Step1: Initialize left and right pointers to the start and end of the array
     * Step2: Iterate through the array until the left pointer is less than the right pointer
     * Step3: Calculate the sum of the numbers at the left and right pointers
     * Step4: Check if the sum is less than the target, increment the left pointer
     * Step5: Check if the sum is greater than the target, decrement the right pointer
     * Step5: Return the indices of the two numbers
     * @param numbers an array of integers
     * @param target the target number
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Example: [1, 2, 3, 4], 3
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1
        // left: 0, right: 3

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            // sum: 5
            when {
                sum < target -> left++
                // left: 1
                sum > target -> right--
                // right: 2
                else -> return intArrayOf(left + 1, right + 1)
                // left: 1, right: 2
            }
            // left: 1, right: 2
        }

        return intArrayOf()
    }
}

fun main() {
    val numbers = intArrayOf(1, 2, 3, 4)
    val target = 4
    println(TwoIntegerSum.twoSum(numbers, target).contentToString()) // [1, 3]
    // Step By Step Walkthrough
    // left: 0, right: 3, sum: 5 <-- 1 + 4 = 5 > 4 (target) --> right-- (right: 2)
    // left: 0, right: 2, sum: 4 <-- 1 + 3 = 4 == 4 (target) --> return [1, 3]
    // target found: [1, 3]

    val numbers2 = intArrayOf(2, 7, 11, 15)
    val target2 = 18
    println(TwoIntegerSum.twoSum(numbers2, target2).contentToString()) // [2, 3]
    // Step By Step Walkthrough
    // left: 0, right: 3, sum: 17 <-- 2 + 15 = 17 < 18 (target) --> left++ (left: 1)
    // left: 1, right: 3, sum: 18 <-- 7 + 11 = 18 == 18 (target) --> return [2, 3]
    // target found: [2, 3]

    val numbers3 = intArrayOf(2, 5, 8, 9)
    val target3 = 13
    println(TwoIntegerSum.twoSum(numbers3, target3).contentToString()) // [2, 3]
    // Step By Step Walkthrough
    // left: 0, right: 3, sum: 11 <-- 2 + 9 = 11 < 13 (target) --> left++ (left: 1)
    // left: 1, right: 3, sum: 14 <-- 5 + 9 = 14 > 13 (target) --> right-- (right: 2)
    // left: 1, right: 2, sum: 13 <-- 5 + 8 = 13 == 13 (target) --> return [2, 3]
    // target found: [2, 3]

    val numbers4 = intArrayOf(-1, 0, 1)
    val target4 = -1
    println(TwoIntegerSum.twoSum(numbers4, target4).contentToString()) // [1, 2]
    // Step By Step Walkthrough
    // left: 0, right: 2, sum: -1 <-- -1 + 0 = -1 == -1 (target) --> return [1, 2]
    // target found: [1, 2]

}