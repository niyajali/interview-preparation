package com.niyaj.neetcode

/**
 * Two Sum
 *
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [4,5,6], target = 10
 *
 * Output: [0,2]
 * Example 3:
 *
 * Input: nums = [5,5], target = 10
 *
 * Output: [0,1]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 */

private class TwoSum {

    /**
     * Find the indices of the two numbers such that they add up to a specific target number using Brute Force.
     * Step1: Iterate through the list
     * Step2: Iterate through the list starting from the next index of the first iteration
     * Step3: Check if the sum of the two numbers is equal to the target
     * Step4: If the sum is equal to the target, return the indices of the two numbers
     * Step5: If the sum is not equal to the target, continue the iteration
     * Step6: If no two numbers add up to the target, return an empty array
     * @param nums an array of integers
     * @param target the target number
     * @return the indices of the two numbers such that they add up to the target number
     * Space Complexity: O(1)
     * Time Complexity: O(n^2)
     */
    fun findTwoSumUsingBF(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }

    /**
     * Find the indices of the two numbers such that they add up to a specific target number using Hash Map.
     * Step1: Create a HashMap to store the complement of the target and the index of the number
     * Step2: Iterate through the list
     * Step3: Calculate the difference between the target and the number
     * Step4: Check if the difference is present in the HashMap
     * Step5: If the difference is present in the HashMap, return the indices of the two numbers
     * Step6: If the difference is not present in the HashMap, add the number and its index to the HashMap
     * Step7: If no two numbers add up to the target, return an empty array
     * @param nums an array of integers
     * @param target the target number
     * @return the indices of the two numbers such that they add up to the target number
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun findTwoSumUsingHashMap(nums: IntArray, target: Int): IntArray {
        val complement = HashMap<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            val diff = target - num

            if (complement.containsKey(diff)) {
                return intArrayOf(complement[diff]!!, i)
            }

            complement[num] = i
        }

        return intArrayOf()
    }
}

fun main() {
    val twoSum = TwoSum()
    val nums = intArrayOf(3, 4, 5, 6)
    val target = 7

    println(twoSum.findTwoSumUsingBF(nums, target).contentToString())
    println(twoSum.findTwoSumUsingHashMap(nums, target).contentToString())
}