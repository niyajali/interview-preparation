package com.niyaj.neetcode

/**
 * Encode and Decode Strings
 * Solved
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Example 1:
 *
 * Input: ["neet","code","love","you"]
 *
 * Output:["neet","code","love","you"]
 * Example 2:
 *
 * Input: ["we","say",":","yes"]
 *
 * Output: ["we","say",":","yes"]
 * Constraints:
 *
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 */

private object EncodeAndDecodeStrings {

    /**
     * Encode a list of strings to a single string.
     * Step1: Create an empty string to store the encoded string
     * Step2: Iterate through the list of strings
     * Step3: Add the length of the string and the string to the encoded string
     * Step4: Return the encoded string
     * @param str a list of strings
     * @return the encoded string
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     *
     * input: ["neet","code","love","you"]
     */
    fun encode(str: List<String>): String {
        var encodedString = ""

        for (s in str) {
            encodedString += s.length.toString() + "@" + s
        }
        // encodedString: "4@neet4@code4@love3@you"

        return encodedString
    }

    // input: "4@neet4@code4@love3@you"
    fun decode(str: String): List<String> {
        val decodedString = mutableListOf<String>()
        var i = 0

        while (i < str.length){
            // i = 0
            val at = str.indexOf('@', i)
            // at = 1
            val size = str.substring(i, at).toInt()
            // size = 4
            val word = str.substring(at + 1, at + 1 + size)
            // word = "neet"

            decodedString.add(word)
            // decodedString = ["neet"]

            i = at + size + 1
            // i = 6
        }

        return decodedString
    }
}

fun main() {
    val str = listOf("neet", "code", "love", "you")
    println(str.toString())

    val encodedString = EncodeAndDecodeStrings.encode(str)
    println(encodedString) // 4@neet4@code4@love3@you

    val decodedString = EncodeAndDecodeStrings.decode(encodedString)
    println(decodedString) // [neet, code, love, you]
}