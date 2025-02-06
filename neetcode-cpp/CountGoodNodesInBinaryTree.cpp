#include <iostream>

#include "TreeNode.h"
using namespace std;

#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

class CountGoodNodesInBinaryTree {
private:
    int dfs(TreeNode *root, int maxVal) {
        if (root == nullptr)
            return 0;

        int res = root->val >= maxVal ? 1 : 0;

        maxVal = max(maxVal, root->val);
        res += dfs(root->left, maxVal);
        res += dfs(root->right, maxVal);
        return res;
    }

public:
    CountGoodNodesInBinaryTree() {
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(nullptr);
        std::cout.tie(nullptr);
    }

    int answer = 0;

    inline void solution(TreeNode *node, int maximum) {
        if (!node)
            return;
        if (node->val >= maximum) {
            maximum = node->val;
            answer++;
        }

        solution(node->left, maximum);
        solution(node->right, maximum);

        node->left = node->right = nullptr;
    }

    int goodNodes(TreeNode *root) {
        solution(root, root->val);
        return answer;
    }

    int goodNodesDFS(TreeNode *root) { return dfs(root, root->val); }

    static int goodNodesBFS(TreeNode *root) {
        int res = 0;
        queue<pair<TreeNode *, int>> q;
        q.emplace(root, -INT_MAX);

        while (!q.empty()) {
            auto [node, maxVal] = q.front();
            q.pop();

            if (node->val >= maxVal) {
                res++;
            }

            int newMax = max(maxVal, node->val);
            if (node->left) {
                q.emplace(node->left, newMax);
            }

            if (node->right) {
                q.emplace(node->right, newMax);
            }
        }

        return res;
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

    cout << CountGoodNodesInBinaryTree().goodNodesDFS(root) << endl;
    cout << CountGoodNodesInBinaryTree::goodNodesBFS(root) << endl;
    cout << CountGoodNodesInBinaryTree().goodNodes(root) << endl;

    // Input: root = [2,1,1,3,null,1,5]
    auto *root2 = new TreeNode(2);
    root2->left = new TreeNode(1);
    root2->right = new TreeNode(1);
    root2->left->left = new TreeNode(3);
    root2->left->right = new TreeNode(1);
    root2->right->right = new TreeNode(5);

    cout << CountGoodNodesInBinaryTree().goodNodes(root2) << endl;
    cout << CountGoodNodesInBinaryTree().goodNodesDFS(root2) << endl;
    cout << CountGoodNodesInBinaryTree::goodNodesBFS(root2) << endl;

    return 0;
}
