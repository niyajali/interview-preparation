package com.niyaj.neetcode

/**
 * Evaluate Reverse Polish Notation
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 *
 * Return the integer that represents the evaluation of the expression.
 *
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 *
 * Input: tokens = ["1","2","+","3","*","4","-"]
 *
 * Output: 5
 *
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * Constraints:
 *
 * 1 <= tokens.length <= 1000.
 * tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
 */
private object EvaluateReversePolishNotation {
    /**
     * Evaluate the Reverse Polish Notation
     * Step1: Create a stack to store the numbers
     * Step2: Iterate through the list of tokens
     * Step3: Check if the token is an operator
     * Step4: Perform the operation based on the operator
     * Step5: Add the result to the stack
     * Step6: Return the first element in the stack
     * @param tokens an array of strings
     * @return the integer that represents the evaluation of the expression
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            when (token) {
                "+" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.addLast(a + b)
                }

                "-" -> {
                    val first = stack.removeLast()
                    val second = stack.removeLast()
                    stack.addLast(second - first)
                }

                "*" -> stack.addLast(stack.removeLast() * stack.removeLast())

                "/" -> {
                    val first = stack.removeLast()
                    val second = stack.removeLast()
                    stack.addLast(second / first)
                }

                else -> stack.addLast(token.toInt())
            }
        }

        return stack.first()
    }
}

fun main() {
    val tokens = arrayOf("1", "2", "+", "3", "*", "4", "-")
    println(EvaluateReversePolishNotation.evalRPN(tokens)) // Output: 5

    val tokens2 = arrayOf("4", "13", "5", "/", "+")
    println(EvaluateReversePolishNotation.evalRPN(tokens2)) // Output: 6

    val tokens4 = arrayOf("2", "1", "+", "3", "*")
    println(EvaluateReversePolishNotation.evalRPN(tokens4)) // Output: 9
}