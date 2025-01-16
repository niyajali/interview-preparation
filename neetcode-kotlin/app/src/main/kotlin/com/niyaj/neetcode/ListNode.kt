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

// Helper function to print the linked list
fun ListNode?.printList() {
    var current = this
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    println("null")
}
