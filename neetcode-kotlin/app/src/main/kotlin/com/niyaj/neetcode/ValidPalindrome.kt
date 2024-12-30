package com.niyaj.neetcode

/**
 * Valid Palindrome
 *
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 *
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "tab a cat"
 *
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s is made up of only printable ASCII characters.
 */
private object ValidPalindrome {

    /**
     * Given a string s, return true if it is a palindrome, otherwise return false.
     * Step1: Initialize left and right pointers to the start and end of the string
     * Step2: Iterate through the string until the left pointer is less than the right pointer
     * Step3: Check if the character at the left pointer is not a letter, increment the left pointer
     * Step4: Check if the character at the right pointer is not a letter, decrement the right pointer
     * Step5: Check if the character at the left pointer is not equal to the character at the right pointer, return false
     * Step6: Check if the character at the left pointer is not equal to the character at the right pointer, return false
     * Step7: Increment the left pointer and decrement the right pointer
     * Step8: Return true
     * @param s a string
     * @return true if it is a palindrome, otherwise return false
     * Space Complexity: O(1)
     * Time Complexity: O(n)
     *
     * input: "Was it a car or a cat I saw?"
     */
    fun isPalindrome(s: String): Boolean {
        var left = 0;
        var right = s.length - 1;

        while (left <= right) {
            if (!s[left].isLetterOrDigit()) {
                left++
            } else if (!s[right].isLetterOrDigit()) {
                right--
            } else if (s[left].lowercaseChar() == s[right].lowercaseChar()) {
                left++
                right--
            } else {
                return false
            }
        }

        return true
    }
}

fun main() {
    val s1 = "Was it a car or a cat I saw?"
    println(ValidPalindrome.isPalindrome(s1)) // true

    val s2 = "tab a cat"
    println(ValidPalindrome.isPalindrome(s2)) // false

    val s3 = "Test thh t"
    println(ValidPalindrome.isPalindrome(s3)) // false
}