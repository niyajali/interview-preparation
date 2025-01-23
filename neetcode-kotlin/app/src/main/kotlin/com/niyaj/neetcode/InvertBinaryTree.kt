package com.niyaj.neetcode

/**
 * Invert Binary Tree
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 *
 * Output: [1,3,2,7,6,5,4]
 * Example 2:
 *
 *
 *
 * Input: root = [3,2,1]
 *
 * Output: [3,1,2]
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 */
object InvertBinaryTree {
    /**
     * Inverts the binary tree
     * Step1: Create a new node with the value of the root node
     * Step2: Recursively call the invertTree function with the right child of the root node as the root of the function
     * Step3: Recursively call the invertTree function with the left child of the root node as the root of the function
     * Step4: Assign the left child of the new node as the result of the Step2
     * Step5: Assign the right child of the new node as the result of the Step3
     * Step6: Return the new node
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root root of the binary tree
     * @return root of the inverted binary tree
     */
    fun invertTree(root: TreeNode<Int>?): TreeNode<Int>? {
        if (root == null) return null

        val node = TreeNode(root.value)

        node.left = invertTree(root.right)
        node.right = invertTree(root.left)

        return node
    }
}

fun main() {
    val root = insertLevelOrder(listOf<Int>(1,2,3,4,5,6,7))
    root.printTree()

    InvertBinaryTree.invertTree(root).printTree()
}