#include <iostream>

#include "ListNode.h"

using namespace std;

class ReverseLinkedList {
public:
    static ListNode *reverseList(ListNode *head) {
        ListNode *prev = nullptr;
        ListNode *curr = head;

        while (curr) {
            ListNode *temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
};

int main() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    auto* head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    std::cout << "Original List: ";
    ListNode::printList(head);

    // Reverse the linked list
    ListNode* reversedHead = ReverseLinkedList::reverseList(head);

    std::cout << "Reversed List: ";
    ListNode::printList(reversedHead);

    return 0;
}
