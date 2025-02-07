#include <iostream>

#include "TreeNode.h"
using namespace std;

class ValidBinarySearchTree {
private:
    bool valid(TreeNode *root, int left, int right) {
        if (!root)
            return true;

        if (!(left < root->val && root->val < right)) {
            return false;
        }

        return valid(root->left, left, root->val) && valid(root->right, root->val, right);
    }

public:
    bool isValidBST(TreeNode *root) { return valid(root, INT_MIN, INT_MAX); }

    bool isValidBSTBFS(TreeNode *root) {
        if (!root)
            return true;

        queue<tuple<TreeNode *, int, int>> q;
        q.emplace(root, INT_MIN, INT_MAX);

        while (!q.empty()) {
            auto [node, left, right] = q.front();
            q.pop();

            if (node->val <= left || node->val >= right)
                return false;

            if (node->left) {
                q.emplace(node->left, left, node->val);
            }
            if (node->right) {
                q.emplace(node->right, node->val, right);
            }
        }

        return true;
    }
};

int main() {
    const auto root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);

    cout << ValidBinarySearchTree().isValidBST(root) << endl;
    cout << ValidBinarySearchTree().isValidBSTBFS(root) << endl;

    auto *root2 = new TreeNode(1);
    root2->left = new TreeNode(2);
    root2->right = new TreeNode(3);
    root2->left->left = new TreeNode(4);
    root2->left->right = new TreeNode(5);

    cout << ValidBinarySearchTree().isValidBST(root2) << endl;
    cout << ValidBinarySearchTree().isValidBSTBFS(root2) << endl;

    return 0;
}
