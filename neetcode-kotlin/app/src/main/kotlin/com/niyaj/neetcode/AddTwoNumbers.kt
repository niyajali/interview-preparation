package com.niyaj.neetcode

/**
 * Add Two Numbers
 * You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
 *
 * The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
 *
 * Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Return the sum of the two numbers as a linked list.
 *
 * Example 1:
 *
 *
 *
 * Input: l1 = [1,2,3], l2 = [4,5,6]
 *
 * Output: [5,7,9]
 *
 * Explanation: 321 + 654 = 975.
 * Example 2:
 *
 * Input: l1 = [9], l2 = [9]
 *
 * Output: [8,1]
 * Constraints:
 *
 * 1 <= l1.length, l2.length <= 100.
 * 0 <= Node.val <= 9
 */
object AddTwoNumbers {
    /**
     * Add two numbers represented as linked lists.
     * Step1: Create a dummy node to store the result.
     * Step2: Create a variable to store the current node.
     * Step3: Create a variable to store the carry.
     * Step4: Iterate through the linked lists until the end of both lists and carry is 0.
     * Step5: Add the values of the nodes and carry.
     * Step6: Update the carry.
     *
     * @param l1 The first linked list.
     * @param l2 The second linked list.
     * @return The sum of the two linked lists.
     *
     * Time complexity: O(n+m)
     * Space complexity: O(1)
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var carry = 0

        var p1 = l1
        var p2 = l2

        while (l1 != null || l2 != null || carry != 0){
            val v1 = l1?.value ?: 0
            val v2 = l2?.value ?: 0

            val sum = v1 + v2 + carry
            carry = sum / 10
            curr.next = ListNode(sum % 10)

            curr = curr.next!!
            p1 = p1?.next
            p2 = p2?.next
        }

        return dummy.next
    }
}

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(3)

    val l2 = ListNode(4)
    l2.next = ListNode(5)
    l2.next?.next = ListNode(6)

    val result = AddTwoNumbers.addTwoNumbers(l1, l2)
    println(result?.value) // 5
    println(result?.next?.value) // 7
    println(result?.next?.next?.value) // 9

    val l3 = ListNode(9)
    val l4 = ListNode(9)

    val result2 = AddTwoNumbers.addTwoNumbers(l3, l4)
    println(result2?.value) // 8
}