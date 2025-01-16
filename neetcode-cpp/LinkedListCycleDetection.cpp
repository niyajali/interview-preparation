#include <iostream>

#include "ListNode.h"
using namespace std;

class LinkedListCycleDetection {
public:
    static bool hasCycle(const ListNode *head) {
        const ListNode *slow = head;
        const ListNode *fast = head;

        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
};

int main() {
    auto *head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = head->next;

    cout << LinkedListCycleDetection::hasCycle(head) << endl;

    auto *head2 = new ListNode(1);
    head2->next = new ListNode(2);
    head2->next->next = new ListNode(3);

    cout << LinkedListCycleDetection::hasCycle(head2) << endl;

    return 0;
}
