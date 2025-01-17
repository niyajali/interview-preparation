#include <iostream>

#include "ListNode.h"
using namespace std;

class RemoveNodeFromEndOfLinkedList {
public:
    static ListNode *rec(ListNode *head, int &n) {
        if (!head)
            return nullptr;

        head->next = rec(head->next, n);
        n--;

        if (n == 0)
            return head->next;

        return head;
    }
    static ListNode *removeNthFromEnd(ListNode *head, int n) { return rec(head, n); }
};

int main() {
    ListNode *head = ListNode::quickList({1, 2, 3, 4, 5});
    ListNode::printList(RemoveNodeFromEndOfLinkedList::removeNthFromEnd(head, 2));

    return 0;
}
