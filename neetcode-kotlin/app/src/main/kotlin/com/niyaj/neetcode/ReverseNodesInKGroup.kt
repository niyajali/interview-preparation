package com.niyaj.neetcode

/**
 * Reverse Nodes in K-Group
 * You are given the head of a singly linked list head and a positive integer k.
 *
 * You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are fewer than k nodes left, leave the nodes as they are.
 *
 * Return the modified list after reversing the nodes in each group of k.
 *
 * You are only allowed to modify the nodes' next pointers, not the values of the nodes.
 *
 * Example 1:
 *
 *
 *
 * Input: head = [1,2,3,4,5,6], k = 3
 *
 * Output: [3,2,1,6,5,4]
 * Example 2:
 *
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 *
 * Output: [3,2,1,4,5]
 * Constraints:
 *
 * The length of the linked list is n.
 * 1 <= k <= n <= 100
 * 0 <= Node.val <= 100
 *
 */
object ReverseNodesInKGroup {
    /**
     * Reverse Nodes in K-Group
     * You are given the head of a singly linked list head and a positive integer k.
     * Step1: Create a dummy node and assign head to dummy.next
     * Step2: Create a groupPrev node and assign dummy to groupPrev
     * Step3: Loop through the linked list until kth node is null
     * Step4: Get the kth node
     * Step5: Get the next node of kth node
     * Step6: Assign the next node of kth node to prev node
     * Step7: Assign the prev node to current node
     * Step8: Assign the next node to current node
     * Step9: Assign the groupPrev.next to kth node
     * Step10: Assign the groupPrev to temp
     *
     * @param head ListNode
     * @param k Int
     * @return ListNode
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head

        var dummy = ListNode(0)
        dummy.next = head

        var groupPrev: ListNode? = dummy

        while (true) {
            val kth = getKth(groupPrev, k)
            if (kth == null) break

            val groupNext = kth.next

            var prev: ListNode? = groupNext
            var curr = groupPrev!!.next

            while (curr != groupNext) {
                val next = curr!!.next
                curr.next = prev
                prev = curr
                curr = next
            }

            var temp = groupPrev.next
            groupPrev.next = kth
            groupPrev = temp
        }

        return dummy.next
    }

    private fun getKth(curr: ListNode?, k: Int): ListNode? {
        var curr = curr
        var k = k

        while (curr != null && k > 0) {
            curr = curr.next
            k--
        }

        return curr
    }
}

fun main() {
    val head = ListNode.quickList(listOf(1, 2, 3, 4, 5, 6))
    ReverseNodesInKGroup.reverseKGroup(head, 3).printList()

    val head2 = ListNode.quickList(listOf(1, 2, 3, 4, 5))
    ReverseNodesInKGroup.reverseKGroup(head2, 3).printList()

    val head3 = ListNode.quickList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    ReverseNodesInKGroup.reverseKGroup(head3, 3).printList()
}