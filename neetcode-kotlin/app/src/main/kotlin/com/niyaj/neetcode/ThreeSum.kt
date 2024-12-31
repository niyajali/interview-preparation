package com.niyaj.neetcode

/**
 * 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
 *
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 *
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 *
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 *
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 */
object ThreeSum {
    /**
     * This function returns all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0
     * and the indices i, j and k are all distinct.
     * Two pointer approach is used to solve this problem.
     * Step1: Sort the array
     * Step2: Iterate through the array
     * Step3: For each element, use two pointers to find the sum of three elements
     * Step4: If the sum is less than 0, increment the left pointer
     * Step5: If the sum is greater than 0, decrement the right pointer
     * Step6: If the sum is equal to 0, add the triplet to the result list
     * Step7: Increment the left pointer and decrement the right pointer
     * Step8: Skip the duplicates
     * Step9: Return the result list
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param nums Integer array
     * @return List of triplets
     *
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--

                        while (left < right && nums[left] == nums[left - 1]) left++
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    val nums1 = intArrayOf(-1, 0, 1, 2, -1, -4)
    println(ThreeSum.threeSum(nums1)) // [[-1, -1, 2], [-1, 0, 1]]
    // Step by step walkthrough
    // [-4, -1, -1, 0, 1, 2]
    // i = 0, left = 1, right = 5, sum = -4 + -1 + 2 = -3
    // i = 0, left = 2, right = 5, sum = -4 + -1 + 1 = -4
    // i = 0, left = 3, right = 5, sum = -4 + 0 + 1 = -3
    // i = 0, left = 4, right = 5, sum = -4 + 1 + 1 = -2
    // i = 0, left = 4, right = 4, sum = -4 + 1 + 0 = -3
    // i = 1, left = 2, right = 5, sum = -1 + -1 + 2 = 0
    // Found a triplet [-1, -1, 2]
    // i = 1, left = 3, right = 5, sum = -1 + 0 + 2 = 1
    // i = 1, left = 3, right = 4, sum = -1 + 0 + 1 = 0
    // Found a triplet [-1, -1, 2]
    // i = 2, left = 3, right = 5, sum = -1 + 0 + 2 = 1
    // i = 2, left = 3, right = 4, sum = -1 + 0 + 1 = 0
    // Found a triplet [-1, 0, 1] Skip the duplicates
    // i = 4, left = 5, right = 5, sum = 1 + 2 + 2 = 5
    // i = 4, left = 5, right = 4, sum = 1 + 2 + 1 = 4
    // i = 4, left = 5, right = 3, sum = 1 + 2 + 0 = 3
    // i = 4, left = 5, right = 2, sum = 1 + 2 + -1 = 2
    // i = 4, left = 5, right = 1, sum = 1 + 2 + -1 = 2
    // [[-1, -1, 2], [-1, 0, 1]]


    val nums2 = intArrayOf(0, 1, 1)
    println(ThreeSum.threeSum(nums2)) // []

    val nums3 = intArrayOf(0, 0, 0)
    println(ThreeSum.threeSum(nums3)) // [[0, 0, 0]]
}