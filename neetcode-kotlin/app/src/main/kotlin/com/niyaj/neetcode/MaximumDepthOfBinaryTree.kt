package com.niyaj.neetcode

/**
 * Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its depth.
 *
 * The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,null,null,4]
 *
 * Output: 3
 * Example 2:
 *
 * Input: root = []
 *
 * Output: 0
 * Constraints:
 *
 * 0 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 */
object MaximumDepthOfBinaryTree {
    /**
     * Recursive DFS approach
     *
     * Step1: Check if the root is null, if it is return 0
     * Step2: Recursively call the maxDepth function for the left and right child of the root
     * Step3: Return the maximum of the left and right child depth + 1
     *
     * @param root The root of the binary tree
     * @return The depth of the binary tree
     *
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun maxDepth(root: TreeNode<Int?>?): Int {
        if (root == null) return 0

        return maxDepth(root.left) + maxDepth(root.right) + 1
    }

    /**
     * Iterative DFS approach
     * Step1: Check if the root is null, if it is return 0
     * Step2: Create a stack to store the node and its depth
     * Step3: Add the root and its depth to the stack
     * Step4: While the stack is not empty, pop the node and its depth from the stack
     * Step5: If the node is not null, update the result with the maximum of the current depth and the result
     * Step6: Add the left and right child of the node to the stack with the depth + 1
     * Step7: Return the result
     *
     * @param root The root of the binary tree
     * @return The depth of the binary tree
     *
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun maxDepthIterativeDFS(root: TreeNode<Int?>?): Int {
        if (root == null) return 0

        val stack = ArrayDeque<Pair<TreeNode<Int?>?, Int>>()
        stack.addLast(Pair(root, 1))
        var res = 0

        while (stack.isNotEmpty()) {
            val (node, depth) = stack.removeLast()

            if (node != null) {
                res = maxOf(res, depth)
                stack.addLast(Pair(node.left, depth + 1))
                stack.addLast(Pair(node.right, depth + 1))
            }
        }

        return res
    }

    /**
     * Iterative BFS approach
     * Step1: Check if the root is null, if it is return 0
     * Step2: Create a queue to store the node
     * Step3: Add the root to the queue
     * Step4: While the queue is not empty, get the size of the queue
     * Step5: Iterate over the size of the queue
     * Step6: Remove the node from the queue
     * Step7: If the left and right child of the node is not null, add them to the queue
     * Step8: Increment the level
     * Step9: Return the level
     *
     * @param root The root of the binary tree
     * @return The depth of the binary tree
     *
     * Space Complexity: O(n)
     * Time Complexity: O(n)
     */
    fun maxDepthIterativeBFS(root: TreeNode<Int?>?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<TreeNode<Int?>?>()
        queue.addLast(root)
        var level = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            repeat(size) {
                val node = queue.removeFirst()

                node?.left?.let { queue.addLast(it) }
                node?.right?.let { queue.addLast(it) }
            }

            level++
        }

        return level
    }
}

fun main() {
    val node = insertLevelOrder(listOf(1, 2, 3, null, null, 4))
    println(MaximumDepthOfBinaryTree.maxDepth(node)) // Output: 3
    println(MaximumDepthOfBinaryTree.maxDepthIterativeDFS(node)) // Output: 3
    println(MaximumDepthOfBinaryTree.maxDepthIterativeBFS(node)) // Output: 3

    val node2 = insertLevelOrder(listOf(1, 2, 3, 4, 5, 6, 7))
    println(MaximumDepthOfBinaryTree.maxDepth(node2 as TreeNode<Int?>?)) // Output: 3
    println(MaximumDepthOfBinaryTree.maxDepthIterativeDFS(node2)) // Output: 3
    println(MaximumDepthOfBinaryTree.maxDepthIterativeBFS(node2)) // Output: 3

}