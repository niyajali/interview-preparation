package com.niyaj.neetcode

/**
 * Duplicate Integer -
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 * Input: nums = [1, 2, 3, 3]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 */
private class DuplicateInteger {

    /**
     * Brute Force Approach
     * Step1: Loop through the array
     * Step2: Loop through the array again and check if the current element is equal to the next element
     * Step3: If it is equal, return true
     * Step4: If the loop ends, return false
     * TC - O(n^2) SC - O(1)
     * @param nums List<Int>
     * @return Boolean
     */
    fun findDuplicateBF(nums: List<Int>): Boolean {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    return true
                }
            }
        }

        return false
    }

    /**
     * Optimized Approach
     * Step1: Create a mutable set
     * Step2: Loop through the array
     * Step3: If the element is already present in the set, return true
     * Step4: If the loop ends, return false
     * TC - O(n) SC - O(n)
     * @param nums List<Int>
     * @return Boolean
     */
    fun findDuplicateOptimized(nums: List<Int>): Boolean {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (!set.add(num)) {
                return true
            }
        }

        return false
    }

}

fun main() {
    val duplicateInteger = DuplicateInteger()
    println(duplicateInteger.findDuplicateBF(listOf(1, 2, 3, 3)))
    println(duplicateInteger.findDuplicateOptimized(listOf(1, 2, 3, 4)))
}