package com.niyaj.neetcode

/**
 * Group Anagrams
 *
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 *
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 *
 * Input: strs = ["x"]
 *
 * Output: [["x"]]
 * Example 3:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 * Constraints:
 *
 * 1 <= strs.length <= 1000.
 * 0 <= strs[i].length <= 100
 * strs[i] is made up of lowercase English letters.
 */

private object GroupAnagrams {

    /**
     * Group all anagrams together into sublists.
     * Step1: Create a mutable map to store the key-value pair of the sorted string and the list of anagrams
     * Step2: Iterate through the list of strings
     * Step3: Sort the string and convert it to a string
     * Step4: Check if the map contains the key
     * Step5: If the map contains the key, add the string to the list of anagrams
     * Step6: If the map does not contain the key, create a new list and add the string to the list
     * Step7: Return the list of anagrams
     * @param strs an array of strings
     * @return the list of anagrams
     * Space Complexity: O(n)
     * Time Complexity: O(n * m * log m)
     */
    fun groupAnagramsUsingSorting(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (str in strs){
            val sortedStr = str.toCharArray().sorted().joinToString("")

            if (map.containsKey(sortedStr)){
                map[sortedStr]?.add(str)
            } else {
                map[sortedStr] = mutableListOf(str)
            }
        }

        return map.values.toList()
    }

    /**
     * Group all anagrams together into sublist.
     * Step1: Create a mutable map to store the key-value pair of the count of characters and the list of anagrams
     * Step2: Iterate through the list of strings
     * Step3: Create an array of 26 integers to store the count of characters
     * Step4: Iterate through the string and increment the count of the character
     * Step5: Create a key by concatenating the count of characters
     * Step6: Check if the map contains the key
     * Step7: If the map contains the key, add the string to the list of anagrams
     * Step8: If the map does not contain the key, create a new list and add the string to the list
     * Step9: Return the list of anagrams
     * @param strs an array of strings
     * @return the list of anagrams
     * Space Complexity: O(n)
     * Time Complexity: O(n * m)
     */
    fun groupAnagramUsingHashTable(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (str in strs){
            val count = IntArray(26)

            for (c in str){
                count[c - 'a']++
            }

            var key = count[0].toString()

            for (c in 1 until 26){
                key += "," + count[c].toString()
            }

            if (map.containsKey(key)){
                map[key]?.add(str)
            } else {
                map[key] = mutableListOf(str)
            }
        }

        return map.values.toList()
    }
}

fun main() {
    val strs = arrayOf("act","pots","tops","cat","stop","hat")
    val str2 = arrayOf("x")

    val groupAnagramsUsingSorting = GroupAnagrams.groupAnagramsUsingSorting(strs)
    val groupAnagramUsingHashTable = GroupAnagrams.groupAnagramUsingHashTable(strs)
    val groupAnagramsUsingSorting2 = GroupAnagrams.groupAnagramsUsingSorting(str2)

    println(groupAnagramsUsingSorting)
    println(groupAnagramUsingHashTable)
    println(groupAnagramsUsingSorting2)

}