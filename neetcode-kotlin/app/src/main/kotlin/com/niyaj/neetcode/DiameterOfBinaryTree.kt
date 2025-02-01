package com.niyaj.neetcode

/**
 * Diameter of Binary Tree
 * The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.
 *
 * The length of a path between two nodes in a binary tree is the number of edges between the nodes.
 *
 * Given the root of a binary tree root, return the diameter of the tree.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5]
 *
 * Output: 3
 * Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].
 *
 * Example 2:
 *
 * Input: root = [1,2,3]
 *
 * Output: 2
 * Constraints:
 *
 * 1 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
object DiameterOfBinaryTree {
    private var res = 0;

    fun diameterOfBinaryTree(root: TreeNode<Int>?): Int {
        dfs(root)
        return res
    }

    /**
     * Depth First Search
     * Step1: If the node is null, return 0
     * Step2: Recursively call the left and right nodes
     * Step3: Calculate the left and right nodes
     * Step4: Update the result with the maximum of left + right
     * Step5: Return the maximum of left and right + 1
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param node
     * @return Int
     * @see TreeNode
     */
    private fun dfs(node: TreeNode<Int>?): Int {
        if (node == null) return 0

        val left = dfs(node.left)
        val right = dfs(node.right)

        res = res.coerceAtLeast(left + right)
        return left.coerceAtLeast(right) + 1
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    println(DiameterOfBinaryTree.diameterOfBinaryTree(root))

    val root2 = TreeNode(1)
    root2.right = TreeNode(2)
    root2.right?.right = TreeNode(3)
    val result = DiameterOfBinaryTree.diameterOfBinaryTree(root2)
    println(result)
}