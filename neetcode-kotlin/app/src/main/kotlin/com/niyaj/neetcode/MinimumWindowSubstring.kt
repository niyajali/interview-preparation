package com.niyaj.neetcode

/**
 * Minimum Window Substring
 * Solved
 * Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
 *
 * You may assume that the correct output is always unique.
 *
 * Example 1:
 *
 * Input: s = "OUZODYXAZV", t = "XYZ"
 *
 * Output: "YXAZ"
 * Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
 *
 * Example 2:
 *
 * Input: s = "xyz", t = "xyz"
 *
 * Output: "xyz"
 * Example 3:
 *
 * Input: s = "x", t = "xy"
 *
 * Output: ""
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 1 <= t.length <= 1000
 * s and t consist of uppercase and lowercase English letters.
 */
private object MinimumWindowSubstring {

    fun minWindowBF(s: String, t: String): String {
        // If string t is empty, there's no need to process, return an empty string
        if (t.isEmpty()) return ""

        // `countT` is a hashmap to store the frequency of each character in string t
        val countT = HashMap<Char, Int>()
        for (c in t) {
            // For each character in t, increase its count in countT
            countT[c] = countT.getOrDefault(c, 0) + 1
        }

        // `res` stores the indices of the best window found, initialized to [-1, -1]
        var res = IntArray(2) {-1}
        var resLen = Int.MAX_VALUE  // To track the length of the smallest valid window

        // Iterate through all possible starting points of the substring in s (indexed by i)
        for (i in s.indices) {
            // `countS` will store the frequency of characters in the current window of s
            val countS = HashMap<Char, Int>()

            // Iterate through the substring from index i to the end of the string (indexed by j)
            for (j in i until s.length) {
                // Increase the frequency of the character in the current window (countS)
                countS[s[j]] = countS.getOrDefault(s[j], 0) + 1

                // Flag to check if the current window contains all characters in t
                var flag = true

                // Check if for each character in t, its count in countS is enough
                for (c in countT.keys) {
                    if (countT[c]!! > countS.getOrDefault(c, 0)) {
                        // If any character count is less than required, set flag to false and break
                        flag = false
                        break
                    }
                }

                // If the current window contains all characters in t and is smaller than the previous best
                if (flag && (j - i + 1) < resLen) {
                    // Update the result with the new smaller window
                    resLen = j - i + 1
                    res[0] = i  // Set the start index of the new best window
                    res[1] = j  // Set the end index of the new best window
                }
            }
        }

        // If no valid window is found (i.e., res[0] is -1), return an empty string
        return if (res[0] == -1) "" else s.substring(res[0], res[1] + 1)
    }

    /**
     * This function will return the minimum window substring
     * Step1: Create a map to store the count of each character in the target string
     * Step2: Create a map to store the count of each character in the window
     * Step3: Create two pointers left and right
     * Step4: Move the right pointer and update the window map
     * Step5: Check if the current character is in the target string and update the have variable
     * Step6: Move the left pointer and update the result
     * Step7: Move the left pointer until the have is equal to need
     * Step8: Return the result
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param s the input string
     * @param t the target string
     * @return the minimum window substring
     */
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val countT = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()

        for (c in t) {
            countT[c] = countT.getOrDefault(c, 0) + 1
        }

        var left = 0
        var res = Pair(-1, -1)
        var resLength = Int.MAX_VALUE

        var have = 0
        var need = countT.size

        for (r in s.indices) {
            var c = s[r]
            // move the right pointer
            window[c] = window.getOrDefault(c, 0) + 1

            // check if the current character is in the target string
            if (countT.containsKey(c) && window[c] == countT[c]) {
                have++
            }

            // move the left pointer
            while (have == need) {
                // update the result
                if (r - left + 1 < resLength) {
                    resLength = r - left + 1
                    res = Pair(left, r)
                }

                // move the left pointer
                val leftChar = s[left]
                window[leftChar] = window.getOrDefault(leftChar, 0) - 1
                if (countT.containsKey(leftChar) && (window[leftChar] ?: 0) < countT[leftChar]!!) {
                    have--
                }
                left++
            }
        }

        return if (res.first == -1) "" else s.substring(res.first, res.second + 1)
    }
}

fun main() {
    println(MinimumWindowSubstring.minWindow("OUZODYXAZV", "XYZ")) // YXAZ
    println(MinimumWindowSubstring.minWindow("xyz", "xyz")) // xyz
    println(MinimumWindowSubstring.minWindow("x", "xy")) // ""

    println(MinimumWindowSubstring.minWindowBF("OUZODYXAZV", "XYZ")) // YXAZ
    println(MinimumWindowSubstring.minWindowBF("xyz", "xyz")) // xyz
    println(MinimumWindowSubstring.minWindowBF("x", "xy")) // ""
}