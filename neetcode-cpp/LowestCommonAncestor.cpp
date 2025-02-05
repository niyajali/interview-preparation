#include <iostream>
using namespace std;

#include "TreeNode.h"

class LowestCommonAncestor {
public:
    static TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
        TreeNode *curr = root;

        while (curr) {
            if (p->val < curr->val && q->val < curr->val) {
                curr = curr->left;
            } else if (p->val > curr->val && q->val > curr->val) {
                curr = curr->right;
            } else {
                return curr;
            }
        }

        return nullptr;
    }
};

int main() {

    auto *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

    TreeNode::printTree(root);

    const TreeNode *result = LowestCommonAncestor::lowestCommonAncestor(root, root->left, root->right);
    cout << result->val << endl;

    const TreeNode *result2 = LowestCommonAncestor::lowestCommonAncestor(root, root->right->left, root->right->right);
    cout << result2->val << endl;

    return 0;
}
