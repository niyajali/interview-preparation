#include <iostream>
#include <vector>

#include "TreeNode.h"
using namespace std;

class BalancedBinaryTree {
private:
    vector<int> dfs(const TreeNode *root) {
        if (root == nullptr) {
            return {1, 0};
        }

        vector<int> left = dfs(root->left);
        vector<int> right = dfs(root->right);
        bool isBalanced = left[0] == 1 && right[0] == 1 && abs(left[1] - right[1]) <= 1;
        int height = 1 + max(left[1], right[1]);

        return {isBalanced ? 1 : 0, height};
    }

public:
    bool isBalanced(TreeNode *root) { return dfs(root)[0] == 1; }
};

int main() {
    auto tree = TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.left->left = new TreeNode(4);
    tree.left->right = new TreeNode(5);
    tree.right->left = new TreeNode(6);
    tree.right->right = new TreeNode(7);

    cout << BalancedBinaryTree().isBalanced(&tree) << endl;

    const auto tree2 = new TreeNode(1);
    tree2->left = new TreeNode(2);
    tree2->left->left = new TreeNode(3);
    tree2->left->right = new TreeNode(3);
    tree2->left->left->left = new TreeNode(4);
    tree2->left->left->right = new TreeNode(4);
    tree2->left->left->left->left = new TreeNode(5);

    cout << BalancedBinaryTree().isBalanced(tree2) << endl;

    return 0;
}
