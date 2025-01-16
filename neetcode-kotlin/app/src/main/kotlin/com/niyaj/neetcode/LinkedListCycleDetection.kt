package com.niyaj.neetcode

/**
 * Linked List Cycle Detection
 * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * There is a cycle in a linked list if at least one node in the list that can be visited again by following the next pointer.
 *
 * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
 *
 * Note: index is not given to you as a parameter.
 *
 * Example 1:
 *
 *
 *
 * Input: head = [1,2,3,4], index = 1
 *
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 *
 *
 *
 * Input: head = [1,2], index = -1
 *
 * Output: false
 * Constraints:
 *
 * 1 <= Length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 * index is -1 or a valid index in the linked list.
 */
internal object LinkedListCycleDetection {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}

fun main() {

    val listNode = ListNode.quickList(listOf(1, 2, 3, 4))
    listNode?.next?.next?.next?.next = listNode.next
    println(LinkedListCycleDetection.hasCycle(listNode))

    val listNode2 = ListNode.quickList(listOf(1, 2))
    println(LinkedListCycleDetection.hasCycle(listNode2))
}