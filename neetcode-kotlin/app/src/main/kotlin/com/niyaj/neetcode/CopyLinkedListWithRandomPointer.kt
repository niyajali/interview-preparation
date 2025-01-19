package com.niyaj.neetcode

/**
 * Copy Linked List with Random Pointer
 * You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
 *
 * Create a deep copy of the list.
 *
 * The deep copy should consist of exactly n new nodes, each including:
 *
 * The original value val of the copied node
 * A next pointer to the new node corresponding to the next pointer of the original node
 * A random pointer to the new node corresponding to the random pointer of the original node
 * Note: None of the pointers in the new list should point to nodes in the original list.
 *
 * Return the head of the copied linked list.
 *
 * In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
 *
 * Example 1:
 *
 *
 *
 * Input: head = [[3,null],[7,3],[4,0],[5,1]]
 *
 * Output: [[3,null],[7,3],[4,0],[5,1]]
 * Example 2:
 *
 *
 *
 * Input: head = [[1,null],[2,2],[3,2]]
 *
 * Output: [[1,null],[2,2],[3,2]]
 * Constraints:
 *
 * 0 <= n <= 100
 * -100 <= Node.val <= 100
 * random is null or is pointing to some node in the linked list.
 */
object CopyLinkedListWithRandomPointer {
    fun copyRandomList(head: Node?): Node? {
        val oldCopy = hashMapOf<Node?, Node?>(null to null)

        var curr = head
        while (curr != null){
            val copy = Node(curr.value)
            oldCopy[curr] = copy
            curr = curr.next
        }

        curr = head
        while (curr != null){
            val copy = oldCopy[curr]
            copy?.next = oldCopy[curr.next]
            copy?.random = oldCopy[curr.random]
            curr = curr.next
        }

        return oldCopy[head]
    }
}

fun main() {
    val head = Node.quickList(listOf(3, 7, 4, 5))
    head?.random = null
    head?.next?.random = head
    head?.next?.next?.random = head.next?.next?.next
    head?.next?.next?.next?.random = head.next

    val result = CopyLinkedListWithRandomPointer.copyRandomList(head)
    result?.printList()

    val head2 = Node.quickList(listOf(1, 2, 3))
    head2?.random = null
    head2?.next?.random = head2.next
    head2?.next?.next?.random = head2.next
    val result2 = CopyLinkedListWithRandomPointer.copyRandomList(head2)
    result2?.printList()
}