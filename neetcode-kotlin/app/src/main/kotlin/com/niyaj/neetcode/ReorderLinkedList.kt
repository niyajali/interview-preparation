package com.niyaj.neetcode

/**
 * Reorder Linked List
 * You are given the head of a singly linked-list.
 *
 * The positions of a linked list of length = 7 for example, can intially be represented as:
 *
 * [0, 1, 2, 3, 4, 5, 6]
 *
 * Reorder the nodes of the linked list to be in the following order:
 *
 * [0, 6, 1, 5, 2, 4, 3]
 *
 * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
 *
 * [0, n-1, 1, n-2, 2, n-3, ...]
 *
 * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
 *
 * Example 1:
 *
 * Input: head = [2,4,6,8]
 *
 * Output: [2,8,4,6]
 * Example 2:
 *
 * Input: head = [2,4,6,8,10]
 *
 * Output: [2,10,4,8,6]
 * Constraints:
 *
 * 1 <= Length of the list <= 1000.
 * 1 <= Node.val <= 1000
 */
object ReorderLinkedList {
    /**
     * Reorder the linked list in the following order:
     * [0, n-1, 1, n-2, 2, n-3, ...]
     * Step1: Find the middle of the linked list
     * Step2: Split the linked list into two halves
     * Step3: Reverse the second half of the linked list
     * Step4: Merge the two halves alternately
     * Step5: Done
     *
     * @param head The head of the linked list
     * @return The reordered linked list
     */
    fun reorderList(head: ListNode?) {
        if (head == null || head.next == null) return

        // Find the middle of the linked list
        var slow = head
        var fast = head.next
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Split the linked list into two halves
        var second = slow?.next
        slow?.next = null

        // Reverse the second half of the linked list
        var prev: ListNode? = null
        var current = second
        while (current != null) {
            var temp = current.next
            current.next = prev
            prev = current
            current = temp
        }

        // At this point, prev is the head of the reversed second half

        // Step 5: Merge the two halves alternately
        var first: ListNode? = head      // Pointer to the first half
        var secondList: ListNode? = prev // Pointer to the reversed second half
        while (secondList != null) {
            val tmp1 = first?.next      // Save the next node in the first half
            val tmp2 = secondList.next // Save the next node in the second half

            first?.next = secondList    // Link the current node from the first half to the second half
            secondList.next = tmp1     // Link the current node from the second half to the next node in the first half

            first = tmp1               // Move to the next node in the first half
            secondList = tmp2          // Move to the next node in the second half
        }
    }
}

fun main() {
    val head = ListNode.quickList(listOf(2, 4, 6, 8))
    head.printList()

    ReorderLinkedList.reorderList(head)
    head.printList()

    val head2 = ListNode.quickList(listOf(1, 2, 3, 4, 5, 6))
    head2.printList()

    ReorderLinkedList.reorderList(head2)
    head2.printList()
}