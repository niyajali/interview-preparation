#include <iostream>

#include "TreeNode.h"
using namespace std;

class SubtreeOfAnotherTree {
private:
    bool isSameTree(TreeNode *root, TreeNode *subRoot) {
        if (!root && !subRoot) {
            return true;
        }

        if (root && subRoot && root->val == subRoot->val) {
            return isSameTree(root->left, subRoot->left) && isSameTree(root->right, subRoot->right);
        }

        return false;
    }

public:
    bool isSubtree(TreeNode *root, TreeNode *subRoot) {
        if (!root) {
            return false;
        }

        if (!subRoot) {
            return true;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
};

int main() {
    auto *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);

    auto *subRoot = new TreeNode(5);
    subRoot->left = new TreeNode(6);
    subRoot->right = new TreeNode(7);

    cout << SubtreeOfAnotherTree().isSubtree(root, subRoot) << endl;

    auto *subRoot2 = new TreeNode(2);
    subRoot2->left = new TreeNode(4);

    cout << SubtreeOfAnotherTree().isSubtree(root, subRoot2) << endl;

    return 0;
}
