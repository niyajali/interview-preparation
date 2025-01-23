#include<iostream>

#include "TreeNode.h"
using namespace std;

class InvertBinaryTree {
public:
    /**
     * Inverts the binary tree.
     * Step1: Recursively invert the left and right subtrees.
     * Step2: Swap the left and right subtrees.
     * Step3: Return the root node.
     *
     * @param root TreeNode
     * @return TreeNode
     */
    static TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;

        TreeNode* left = invertTree(root->left);
        TreeNode* right = invertTree(root->right);

        root->left = right;
        root->right = left;

        return root;
    }
};

int main() {
    TreeNode* root = TreeNode::quickTree({4, 2, 7, 1, 3, 6, 9});
    TreeNode::printTree(root);


    TreeNode::printTree(InvertBinaryTree::invertTree(root));

    return 0;
}