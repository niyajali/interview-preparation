package com.niyaj.neetcode

/**
 * Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 *
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 *
 * Output: 9
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
object LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * @param nums an unsorted array of integers
     * @return the length of the longest consecutive elements sequence
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     *
     * input: [100, 4, 200, 1, 3, 2]
     */
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var longestStreak = 0

        for (num in numSet) {
            var length = 1

            if (!numSet.contains(num - length)) {
                while (numSet.contains(num + length)) {
                    length += 1
                }
                longestStreak = maxOf(longestStreak, length)
            }
        }

        return longestStreak
    }
}

fun main() {
    val nums1 = intArrayOf(100, 4, 200, 1, 3, 2)
    println(LongestConsecutiveSequence.longestConsecutive(nums1)) // 4

    val nums2 = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
    println(LongestConsecutiveSequence.longestConsecutive(nums2)) // 9
}