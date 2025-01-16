package com.niyaj.neetcode


/**
 * Reverse Linked List
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [0,1,2,3]
 *
 * Output: [3,2,1,0]
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 */
private class ReverseLinkedList constructor(var value: Int = -1, var next: ReverseLinkedList? = null) {
    override fun toString(): String {
        return "$value -> ${next.toString()}"
    }

    companion object {
        // a help function to generate a linked list with given values quickly, for test purpose only
        fun quickList(nodes: List<Int>): ReverseLinkedList {
            val dummy = ReverseLinkedList()
            nodes.reversed().forEach({
                val temp = ReverseLinkedList(it)
                temp.next = dummy.next
                dummy.next = temp
            })
            return dummy.next!!
        }
    }
}

fun main() {
    val listNode = ReverseLinkedList.quickList(listOf(0, 1, 2, 3))
    println(listNode)
}