#include <iostream>

#include "TreeNode.h"
using namespace std;

class BinaryTreeLevelOrderTraversal {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == nullptr) return result;

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            vector<int> level;
            int size = q.size();
        }
    }
};

int main(){
    cout<<"Hello World";
    return 0;
}