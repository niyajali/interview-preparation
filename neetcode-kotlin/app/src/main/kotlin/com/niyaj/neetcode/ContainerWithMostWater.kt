package com.niyaj.neetcode

import kotlin.math.min

/**
 * Container With Most Water
 * Solved
 * You are given an integer array heights where heights[i] represents the height of the i'th bar.
 *
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 *
 * Example 1:
 *
 *
 *
 * Input: height = [1,7,2,5,4,7,3,6]
 *
 * Output: 36
 * Example 2:
 *
 * Input: height = [2,2,2]
 *
 * Output: 4
 * Constraints:
 *
 * 2 <= height.length <= 1000
 * 0 <= height[i] <= 1000
 */
private object ContainerWithMostWater {

    /**
     * This function returns the maximum amount of water a container can store.
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
     * @param heights an array of integers
     * @return the maximum amount of water a container can store
     *
     */
    fun maxArea(heights: IntArray): Int {
        var res = 0;
        var left = 0;
        var right = heights.size - 1;

        while (left < right){
            val area = (right - left) * min(heights[left], heights[right]);
            res = maxOf(res, area);

            if (heights[left] < heights[right]){
                left++
            }else{
                right--
            }
        }

        return res;
    }
}

fun main() {
    val heights = intArrayOf(1, 7, 2, 5, 4, 7, 3, 6)
    println(ContainerWithMostWater.maxArea(heights)) // 36

    val heights2 = intArrayOf(2, 2, 2)
    println(ContainerWithMostWater.maxArea(heights2)) // 4

    val heights3 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(ContainerWithMostWater.maxArea(heights3)) // 49

    val heights4 = intArrayOf(1, 1)
    println(ContainerWithMostWater.maxArea(heights4)) // 1
}