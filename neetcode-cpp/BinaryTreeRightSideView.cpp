#include <iostream>

#include "TreeNode.h"
using namespace std;

class BinaryTreeRightSideView {
public:
    static vector<int> res;

    static vector<int> rightSideViewBFS(TreeNode *root) {
        if (root == nullptr)
            return {};

        queue<TreeNode *> q;
        q.push(root);
        vector<int> result;

        while (!q.empty()) {
            const TreeNode *rightSide = nullptr;
            const int size = q.size();

            for (int i = size; i > 0; i--) {
                const TreeNode *node = q.front();
                q.pop();
                
                if (node != nullptr) {
                    rightSide = node;
                    q.push(node->left);
                    q.push(node->right);
                }
            }

            if (rightSide == nullptr) {
                result.push_back(rightSide->val);
            }
        }

        return result;
    }

    /**
     * Depth First Search
     * Step1: If the size of the result vector is equal to the depth, add the current node's value to the result vector.
     * Step2: Recursively call the function for the right child and then the left child.
     * Step3: Return the result vector.
     *
     * @param root TreeNode*
     * @return vector<int>
     */
    static vector<int> rightSideViewDFS(TreeNode *root) {
        dfs(root, 0);
        return res;
    }

    static void dfs(TreeNode *root, int depth) {
        if (root == nullptr) {
            return;
        }

        if (res.size() == depth) {
            res.push_back(root->val);
        }

        dfs(root->right, depth + 1);
        dfs(root->left, depth + 1);
    }
};

int main() {
    auto *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->right = new TreeNode(5);

    vector<int> res = BinaryTreeRightSideView::rightSideViewBFS(root);
    for (const int i: res) {
        cout << i << " ";
    }

    vector<int> res2 = BinaryTreeRightSideView::rightSideViewBFS(root);
    for (const int i: res2) {
        cout << i << " ";
    }
}
