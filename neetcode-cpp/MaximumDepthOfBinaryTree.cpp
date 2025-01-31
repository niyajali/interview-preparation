#include <iostream>;
#include <stack>

#include "TreeNode.h"
using namespace std;

class MaximumDepthOfBinaryTree {
public:
    static int maxDepth(TreeNode *root) {
        stack<pair<TreeNode *, int>> stack;
        int res = 0;

        while (!stack.empty()) {
            const auto [fst, snd] = stack.top();
            stack.pop();
            TreeNode *node = fst;
            int depth = snd;

            if (node != nullptr) {
                res = max(res, depth);
                stack.emplace(node->left, depth + 1);
                stack.emplace(node->right, depth + 1);
            }
        }

        return res;
    }
};

int main() {
    auto root = TreeNode::quickTree({3, 9, 20, -1, -1, 15, 7});
    auto result = MaximumDepthOfBinaryTree::maxDepth(root);
    cout << "The maximum depth of the binary tree is: " << result << endl;

    return 0;
}
