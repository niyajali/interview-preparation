package com.niyaj.neetcode

/**
 * Valid Parentheses
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 *
 * The input string s is valid if and only if:
 *
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "[]"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "([{}])"
 *
 * Output: true
 * Example 3:
 *
 * Input: s = "[(])"
 *
 * Output: false
 * Explanation: The brackets are not closed in the correct order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 */
private object ValidParentheses {

    /**
     * This function returns true if s is a valid string, and false otherwise.
     * Brute force approach is used to solve this problem.
     * Step1: Iterate through the string s
     * Step2: If the string contains "()", "{}", or "[]", replace them with an empty string
     * Step3: Return true if the string is empty, false otherwise
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     * @param s the input string
     * @return true if s is a valid string, and false otherwise
     */
    fun isValidBF(s: String): Boolean {
        var str = s
        while (str.contains("()") || str.contains("{}") || str.contains("[]")) {
            str = str.replace("()", "")
            str = str.replace("{}", "")
            str = str.replace("[]", "")
        }
        return str.isEmpty()
    }

    /**
     * This function returns true if s is a valid string, and false otherwise.
     * Stack is used to solve this problem.
     * Step1: Initialize a stack and a map to store the mapping of open and close brackets
     * Step2: Iterate through the string s
     * Step3: If the character is a close bracket, check if the stack is empty or the top of the stack is not the corresponding open bracket
     * Step4: If the character is an open bracket, add it to the stack
     * Step5: Return true if the stack is empty, false otherwise
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param s the input string
     * @return true if s is a valid string, and false otherwise
     *
     */
    fun isValid(s: String): Boolean {
        // Initialize a stack and a map to store the mapping of open and close brackets
        val stack = ArrayDeque<Char>()

        // Map to store the mapping of open and close brackets
        val map = hashMapOf(')' to '(', '}' to '{', ']' to '[')

        for (c in s) { // Iterate through the string s
            if (c in map) { // If the character is a close bracket
                if (stack.isNotEmpty() && stack.first() == map[c]) { // Check if the stack is empty or the top of the stack is not the corresponding open bracket
                    stack.removeFirst() // Remove the open bracket from the stack
                } else {
                    return false // Return false if the stack is empty or the top of the stack is not the corresponding open bracket
                }
            } else {
                // If the character is an open bracket, add it to the stack
                stack.addFirst(c)
            }
        }
        // Return true if the stack is empty, false otherwise
        return stack.isEmpty()
    }
}

fun main() {
    // Test cases
    println(ValidParentheses.isValid("[]")) // true
    println(ValidParentheses.isValid("([{}])")) // true
    println(ValidParentheses.isValid("[(])")) // false
    println(ValidParentheses.isValid("()[]{}")) // true
    println(ValidParentheses.isValid("([)]")) // false
    println(ValidParentheses.isValid("{[]}")) // true
    println(ValidParentheses.isValid("]")) // false
    println(ValidParentheses.isValid("[)")) // false
    println(ValidParentheses.isValid("())")) // true
    println(ValidParentheses.isValid("()[]{}")) // true
    println(ValidParentheses.isValid("(]")) // false
    println(ValidParentheses.isValid("([)]")) // false
    println(ValidParentheses.isValid("{[]}")) // true
    println(ValidParentheses.isValid("]")) // false
    println(ValidParentheses.isValid("[")) // false
    println(ValidParentheses.isValid("()")) // true
    println(ValidParentheses.isValid("()[]{}")) // true
    println(ValidParentheses.isValid("(]")) // false
    println(ValidParentheses.isValid("[")) // false
    println(ValidParentheses.isValid("()")) // true
    println(ValidParentheses.isValid("()[]{}")) // true
    println(ValidParentheses.isValid("(]")) // false
    println(ValidParentheses.isValid("([)]")) // false
    println(ValidParentheses.isValid("{[]}")) // true
    println(ValidParentheses.isValid("]")) // false
    println(ValidParentheses.isValid("[")) // false
    println(ValidParentheses.isValid("()")) // true
    println(ValidParentheses.isValid("()[]{}")) // true
    println(ValidParentheses.isValid("(]")) // false
    println(ValidParentheses.isValid("([)]")) // false
    println(ValidParentheses.isValid("{[]}")) // true
    println(ValidParentheses.isValid("]")) // false
    println(ValidParentheses.isValid("[")) // false
}