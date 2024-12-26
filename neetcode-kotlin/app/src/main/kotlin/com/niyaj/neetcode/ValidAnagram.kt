package com.niyaj.neetcode

/**
 * Valid Anagram -
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 *
 * Example 2:
 * Input: s = "jar", t = "jam"
 * Output: false
 *
 * Constraints:
 * s and t consist of lowercase English letters.
 */
private class ValidAnagram {

    /**
     * Check Anagram Using Sorting
     * Step1: Check if the length of both strings are equal, if not return false
     * Step2: Sort both strings and compare them
     * Step3: If both strings are equal return true else return false
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */

    fun checkIsAnagramSorting(firstStr: String, secString: String): Boolean {
        // Check length of the both string
        if (firstStr.length != secString.length) return false

        // Sort both string
        val firstStrSorted = firstStr.toCharArray().sorted().joinToString("")
        val secStringSorted = secString.toCharArray().sorted().joinToString("")

        // Check both sorted string
        return firstStrSorted == secStringSorted;
    }

    /**
     * Check Anagram Using Hashtable
     * Step1: Check if the length of both strings are equal, if not return false
     * Step2: Create a hash table and add all characters of first string to hash table
     * Step3: Remove all characters of second string from hash table
     * Step4: If hash table is empty return true else return false
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun checkIsAnagramUsingHashtable(firstStr: String, secString: String): Boolean {
        // Check length of the both string
        if (firstStr.length != secString.length) return false

        // Create a hash table
        val hashTable = HashMap<Char, Int>()

        // Add all characters of first string to hash table
        for (char in firstStr) {
            hashTable[char] = hashTable.getOrDefault(char, 0) + 1
        }

        // Remove all characters of second string from hash table
        for (char in secString) {
            if (hashTable.containsKey(char)) {
                hashTable[char] = hashTable[char]!! - 1
                if (hashTable[char] == 0) {
                    hashTable.remove(char)
                }
            } else {
                return false
            }
        }

        // If hash table is empty return true else return false
        return hashTable.isEmpty()
    }

    /**
     * Check Anagram Using Hashtable Optimal
     * Step1: Check if the length of both strings are equal, if not return false
     * Step2: Create an array of size 26 and assuming only contains lowercase letter
     * Step3: Check both string and increment and decrement the count
     * Step4: Check if all the count are zero otherwise return false
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun checkIsAnagramUsingHashtableOptimal(firstStr: String, secString: String): Boolean {
        // Check length of the both string
        if (firstStr.length != secString.length) return false

        // Create an array of size 26 and assuming only contains lowercase letter
        val count = Array<Int>(26) { 0 }

        // Check both string and increment and decrement the count
        for (char in firstStr.indices) {
            count[firstStr[char] - 'a']++
            count[secString[char] - 'a']--
        }

        // Check if all the count are zero
        for (i in count) {
            if (i != 0) return false
        }

        return true
    }

}

fun main() {
    val validAnagram = ValidAnagram()
    println(validAnagram.checkIsAnagramSorting("racecar", "carrace")) // true
    println(validAnagram.checkIsAnagramUsingHashtable("racecar", "carrace")) // true
    println(validAnagram.checkIsAnagramUsingHashtableOptimal("jar", "jam")) // false
}