#ifndef LISTNODE_H
#define LISTNODE_H

#include <iostream> // For printing
#include <vector>

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}

    // Static helper function to print a linked list
    static void printList(ListNode *head) {
        ListNode *current = head;
        while (current) {
            std::cout << current->val << " -> ";
            current = current->next;
        }
        std::cout << "null" << std::endl;
    }

    // Static helper function to create a linked list from a vector
    static ListNode *quickList(const std::vector<int> &values) {
        if (values.empty())
            return nullptr;

        auto *head = new ListNode(values[0]);
        ListNode *current = head;

        for (size_t i = 1; i < values.size(); ++i) {
            current->next = new ListNode(values[i]);
            current = current->next;
        }

        return head;
    }
};

#endif // LISTNODE_H
