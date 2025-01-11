package com.niyaj.neetcode

/**
 * Find Minimum in Rotated Sorted Array
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.
 *
 * Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,6,1,2]
 *
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,5,0,1,2,3]
 *
 * Output: 0
 * Example 3:
 *
 * Input: nums = [4,5,6,7]
 *
 * Output: 4
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 */
object FindMinimumInRotatedSortedArray {

    /**
     * Find minimum element in rotated sorted array
     * Step1: Initialize left = 0, right = n - 1, res = nums[0]
     * Step2: Iterate until left <= right
     * Step3: If nums[left] <= nums[right], then res = min(res, nums[left]) and break
     * Step4: Calculate mid = left + (right - left) / 2
     * Step5: If nums[left] <= nums[mid], then res = min(res, nums[left]) and left = mid + 1
     * Step6: Else res = min(res, nums[mid]) and right = mid - 1
     * Step7: Return res
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param nums array of integers
     * @return minimum element in the array
     */
    fun findMin(nums: IntArray): Int {
        var left = 0;
        var right = nums.size - 1;
        var res = nums[0]

        while (left <= right) {
            if (nums[left] <= nums[right]) {
                res = minOf(res, nums[left])
                break
            }

            val mid = left + ((right - left) / 2)
            res = minOf(res, nums[mid])


            if (nums[left] <= nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return res
    }
}

fun main() {
    println(FindMinimumInRotatedSortedArray.findMin(intArrayOf(3, 4, 5, 6, 1, 2))) // 1
    println(FindMinimumInRotatedSortedArray.findMin(intArrayOf(4, 5, 0, 1, 2, 3))) // 0
    println(FindMinimumInRotatedSortedArray.findMin(intArrayOf(4, 5, 6, 7))) // 4
}