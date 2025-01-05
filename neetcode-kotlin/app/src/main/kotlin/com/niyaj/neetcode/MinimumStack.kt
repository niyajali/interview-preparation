package com.niyaj.neetcode

/**
 * Minimum Stack
 * Design a stack class that supports the push, pop, top, and getMin operations.
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in
 * O(1)
 * O(1) time.
 *
 * Example 1:
 *
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 *
 * Output: [null,null,null,null,0,null,2,1]
 *
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top();    // return 2
 * minStack.getMin(); // return 1
 * Constraints:
 *
 * -2^31 <= val <= 2^31 - 1.
 * pop, top and getMin will always be called on non-empty stacks.
 *
 */
private class MinimumStack {
    private val stack = ArrayDeque<Int>()
    private val minimumStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        val minValue = minOf(`val`, minimumStack.lastOrNull() ?: `val`)
        minimumStack.add(minValue)
    }

    fun pop() {
        stack.removeLast()
        minimumStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minimumStack.last()
    }
}

fun main() {
    val minStack = MinimumStack()
    minStack.push(1)
    minStack.push(2)
    minStack.push(0)
    println(minStack.getMin()) // return 0
    minStack.pop()
    println(minStack.top())    // return 2
    println(minStack.getMin()) // return 1
}