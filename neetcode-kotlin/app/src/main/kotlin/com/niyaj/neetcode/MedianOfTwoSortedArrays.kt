package com.niyaj.neetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Median of Two Sorted Arrays
 * You are given two integer arrays nums1 and nums2 of size m and n respectively, where each is sorted in ascending order.
 * Return the median value among all elements of the two arrays.
 *
 * Your solution must run in
 * O(log(m+n)) time.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2], nums2 = [3]
 *
 * Output: 2.0
 * Explanation: Among [1, 2, 3] the median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,3], nums2 = [2,4]
 *
 * Output: 2.5
 * Explanation: Among [1, 2, 3, 4] the median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */
object MedianOfTwoSortedArrays {
    /**
     * Find the median of two sorted arrays
     * Step1: Initialize the variables A, B, total, half
     * Step2: Check if the size of A is greater than B, if so swap A and B
     * Step3: Initialize the variables left and right
     * Step4: Iterate through the loop until left is less than or equal to right
     * Step5: Calculate the mid and index
     * Step6: Calculate the ALeft, ARight, BLeft, BRight
     * Step7: Check if ALeft is less than or equal to BRight and BLeft is less than or equal to ARight
     * Step8: If the total is odd, return the maximum of ALeft and BLeft
     * Step9: If the total is even, return the average of the maximum of ALeft and BLeft and the minimum of ARight and BRight
     * Step10: If ALeft is greater than BRight, update right to mid - 1
     * Step11: If BLeft is greater than ARight, update left to mid + 1
     * Step12: Return -1.0
     * Time complexity: O(log(min(m, n)))
     * Space complexity: O(1)
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var firstList = nums1
        var secondList = nums2
        var total = firstList.size + secondList.size
        var half = (total - 1) / 2

        if (secondList.size < firstList.size) {
            firstList = secondList
            secondList = firstList
        }

        var left = 0
        var right = firstList.size

        while (left <= right) {
            val mid = (left + right) / 2
            val index = half - mid

            val ALeft = if (mid > 0) firstList[mid - 1] else Int.MIN_VALUE
            val ARight = if (mid < firstList.size) firstList[mid] else Int.MAX_VALUE

            val BLeft = if (index > 0) secondList[index - 1] else Int.MIN_VALUE
            val BRight = if (index < secondList.size) secondList[index] else Int.MAX_VALUE

            if (ALeft <= BRight && BLeft <= ARight) {
                return if (total % 2 != 0) {
                    max(ALeft.toDouble(), BLeft.toDouble())
                } else {
                    (max(ALeft.toDouble(), BLeft.toDouble()) + min(ARight.toDouble(), BRight.toDouble())) / 2.0
                }
            } else if (ALeft > BRight) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1.0
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(3)
    println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2)) // 2.0

    val nums3 = intArrayOf(1, 3)
    val nums4 = intArrayOf(2, 4)
    println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums3, nums4)) // 2.5

    val nums5 = intArrayOf(1, 2)
    val nums6 = intArrayOf(3, 4)
    println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums5, nums6)) // 2.5
}