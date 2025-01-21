package com.niyaj.neetcode

/**
 * Merge K Sorted Linked Lists
 * You are given an array of k linked lists lists, where each list is sorted in ascending order.
 *
 * Return the sorted linked list that is the result of merging all of the individual linked lists.
 *
 * Example 1:
 *
 * Input: lists = [[1,2,4],[1,3,5],[3,6]]
 *
 * Output: [1,1,2,3,3,4,5,6]
 * Example 2:
 *
 * Input: lists = []
 *
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 *
 * Output: []
 * Constraints:
 *
 * 0 <= lists.length <= 1000
 * 0 <= lists[i].length <= 100
 * -1000 <= lists[i][j] <= 1000
 *
 */
object MergeKSortedLinkedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        var currentLists = lists.toList()
        while (currentLists.size > 1) {
            val mergedLists = mutableListOf<ListNode?>()
            for (i in currentLists.indices step 2) {
                val l1 = currentLists[i]
                val l2 = if (i + 1 < currentLists.size) currentLists[i + 1] else null
                mergedLists.add(mergeList(l1, l2))
            }
            currentLists = mergedLists
        }
        return currentLists[0]
    }

    private fun mergeList(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var list1 = l1
        var list2 = l2

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1
                list1 = list1.next
            } else {
                tail.next = list2
                list2 = list2.next
            }
            tail = tail.next!!
        }
        tail.next = list1 ?: list2
        return dummy.next
    }
}

fun main() {
    val list = ListNode.quickList(listOf(1,2,4))
    val list2 = ListNode.quickList(listOf(1,3,5))
    val list3 = ListNode.quickList(listOf(3,6))

    val result = MergeKSortedLinkedLists.mergeKLists(arrayOf(list, list2, list3))
    result.printList()
}