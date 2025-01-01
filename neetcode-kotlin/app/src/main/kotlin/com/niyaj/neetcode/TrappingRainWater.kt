package com.niyaj.neetcode

/**
 * You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
 *
 * Return the maximum area of water that can be trapped between the bars.
 *
 * Example 1:
 *
 *
 *
 * Input: height = [0,2,0,3,1,0,1,3,2,1]
 *
 * Output: 9
 * Constraints:
 *
 * 1 <= height.length <= 1000
 * 0 <= height[i] <= 1000
 */
private object TrappingRainWater {

    /**
     * This function returns the maximum area of water that can be trapped between the bars.
     * Two pointer approach is used to solve this problem.
     * Step1: Initialize the result variable to 0
     * Step2: Initialize the left pointer to 0 and the right pointer to the last index of the array
     * Step3: Iterate through the array
     * Step4: Calculate the area of the container
     * Step5: Update the result variable with the maximum area
     * Step6: If the height of the left pointer is less than the height of the right pointer, increment the left pointer
     * Step7: If the height of the left pointer is greater than the height of the right pointer, decrement the right pointer
     * Step8: Return the result
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param height an array of non-negative integers
     * @return the maximum area of water that can be trapped between the bars
     *
     */
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var res = 0
        var left = 0
        var right = height.size - 1
        var maxLeft = height[left]
        var maxRight = height[right]

        while (left < right) {
            if (height[left] < height[right]) {
                left++
                maxLeft = maxOf(maxLeft, height[left])
                res += maxLeft - height[left]
            } else {
                right--
                maxRight = maxOf(maxRight, height[right])
                res += maxRight - height[right]
            }
        }

        return res
    }
}

fun main() {
    val height = intArrayOf(0, 2, 0, 3, 1, 0, 1, 3, 2, 1)
    println(TrappingRainWater.trap(height)) // 9

    val height1 = intArrayOf(4, 2, 0, 3, 2, 5)
    println(TrappingRainWater.trap(height1)) // 9

    val height2 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(TrappingRainWater.trap(height2)) // 6

    val height3 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(TrappingRainWater.trap(height3)) // 6

    val height4 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(TrappingRainWater.trap(height4)) // 6

    val height5 = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(TrappingRainWater.trap(height5)) // 6
}