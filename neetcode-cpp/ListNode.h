#ifndef LISTNODE_H
#define LISTNODE_H

#include <iostream> // For printing

struct ListNode {
    int val;
    ListNode* next;

    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}

    // Static helper function to print a linked list
    static void printList(ListNode* head) {
        ListNode* current = head;
        while (current) {
            std::cout << current->val << " -> ";
            current = current->next;
        }
        std::cout << "null" << std::endl;
    }
};

#endif // LISTNODE_H
