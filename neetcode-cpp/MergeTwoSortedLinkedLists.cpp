#include <iostream>

#include "ListNode.h"
using namespace std;

class MergeTwoSortedLinkedLists {
public:
    static auto mergeTwoLists(ListNode *list1, ListNode *list2) -> ListNode *;
};
ListNode *MergeTwoSortedLinkedLists::mergeTwoLists(ListNode *list1, ListNode *list2) {
    if (!list1)
        return list2;
    if (!list2)
        return list1;

    if (list1->val <= list2->val) {
        list1->next = mergeTwoLists(list1->next, list2);
        return list1;
    } else {
        list2->next = mergeTwoLists(list1, list2->next);
        return list2;
    }
}

int main() {
    auto *list1 = new ListNode(1);
    list1->next = new ListNode(2);
    list1->next->next = new ListNode(4);

    auto *list2 = new ListNode(1);
    list2->next = new ListNode(3);
    list2->next->next = new ListNode(4);

    ListNode *result = MergeTwoSortedLinkedLists::mergeTwoLists(list1, list2);

    ListNode::printList(result);

    return 0;
}
