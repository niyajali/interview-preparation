package com.niyaj.neetcode

import kotlin.math.abs

/**
 * Balanced Binary Tree
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 *
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,null,null,4]
 *
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: root = [1,2,3,null,null,4,null,5]
 *
 * Output: false
 * Example 3:
 *
 * Input: root = []
 *
 * Output: true
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */
object BalancedBinaryTree {
    fun isBalanced(root: TreeNode<Int?>?): Boolean {
        return dfs(root).first
    }

    /**
     * Depth First Search
     * Step1: If root is null, return true and 0
     * Step2: Recursively call dfs for left and right nodes
     * Step3: Check if left and right nodes are balanced and the difference between their heights is less than or equal to 1
     * Step4: Return the result and the height of the current node
     * Step5: Repeat the above steps for all the nodes
     * Step6: Return the result
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     *
     * @param root TreeNode
     * @return Pair<Boolean, Int>
     *
     */
    private fun dfs(root: TreeNode<Int?>?): Pair<Boolean, Int> {
        if (root == null) {
            return Pair(true, 0)
        }

        val left = dfs(root.left)
        val right = dfs(root.right)

        val isBalanced = left.first && right.first && abs(left.second - right.second) <= 1
        val height = maxOf(left.second, right.second) + 1
        return Pair(isBalanced, height)
    }
}

fun main() {
    val root: TreeNode<Int?> = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = null
    root.left?.right = null
    root.right?.left = TreeNode(4)
    root.right?.right = null
    root.right?.left?.left = TreeNode(5)

    println(BalancedBinaryTree.isBalanced(root))

    val root2: TreeNode<Int?> = TreeNode(null)
    println(BalancedBinaryTree.isBalanced(root2))

}