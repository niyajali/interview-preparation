package com.niyaj.neetcode

/**
 * Sliding Window Maximum
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array.
 * The window slides one position to the right until it reaches the right edge of the array.
 *
 * Return a list that contains the maximum element in the window at each step.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 *
 * Output: [2,2,4,4,6]
 *
 * Explanation:
 * Window position            Max
 * ---------------           -----
 * [1  2  1] 0  4  2  6        2
 *  1 [2  1  0] 4  2  6        2
 *  1  2 [1  0  4] 2  6        4
 *  1  2  1 [0  4  2] 6        4
 *  1  2  1  0 [4  2  6]       6
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= nums.length
 *
 */
private object SlidingWindowMaximum {

    /**
     * This function returns a list that contains the maximum element in the window at each step.
     * Brute force approach is used to solve this problem.
     * Step1: Initialize the output list
     * Step2: Iterate through the nums array
     * Step3: Iterate through the nums array from the current index
     * Step4: Find the maximum element in the window
     * Step5: Add the maximum element to the output list
     * Step6: Return the output list
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    fun maxSlidingWindowBF(nums: IntArray, k: Int): IntArray {
        val output = mutableListOf<Int>()

        for (i in 0..nums.size - k) {
            var maxi = nums[i]
            for (j in i until i + k) {
                maxi = maxOf(maxi, nums[j])
            }
            output.add(maxi)
        }

        return output.toIntArray()
    }


    /**
     * This function returns a list that contains the maximum element in the window at each step.
     * Using a deque and two pointer approach to solve this problem.
     * Step1: Initialize the result list, deque, left, and right pointers
     * Step2: Iterate through the nums array
     * Step3: While the deque is not empty and the last element of the deque is less than the current element, remove the last element
     * Step4: Add the current element to the deque
     * Step5: If the left pointer is greater than the first element of the deque, remove the first element
     * Step6: If the right + 1 is greater than or equal to k, add the first element of the deque to the result list and increment the left pointer
     * Step7: Increment the right pointer
     * Step8: Return the result list
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums an integer array
     * @param k an integer
     * @return a list that contains the maximum element in the window at each step
     *
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val deque = ArrayDeque<Int>(nums.size - k + 1)

        var left = 0
        var right = 0

        while (right < nums.size) {
            while (deque.isNotEmpty() && nums[deque.last()] < nums[right]) {
                deque.removeLast()
            }
            deque.addLast(right)

            if (left > deque.first()) {
                deque.removeFirst()
            }

            if (right + 1 >= k) {
                result.add(nums[deque.first()])
                left++
            }
            right++
        }

        return result.toIntArray()
    }
}

fun main() {
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 2, 1, 0, 4, 2, 6), 3).contentToString()) // [2, 2, 4, 4, 6]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).contentToString()) // [3, 3, 5, 5, 6, 7]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1), 1).contentToString()) // [1]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, -1), 1).contentToString()) // [1, -1]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(9, 11), 2).contentToString()) // [11]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(4, -2), 2).contentToString()) // [4]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 3).contentToString()) // [3, 3, 2, 5]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 1).contentToString()) // [1, 3, 1, 2, 0, 5]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 6).contentToString()) // [5]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 4).contentToString()) // [3, 3, 2, 5]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 5).contentToString()) // [3, 3, 2, 5]
    println(SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 0).contentToString()) // [1,3,1,2,0,5]
}