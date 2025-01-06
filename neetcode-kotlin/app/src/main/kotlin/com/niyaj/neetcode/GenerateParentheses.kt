package com.niyaj.neetcode

/**
 * Generate Parentheses
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 *
 * Example 1:
 *
 * Input: n = 1
 *
 * Output: ["()"]
 * Example 2:
 *
 * Input: n = 3
 *
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * You may return the answer in any order.
 *
 * Constraints:
 *
 * 1 <= n <= 7
 *
 */
private object GenerateParentheses {
    /**
     * Generate all well-formed parentheses strings that you can generate with n pairs of parentheses.
     * Step1: Create a mutable list to store the result
     * Step2: Create a mutable list to store the stack
     * Step3: Create a function to backtrack the open and close parentheses
     * Step4: Check if the open and close parentheses are equal to n
     * Step5: Add the stack to the result
     * Step6: Check if the open parentheses is less than n
     * Step7: Add the open parentheses to the stack
     * Step8: Recursively call the backtrack function
     * Step9: Remove the last element from the stack
     * Step10: Check if the close parentheses is less than the open parentheses
     * Step11: Add the close parentheses to the stack
     * Step12: Recursively call the backtrack function
     * Step13: Remove the last element from the stack
     * Step14: Call the backtrack function with 0, 0
     * Step15: Return the result
     * @param n an integer
     * @return all well-formed parentheses strings that you can generate with n pairs of parentheses
     * Space Complexity: O(n)
     * Time Complexity: O(2^n)
     */
    fun generateParenthesis(n: Int): List<String> {
        val stack = mutableListOf<String>()
        val res = mutableListOf<String>()

        fun backtrack(openN: Int, closeN: Int) {
            if (openN == n && closeN == n) {
                res.add(stack.joinToString(""))
                return
            }

            if (openN < n) {
                stack.add("(")
                backtrack(openN + 1, closeN)
                stack.removeAt(stack.lastIndex)
            }

            if (closeN < openN) {
                stack.add(")")
                backtrack(openN, closeN + 1)
                stack.removeAt(stack.lastIndex)
            }
        }

        backtrack(0, 0)
        return res
    }
}

fun main() {
    println(GenerateParentheses.generateParenthesis(3))
    println(GenerateParentheses.generateParenthesis(1))
    println(GenerateParentheses.generateParenthesis(7))

}