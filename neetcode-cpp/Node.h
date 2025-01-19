#ifndef NODE_H
#define NODE_H

#include <iostream>
#include <vector>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;

    // Constructor to initialize value and default null pointers.
    Node(int value) : val(value), next(nullptr), random(nullptr) {}

    // Constructor to initialize value and next pointer.
    Node(int value, Node* nextNode) : val(value), next(nextNode), random(nullptr) {}

    // Static method to create a linked list from a vector of integers.
    static Node* quickList(const vector<int>& values) {
        if (values.empty()) return nullptr;

        Node* head = new Node(values[0]);
        Node* current = head;
        for (size_t i = 1; i < values.size(); ++i) {
            current->next = new Node(values[i]);
            current = current->next;
        }
        return head;
    }

    // Static method to print the linked list along with random pointers.
    static void printList(Node* head) {
        Node* current = head;
        while (current) {
            int randomVal = current->random ? current->random->val : -1;
            cout << "Node value: " << current->val
                 << ", Random points to: " << (randomVal == -1 ? "null" : to_string(randomVal)) << endl;
            current = current->next;
        }
    }
};

#endif //NODE_H
