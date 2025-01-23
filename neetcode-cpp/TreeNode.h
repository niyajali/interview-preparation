#ifndef TREENODE_H
#define TREENODE_H

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    // Constructor to initialize the value with null child pointers.
    TreeNode(int value) : val(value), left(nullptr), right(nullptr) {}

    // Constructor to initialize value with given left and right children.
    TreeNode(int value, TreeNode* leftChild, TreeNode* rightChild)
        : val(value), left(leftChild), right(rightChild) {}

    // Static method to create a binary tree from a vector of optional integers.
    static TreeNode* quickTree(const vector<int>& values) {
        if (values.empty()) return nullptr;

        TreeNode* root = new TreeNode(values[0]);
        queue<TreeNode*> nodeQueue;
        nodeQueue.push(root);

        size_t i = 1;
        while (i < values.size()) {
            TreeNode* current = nodeQueue.front();
            nodeQueue.pop();

            // Create left child if the value is not -1 (indicating null).
            if (i < values.size() && values[i] != -1) {
                current->left = new TreeNode(values[i]);
                nodeQueue.push(current->left);
            }
            ++i;

            // Create right child if the value is not -1 (indicating null).
            if (i < values.size() && values[i] != -1) {
                current->right = new TreeNode(values[i]);
                nodeQueue.push(current->right);
            }
            ++i;
        }

        return root;
    }

    // Static method to print the tree in a structured ASCII-compatible format
    static void printTree(TreeNode* root, string indent = "", bool isRight = true) {
        if (!root) return;

        cout << indent;
        if (isRight) {
            cout << "+-- "; // Right child
        } else {
            cout << "|-- "; // Left child
        }
        cout << root->val << endl;

        indent += isRight ? "    " : "|   ";
        printTree(root->left, indent, false);
        printTree(root->right, indent, true);
    }

};

#endif //TREENODE_H
