#include <iostream>

#include "ListNode.h"
using namespace std;

class ReverseNodesInKGroup {
public:
    static ListNode *reverseKGroup(ListNode *head, int k) {
        auto *dummy = new ListNode(0, head);
        ListNode *groupPrev = dummy;

        while (true) {
            ListNode *kth = getKNode(groupPrev, k);
            if (!kth) {
                break;
            }

            ListNode *groupNext = kth->next;

            ListNode *prev = kth->next;
            ListNode *curr = groupPrev->next;
            while (curr != groupNext) {
                ListNode *temp = curr->next;
                curr->next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode *temp = groupPrev->next;
            groupPrev->next = kth;
            groupPrev = temp;
        }

        return dummy->next;
    }

private:
    static ListNode *getKNode(ListNode *curr, int k) {
        while (curr && k > 0) {
            curr = curr->next;
            k--;
        }

        return curr;
    }
};

int main() {

    ListNode *head = ListNode::quickList({2, 3, 4, 5});
    ListNode *result = ReverseNodesInKGroup::reverseKGroup(head, 2);
    ListNode::printList(result);

    ListNode *head1 = ListNode::quickList({2, 3, 6, 5});
    ListNode *result1 = ReverseNodesInKGroup::reverseKGroup(head1, 2);
    ListNode::printList(result1);

    return 0;
}
