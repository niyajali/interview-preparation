#include <iostream>
using namespace std;

class ReverseLinkedList {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };

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
    ReverseLinkedList::ListNode *head = new ReverseLinkedList::ListNode(1);
    head->next = new ReverseLinkedList::ListNode(2);
    head->next->next = new ReverseLinkedList::ListNode(3);
    head->next->next->next = new ReverseLinkedList::ListNode(4);
    head->next->next->next->next = new ReverseLinkedList::ListNode(5);

    ReverseLinkedList::ListNode *result = ReverseLinkedList::reverseList(head);
    while (result) {
        cout << result->val << " ";
        result = result->next;
    }
    return 0;
}
