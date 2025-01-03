package com.niyaj.neetcode

/**
 * Longest Repeating Character Replacement
 *
 * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
 *
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 *
 * Example 1:
 *
 * Input: s = "XYYX", k = 2
 *
 * Output: 4
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 *
 * Example 2:
 *
 * Input: s = "AAABABB", k = 1
 *
 * Output: 5
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 0 <= k <= s.length
 */

private object LongestRepeatingCharacterReplacement {
    /**
     * This function returns the length of the longest substring which contains only one distinct character.
     * Two pointer approach is used to solve this problem.
     * Step1: Initialize the left pointer to 0, count to 0, maxCount to 0, and result to 0
     * Step2: Iterate through the string
     * Step3: Update the count map
     * Step4: Update the maxCount
     * Step5: While the difference between the right and left pointers and the maxCount is greater than k, update the count map and increment the left pointer
     * Step6: Update the result
     * Step7: Return the result
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param s a string
     * @param k an integer
     * @return the length of the longest substring which contains only one distinct character
     */
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var count = HashMap<Char, Int>(0)
        var maxCount = 0
        var res = 0

        for (right in s.indices) {
            count[s[right]] = count.getOrDefault(s[right], 0) + 1
            maxCount = maxOf(maxCount, count[s[right]]!!)

            while ((right - left + 1) - maxCount > k) {
                count[s[left]] = count[s[left]]!! - 1
                left++
            }

            res = maxOf(res, right - left + 1)
        }

        return res
    }
}

fun main() {
    println(LongestRepeatingCharacterReplacement.characterReplacement("XYYX", 2)) // 4
    println(LongestRepeatingCharacterReplacement.characterReplacement("AAABABB", 1)) // 5

    // Test case 1
    assert(LongestRepeatingCharacterReplacement.characterReplacement("XYYX", 2) == 4)
    // Test case 2
    assert(LongestRepeatingCharacterReplacement.characterReplacement("AAABABB", 1) == 5)
    // Test case 3
    assert(LongestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1) == 4)

    println("All test cases passed")
}