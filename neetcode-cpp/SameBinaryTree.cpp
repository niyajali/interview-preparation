#include <iostream>
#include <stack>

#include "TreeNode.h"

using namespace std;

class SameBinaryTree {
public:
    static bool isSameTree(TreeNode *p, TreeNode *q) {
        stack<pair<TreeNode *, TreeNode *>> s;
        s.emplace(p, q);

        while (!s.empty()) {
            auto [node1, node2] = s.top();
            s.pop();

            if (node1 == nullptr && node2 == nullptr)
                continue;

            if (!node1 || !node2)
                return false;
            if (node1->val != node2->val)
                return false;

            s.emplace(node1->right, node2->right);
            s.emplace(node1->left, node2->left);
        }
    }
};

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}
