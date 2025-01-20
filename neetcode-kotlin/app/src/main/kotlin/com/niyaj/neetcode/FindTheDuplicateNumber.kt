package com.niyaj.neetcode

/**
 * Find the Duplicate Number
 * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
 *
 * Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2,2]
 *
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4]
 *
 * Output: 4
 * Follow-up: Can you solve the problem without modifying the array nums and using
 * O
 * (
 * 1
 * )
 * O(1) extra space?
 *
 * Constraints:
 *
 * 1 <= n <= 10000
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 */
object FindTheDuplicateNumber {
    /**
     * Find the duplicate number in the array.
     * Step1: Initialize two pointers slow and fast to the first element of the array.
     * Step2: Iterate through the array until the slow and fast pointers meet.
     * Step3: Initialize another pointer slow2 to the first element of the array.
     * Step4: Iterate through the array until the slow and slow2 pointers meet.
     * Step5: Return the duplicate number.
     * @param nums The array of integers.
     * @return The duplicate number.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        while (true){
            slow = nums[slow]
            fast = nums[nums[fast]]

            if (slow == fast){
                break;
            }
        }

        var slow2 = 0
        while (true){
            slow = nums[slow]
            slow2 = nums[slow2]

            if (slow == slow2){
                return slow
            }
        }
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 2, 2)
    println(FindTheDuplicateNumber.findDuplicate(nums)) // 2

    val nums2 = intArrayOf(1, 2, 3, 4, 4)
    println(FindTheDuplicateNumber.findDuplicate(nums2)) // 4
}