package com.niyaj.neetcode

/**
 * Remove Node From End of Linked List
 * You are given the beginning of a linked list head, and an integer n.
 *
 * Remove the nth node from the end of the list and return the beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4], n = 2
 *
 * Output: [1,2,4]
 * Example 2:
 *
 * Input: head = [5], n = 1
 *
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 2
 *
 * Output: [2]
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
object RemoveNodeFromEndOfLinkedList {
    /**
     * Recursive function to remove the nth node from the end of the list.
     * Step1: Recursively call the function until the end of the list is reached.
     * Step2: Decrement the value of n.
     * Step3: If n is 0, then remove the nth node from the end.
     * Step4: Return the beginning of the list.
     *
     * @param head The beginning of the linked list.
     * @param n The nth node from the end of the list.
     * @return The beginning of the list after removing the nth node from the end.
     */
    private fun rec(head: ListNode?, n: IntArray): ListNode? {
        if (head == null) return null

        head.next = rec(head.next, n)
        n[0]--

        return if (n[0] == 0) head.next else head
    }

    /**
     * Remove the nth node from the end of the list.
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        return rec(head, intArrayOf(n))
    }
}

fun main() {
    val listNode = ListNode.quickList(listOf(1, 2, 3, 4))
    RemoveNodeFromEndOfLinkedList.removeNthFromEnd(listNode, 2)?.printList()

    val listNode2 = ListNode.quickList(listOf(5))
    RemoveNodeFromEndOfLinkedList.removeNthFromEnd(listNode2, 1)?.printList()

    val listNode3 = ListNode.quickList(listOf(1, 2))
    RemoveNodeFromEndOfLinkedList.removeNthFromEnd(listNode3, 1)?.printList()
}