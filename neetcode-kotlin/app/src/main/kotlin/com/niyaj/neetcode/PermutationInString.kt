package com.niyaj.neetcode

/**
 * Permutation in String
 * You are given two strings s1 and s2.
 *
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 *
 * Both strings only contain lowercase letters.
 *
 * Example 1:
 *
 * Input: s1 = "abc", s2 = "lecabee"
 *
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 *
 * Example 2:
 *
 * Input: s1 = "abc", s2 = "lecaabee"
 *
 * Output: false
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 1000
 */
object PermutationInString {
    /**
     * This function returns true if s2 contains a permutation of s1, or false otherwise.
     * Brute force approach is used to solve this problem.
     * Step1: Sort the s1 string
     * Step2: Iterate through the s2 string
     * Step3: Iterate through the s2 string from the current index
     * Step4: Calculate the substring
     * Step5: Sort the substring
     * Step6: If the sorted substring is equal to the sorted s1, return true
     * Step7: Return false
     * Time complexity: O(n^3)
     * Space complexity: O(n)
     */
    fun checkInclusionBF(s1: String, s2: String): Boolean {
        val sortedS1 = s1.toCharArray().apply { sort() }.concatToString()

        for (i in s2.indices) {
            for (j in i until s2.length) {
                val subStr = s2.substring(i, j + 1)
                val sortedSubStr = subStr.toCharArray().apply { sort() }.concatToString()
                if (sortedSubStr == sortedS1) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * This function returns true if s2 contains a permutation of s1, or false otherwise.
     * Using a count map and two pointer approach to solve this problem.
     * Step1: Initialize the left pointer to 0, count map, and the result to false
     * Step2: Iterate through the s1 string
     * Step3: Update the count map
     * Step4: Iterate through the s2 string
     * Step5: Update the count map
     * Step6: While the difference between the right and left pointers is greater than the length of s1, update the count map and increment the left pointer
     * Step7: If the count map is equal to the s1 map, return true
     * Step8: Return false
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    fun checkInclusionHM(s1: String, s2: String): Boolean {
        val s1Map = HashMap<Char, Int>(0)
        val s2Map = HashMap<Char, Int>(0)

        for (c in s1) {
            s1Map[c] = s1Map.getOrDefault(c, 0) + 1
        }

        var left = 0

        for (right in s2.indices) {
            s2Map[s2[right]] = s2Map.getOrDefault(s2[right], 0) + 1

            while (right - left + 1 > s1.length) {
                s2Map[s2[left]] = s2Map[s2[left]]!! - 1
                if (s2Map[s2[left]] == 0) {
                    s2Map.remove(s2[left])
                }
                left++
            }

            if (s1Map == s2Map) {
                return true
            }
        }

        return false
    }

    fun checkInclusionSW(s1: String, s2: String): Boolean {
        // If the length of s1 is greater than the length of s2, return false
        if (s1.length > s2.length) return false


        val s1Count = IntArray(26) // Initialize an array of size 26
        val s2Count = IntArray(26) // Initialize an array of size 26

        // Iterate through the s1 string
        for (i in s1.indices) {
            s1Count[s1[i] - 'a']++
            s2Count[s2[i] - 'a']++
        }

        // Initialize the matches variable to 0
        var matches = 0

        // Iterate through the array
        for (i in 0 until 26) {
            if (s1Count[i] == s2Count[i]) {
                matches++
            }
        }

        var left = 0 // Initialize the left pointer to 0

        // Iterate through the s2 string
        for (right in s1.length until s2.length) {

            // If the matches is equal to 26, return true
            if (matches == 26) {
                return true
            }

            val rightChar = s2[right] - 'a' // Calculate the right character
            s2Count[rightChar]++ // Increment the count of the right character

            // If the count of the right character is equal to the count of the right character in s1, increment the matches
            if (s2Count[rightChar] == s1Count[rightChar]) {
                matches++ // Increment the matches
            } else if (s2Count[rightChar] == s1Count[rightChar] + 1) { // If the count of the right character is equal to the count of the right character in s1 + 1
                matches-- // Decrement the matches
            }

            // Calculate the left character
            val leftChar = s2[left] - 'a'
            s2Count[leftChar]-- // Decrement the count of the left character

            // If the count of the left character is equal to the count of the left character in s1, increment the matches
            if (s2Count[leftChar] == s1Count[leftChar]) {
                matches++ // Increment the matches
            } else if (s2Count[leftChar] == s1Count[leftChar] - 1) { // If the count of the left character is equal to the count of the left character in s1 - 1
                matches--
            }

            // Increment the left pointer
            left++
        }

        // If the matches is equal to 26, return true
        return matches == 26
    }

}

fun main() {
    println(PermutationInString.checkInclusionBF("abc", "lecabee")) // true
    println(PermutationInString.checkInclusionBF("abc", "lecaabee")) // false

    println(PermutationInString.checkInclusionHM("abc", "lecabee")) // true
    println(PermutationInString.checkInclusionHM("abc", "lecaabee")) // false

    println(PermutationInString.checkInclusionSW("abc", "lecabee")) // true
    println(PermutationInString.checkInclusionSW("abc", "lecaabee")) // false

    // Test case 1
    assert(PermutationInString.checkInclusionBF("abc", "lecabee"))
    // Test case 2
    assert(!PermutationInString.checkInclusionBF("abc", "lecaabee"))

    // Test case 3
    assert(PermutationInString.checkInclusionHM("abc", "lecabee"))
    // Test case 4
    assert(!PermutationInString.checkInclusionHM("abc", "lecaabee"))

    // Test case 5
    assert(PermutationInString.checkInclusionSW("abc", "lecabee"))
    // Test case 6
    assert(!PermutationInString.checkInclusionSW("abc", "lecaabee"))
}