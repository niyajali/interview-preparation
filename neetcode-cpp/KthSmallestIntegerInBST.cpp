#include <iostream>
#include <stack>

#include "TreeNode.h"
using namespace std;

class KthSmallestIntegerInBST {
public:
    static int kthSmallest(TreeNode *root, int k) {
        stack<TreeNode *> s;
        TreeNode *curr = root;

        while (!s.empty() || curr != nullptr) {
            while (curr != nullptr) {
                s.push(curr);
                curr = curr->left;
            }

            curr = s.top();
            s.pop();
            k--;

            if (k == 0) {
                return curr->val;
            }

            curr = curr->right;
        }

        return -1;
    }
};

int main() {
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(1);
    root->right = new TreeNode(4);
    root->left->right = new TreeNode(2);

    cout << KthSmallestIntegerInBST::kthSmallest(root, 1) << endl;
    cout << KthSmallestIntegerInBST::kthSmallest(root, 2) << endl;
    cout << KthSmallestIntegerInBST::kthSmallest(root, 3) << endl;
    cout << KthSmallestIntegerInBST::kthSmallest(root, 4) << endl;

    return 0;
}
