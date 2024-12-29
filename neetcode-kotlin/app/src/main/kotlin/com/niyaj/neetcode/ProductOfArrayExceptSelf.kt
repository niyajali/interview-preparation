package com.niyaj.neetcode

/**
 * Products of Array Except Self
 * Solved
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
 *
 * Each product is guaranteed to fit in a 32-bit integer.
 *
 * Follow-up: Could you solve it in
 * O
 * (
 * n
 * )
 * O(n) time without using the division operation?
 *
 * Example 1:
 *
 * Input: nums = [1,2,4,6]
 *
 * Output: [48,24,12,8]
 * Example 2:
 *
 * Input: nums = [-1,0,1,2,3]
 *
 * Output: [0,-6,0,0,0]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -20 <= nums[i] <= 20
 */
private object ProductOfArrayExceptSelf {
    /**
     * Find the product of all the elements of nums except nums[i].
     * Step1: Create a mutable list to store the result
     * Step2: Iterate through the list of numbers
     * Step3: Add the product of the numbers to the result
     * Step4: Return the result
     * @param nums an array of integers
     * @return an array output where output[i] is the product of all the elements of nums except nums[i]
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     *
     * input: [1, 2, 4, 6]
     */
    fun findProductIfArrayExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }
        // res: [1, 1, 1, 1]

        for (i in 1 until nums.size) {
            res[i] = res[i - 1] * nums[i - 1]
        }
        // res: [1, 1, 2, 8]

        var right = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] *= right
            right *= nums[i]
            // i: 3, res: [1, 1, 2, 8], right: 1
            // i: 2, res: [1, 1, 2, 8], right: 6
            // i: 1, res: [1, 1, 12, 8], right: 24
            // i: 0, res: [1, 24, 12, 8], right: 48
        }

        // res: [48, 24, 12, 8]

        return res
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 4, 6)
    val result = ProductOfArrayExceptSelf.findProductIfArrayExceptSelf(nums)
    println(result.contentToString())

    val nums2 = intArrayOf(-1, 0, 1, 2, 3)
    val result2 = ProductOfArrayExceptSelf.findProductIfArrayExceptSelf(nums2)
    println(result2.contentToString())

    val nums3 = intArrayOf(1, 2, 3, 4)
    val result3 = ProductOfArrayExceptSelf.findProductIfArrayExceptSelf(nums3)
    println(result3.contentToString())

    val nums4 = intArrayOf(3, 2, 1, 3, 2)
    val result4 = ProductOfArrayExceptSelf.findProductIfArrayExceptSelf(nums4)
    println(result4.contentToString())

}