package com.niyaj.neetcode

/**
 * Valid Binary Search Tree
 * Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
 *
 * A valid binary search tree satisfies the following constraints:
 *
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 * Example 1:
 *
 *
 *
 * Input: root = [2,1,3]
 *
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: root = [1,2,3]
 *
 * Output: false
 * Explanation: The root node's value is 1 but its left child's value is 2 which is greater than 1.
 *
 * Constraints:
 *
 * 1 <= The number of nodes in the tree <= 1000.
 * -1000 <= Node.val <= 1000
 */
object ValidBinarySearchTree {
    fun isValidBSTDFS(root: TreeNode<Long?>?): Boolean {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    /**
     * Depth First Search
     * Step1: If root is null, return true
     * Step2: Check if the value of the current node is greater than the left and less than the right
     * Step3: Recursively call valid for left and right nodes
     * Step4: Return the result
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode
     * @param left Long
     * @param right Long
     * @return Boolean
     */
    private fun valid(root: TreeNode<Long?>?, left: Long, right: Long): Boolean {
        if (root == null) return true

        val value = root.value?.toLong()!!
        if (value <= left || value >= right) return false

        return valid(root.left, left, value) && valid(root.right, value, right)
    }

    private data class QueueItem(
        val node: TreeNode<Long?>,
        val left: Long,
        val right: Long,
    )

    fun isValidBSTBFS(root: TreeNode<Long?>?): Boolean {
        if (root == null) return false

        val q = ArrayDeque<QueueItem>()
        q.add(QueueItem(root, Long.MIN_VALUE, Long.MAX_VALUE))

        while (q.isNotEmpty()) {
            val (node, left, right) = q.removeFirst()
            val value = node.value?.toLong()!!

            if (value <= left || value >= right) return false

            node.left?.let { q.add(QueueItem(it, left, value)) }
            node.right?.let { q.add(QueueItem(it, value, right)) }
        }

        return true
    }
}

fun main() {
    val root: TreeNode<Long?> = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    println(ValidBinarySearchTree.isValidBSTDFS(root)) // true
    println(ValidBinarySearchTree.isValidBSTBFS(root)) // true

    val root2: TreeNode<Long?> = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)

    println(ValidBinarySearchTree.isValidBSTDFS(root2)) // false
    println(ValidBinarySearchTree.isValidBSTBFS(root2)) // false
}