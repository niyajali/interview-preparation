package com.niyaj.neetcode

/**
 * Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * The test cases are generated such that the answer is always unique.
 *
 * You may return the output in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,3], k = 2
 *
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [7,7], k = 1
 *
 * Output: [7]
 * Constraints:
 *
 * 1 <= nums.length <= 10^4.
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= number of distinct elements in nums.
 */

private object TopKElements {
    /**
     * Find the k most frequent elements within the array.
     * Step1: Create a mutable map to store the key-value pair of the number and the frequency
     * Step2: Iterate through the list of numbers
     * Step3: Add the number to the map and increment the frequency
     * Step4: Create a list of lists to store the frequency of the numbers
     * Step5: Iterate through the map
     * Step6: Add the number to the list of lists based on the frequency
     * Step7: Create a mutable list to store the result
     * Step8: Iterate through the list of lists starting from the end
     * Step9: Iterate through the list of numbers
     * Step10: Add the number to the result
     * Step11: Return the result
     * @param nums an array of integers
     * @param k the number of most frequent elements
     * @return the k most frequent elements within the array
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     *
     * input: [1, 2, 2, 2, 3, 4, 4, 4, 5], k: 2
     */
    fun findTopKElements(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()

        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }
        // count: {1=1, 2=3, 3=1, 4=3, 5=1}

        val freq = List(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freqCount) in count) {
            freq[freqCount].add(num)
        }
        // freq: [[], [1, 3, 5], [], [2, 4],

        val result = mutableListOf<Int>()

        for (i in freq.size - 1 downTo 0) {
            for (num in freq[i]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }
        // result: [2, 4]

        return result.toIntArray()

    }

}

fun main() {
    val topKElements = TopKElements
    val nums = intArrayOf(1, 2, 2, 2, 3, 4, 4, 4, 5)
    val k = 2
    val result = topKElements.findTopKElements(nums, k)
    println(result.contentToString())
}