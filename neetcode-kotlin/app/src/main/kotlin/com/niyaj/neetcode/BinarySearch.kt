package com.niyaj.neetcode

/**
 * Binary Search
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 *
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 *
 * Your solution must run in
 * O
 * (
 * l
 * o
 * g
 * n
 * )
 * O(logn) time.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,2,4,6,8], target = 4
 *
 * Output: 3
 * Example 2:
 *
 * Input: nums = [-1,0,2,4,6,8], target = 3
 *
 * Output: -1
 * Constraints:
 *
 * 1 <= nums.length <= 10000.
 * -10000 < nums[i], target < 10000
 */
object BinarySearch {
    /**
     * Search for target within nums. If it exists, then return its index, otherwise, return -1.
     * Step1: Initialize the left pointer to 0 and the right pointer to the last index of the array
     * Step2: Iterate through the array until the left pointer is less than or equal to the right pointer
     * Step3: Calculate the middle index
     * Step4: Check if the middle element is greater than the target
     * Step5: Update the right pointer to the middle index - 1
     * Step6: Check if the middle element is less than the target
     * Step7: Update the left pointer to the middle index + 1
     * Step8: Return the middle index if the middle element is equal to the target
     * Step9: Return -1 if the target is not found
     * @param nums an array of distinct integers
     * @param target an integer
     * @return the index of the target if it exists, otherwise, return -1
     */
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while(l <= r){
            val m = l + ((r - l) / 2)

            when {
                nums[m] > target -> r = m - 1
                nums[m] < target -> l = m + 1
                else -> return m
            }
        }

        return -1
    }
}

fun main() {
    val nums = intArrayOf(-1, 0, 2, 4, 6, 8)
    val target = 4
    val result = BinarySearch.search(nums, target)
    println(result) // Output: 3

    val nums2 = intArrayOf(-1, 0, 2, 4, 6, 8)
    val target2 = 3
    val result2 = BinarySearch.search(nums2, target2)
    println(result2) // Output: -1

    val nums3 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val target3 = 5
    val result3 = BinarySearch.search(nums3, target3)
    println(result3) // Output: 4
}