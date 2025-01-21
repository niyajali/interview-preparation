#include <iostream>

#include "ListNode.h"
using namespace std;


class MergeKSortedLinkedLists {
private:
    static ListNode *mergeList(ListNode *l1, ListNode *l2) {
        ListNode dummy;
        ListNode *tail = &dummy;

        while (l1 && l2) {
            if (l1->val < l2->val) {
                tail->next = l1;
                l1 = l1->next;
            } else {
                tail->next = l2;
                l2 = l2->next;
            }

            tail = tail->next;
        }
        if (l1) {
            tail->next = l1;
        }

        if (l2) {
            tail->next = l2;
        }

        return dummy.next;
    }

public:
    static ListNode *mergeKLists(vector<ListNode *> lists) {
        if (lists.empty()) {
            return nullptr;
        }

        while (lists.size() > 1) {
            vector<ListNode *> mergeLists;

            for (int i = 0; i < lists.size(); i += 2) {
                ListNode *l1 = lists[i];
                ListNode *l2 = (i + 1) < lists.size() ? lists[i + 1] : nullptr;

                mergeLists.push_back(mergeList(l1, l2));
            }

            lists = mergeLists;
        }

        return lists[0];
    }
};

int main() {
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(5);

    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);

    ListNode *l3 = new ListNode(2);
    l3->next = new ListNode(6);

    ListNode *result = MergeKSortedLinkedLists::mergeKLists(vector{ l1, l2, l3 });
    ListNode::printList(result);

    return 0;
}
