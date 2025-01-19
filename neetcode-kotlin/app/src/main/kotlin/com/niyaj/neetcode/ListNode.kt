package com.niyaj.neetcode

class ListNode(var value: Int) {
    var next: ListNode? = null

    constructor(value: Int, next: ListNode?) : this(value) {
        this.next = next
    }

    companion object {
        fun quickList(values: List<Int>): ListNode? {
            if (values.isEmpty()) return null

            val head = ListNode(values[0])
            var current = head
            for (i in 1 until values.size) {
                current.next = ListNode(values[i])
                current = current.next!!
            }
            return head
        }
    }
}

class Node(var value: Int) {
    var next: Node? = null
    var random: Node? = null

    // Secondary constructor to allow initializing both `val` and `next`.
    constructor(value: Int, next: Node?) : this(value) {
        this.next = next
    }

    companion object {
        /**
         * Creates a linked list from a list of integer values.
         * Random pointers are not set by this method.
         *
         * @param values A list of integers to create the nodes.
         * @return The head of the created linked list.
         */
        fun quickList(values: List<Int>): Node? {
            if (values.isEmpty()) return null

            val head = Node(values[0])
            var current = head
            for (i in 1 until values.size) {
                current.next = Node(values[i])
                current = current.next!!
            }
            return head
        }


    }
}


// Helper function to print the linked list
fun ListNode?.printList() {
    var current = this
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    println("null")
}


/**
 * Utility to print the linked list including random pointers.
 */
fun Node?.printList() {
    var current = this
    while (current != null) {
        val randomValue = current.random?.value ?: "null"
        println("Node value: ${current.value}, Random points to: $randomValue")
        current = current.next
    }
}