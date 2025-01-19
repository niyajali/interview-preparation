#include <iostream>
#include <unordered_map>
#include "Node.h"
using namespace std;


class CopyLinkedListWithRandomPointer {
public:
    static Node *copyRandomList(Node *head) {
        unordered_map<Node *, Node *> map;
        Node *current = head;

        while (current != nullptr) {
            Node *copy = new Node(current->val);
            map[current] = copy;
            current = current->next;
        }

        current = head;
        while (current != nullptr) {
            Node *copy = map[current];
            copy->next = map[current->next];
            copy->random = map[current->random];
            current = current->next;
        }

        return map[head];
    }
};

int main() {
    const auto head = new Node(7);
    head->next = new Node(13);
    head->next->next = new Node(11);
    head->next->next->next = new Node(10);
    head->next->next->next->next = new Node(1);

    head->next->random = head;
    head->next->next->random = head->next->next->next->next;
    head->next->next->next->random = head->next->next;
    head->next->next->next->next->random = head;

    const auto result = CopyLinkedListWithRandomPointer::copyRandomList(head);
    Node::printList(result);

    return 0;
}
