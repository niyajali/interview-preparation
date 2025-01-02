package com.niyaj.neetcode

/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "zxyzxyz"
 *
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 *
 * Example 2:
 *
 * Input: s = "xxxx"
 *
 * Output: 1
 * Constraints:
 *
 * 0 <= s.length <= 1000
 * s may consist of printable ASCII characters.
 */
private object LongestSubstringWithoutRepeatingCharacters {
    /**
     * This function returns the length of the longest substring without duplicate characters.
     * Two pointer approach is used to solve this problem.
     * Step1: Initialize the left pointer to 0 and the right pointer to 0
     * Step2: Initialize the result variable to 0
     * Step3: Iterate through the string
     * Step4: If the character at the right pointer is in the map, update the left pointer to the maximum of the left pointer
     * and the value of the character at the right pointer plus 1
     * Step5: Update the value of the character at the right pointer in the map
     * Step6: Update the result variable with the maximum of the result variable and the difference between the right pointer
     * and the left pointer plus 1
     * Step7: Return the result
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var left = 0
        var res = 0

        for (right in s.indices) {
            if (s[right] in map) {
                left = maxOf(left, map[s[right]]!! + 1)
            }

            map[s[right]] = right
            res = maxOf(res, right - left + 1)
        }

        return res
    }
}

fun main() {
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("zxyzxyz")) // 3
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("xxxx")) // 1
    val s = "abcabcbb"
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s)) // 3
    val s1 = "bbbbb"
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s1)) // 1
    val s2 = "pwwkew"
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s2)) // 3
    val s3 = ""
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s3)) // 0
    val s4 = " "
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s4)) // 1
}