package com.niyaj.neetcode

class ListNode(var value: Int) {
    var next: ListNode? = null

    constructor(value: Int, next: ListNode?) : this(value) {
        this.next = next
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
