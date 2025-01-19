#include <iostream>
using namespace std;

#include "ListNode.h"

class RemoveNodeFromEndOfLinkedList {
public:
    /**
     * Step 1: Create a dummy node and set the current node to the dummy node
     * Step 2: Create a carry variable and set it to 0
     * Step 3: While l1 or l2 or carry is not 0
     * Step 4: Calculate the sum of l1, l2, and carry
     * Step 5: Update the carry variable
     * Step 6: Create a new node with the sum % 10
     * Step 7: Update the current node's next to the new node
     * Step 8: Update the current node to the new node
     * Step 9: Update l1 and l2 if they are not null
     * Step 10: Return the dummy node's next
     *
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    static ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode dummy(0);
        ListNode *current = &dummy;
        int carry = 0;

        while (l1 || l2 || carry) {
            const int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
            carry = sum / 10;
            current->next = new ListNode(sum % 10);

            current = current->next;
            if (l1)
                l1 = l1->next;
            if (l2)
                l2 = l2->next;
        }

        return dummy.next;
    }
};

int main() {
    ListNode *l1 = ListNode::quickList({2, 4, 3});
    ListNode *l2 = ListNode::quickList({5, 6, 4});

    const auto result = RemoveNodeFromEndOfLinkedList::addTwoNumbers(l1, l2);
    ListNode::printList(result); // 7 -> 0 -> 8 -> null

    ListNode *l3 = ListNode::quickList({0});
    ListNode *l4 = ListNode::quickList({0});

    const auto result2 = RemoveNodeFromEndOfLinkedList::addTwoNumbers(l3, l4);
    ListNode::printList(result2); // 0 -> null

    return 0;
}
