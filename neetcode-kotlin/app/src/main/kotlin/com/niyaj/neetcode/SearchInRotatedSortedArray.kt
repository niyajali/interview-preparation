package com.niyaj.neetcode

/**
 *Search in Rotated Sorted Array
 * Solved
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 *
 * You may assume all elements in the sorted rotated array nums are unique,
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,6,1,2], target = 1
 *
 * Output: 4
 * Example 2:
 *
 * Input: nums = [3,5,6,0,1,2], target = 4
 *
 * Output: -1
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -1000 <= target <= 1000
 */
object SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + ((right - left) / 2)
            if (target == nums[mid]) return mid

            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return -1
    }
}

fun main() {
    println(SearchInRotatedSortedArray.search(intArrayOf(3, 4, 5, 6, 1, 2), 1)) // 4
    println(SearchInRotatedSortedArray.search(intArrayOf(3, 5, 6, 0, 1, 2), 4)) // -1
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -1
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 8)) // -1
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 2)) // 6
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 4)) // 0
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 7)) // 3
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5)) // 1
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 6)) // 2
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 1)) // 5
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) // 4
    println(SearchInRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)) // -
}