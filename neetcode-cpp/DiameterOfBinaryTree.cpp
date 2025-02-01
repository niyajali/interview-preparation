#include <iostream>

#include "TreeNode.h"
using namespace std;

class DiameterOfBinaryTree {
private:
    int dfs(const TreeNode *root, int &res) {
        if (!root) {
            return 0;
        }

        const int left = dfs(root->left, res);
        const int right = dfs(root->right, res);
        res = max(res, left + right);
        return max(left, right) + 1;
    }

public:
    int diameterOfBinaryTree(const TreeNode *root) {
        int res = 0;
        dfs(root, res);
        return res;
    }
};

int main() {

    auto *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    cout << DiameterOfBinaryTree().diameterOfBinaryTree(root) << endl;


    auto *root2 = new TreeNode(4);
    root2->left = new TreeNode(2);
    root2->right = new TreeNode(5);
    root2->left->left = new TreeNode(1);
    root2->left->right = new TreeNode(3);
    cout << DiameterOfBinaryTree().diameterOfBinaryTree(root2) << endl;

    return 0;
}
