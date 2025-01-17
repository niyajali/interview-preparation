#include <iostream>
using namespace std;

#include "ListNode.h"

class ReorderLinkedList {
public:
    static void reorderList(ListNode *head) {
        // Base case
        if (head == nullptr || head->next == nullptr) {
            return;
        }

        ListNode *slow = head;
        const ListNode * fast = head->next;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* second = slow->next;
        ListNode* prev = slow->next = nullptr;
        while (second != nullptr) {
            ListNode* tmp = second->next;
            second->next = prev;
            prev = second;
            second = tmp;
        }

        ListNode* first = head;
        second = prev;
        while (second != nullptr) {
            ListNode* tmp1 = first->next;
            ListNode* tmp2 = second->next;
            first->next = second;
            second->next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    };
};

int main() {
    ListNode *head = ListNode::quickList({1, 2, 3, 4, 5});
    ReorderLinkedList::reorderList(head);
    ListNode::printList(head);

    ListNode *head2 = ListNode::quickList({1, 2, 3, 4, 5, 6});
    ReorderLinkedList::reorderList(head2);
    ListNode::printList(head2);

    return 0;
}
