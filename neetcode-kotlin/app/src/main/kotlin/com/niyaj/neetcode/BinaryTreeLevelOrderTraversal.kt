package com.niyaj.neetcode

/**
 * Binary Tree Level Order Traversal
 * Given a binary tree root, return the level order traversal of it as a nested list,
 * where each sublist contains the values of nodes at a particular level in the tree, from left to right.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 *
 * Output: [[1],[2,3],[4,5,6,7]]
 * Example 2:
 *
 * Input: root = [1]
 *
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The number of nodes in both trees <= 1000.
 * -1000 <= Node.val <= 1000
 *
 */
object BinaryTreeLevelOrderTraversal {
    /**
     * Level Order Traversal using BFS
     * Step1: Create a list of list
     * Step2: If the root is null, return the list
     * Step3: Create a queue and add the root to it
     * Step4: Loop through the queue until it is empty
     * Step5: Create a level list
     * Step6: Get the size of the queue
     * Step7: Loop through the size
     * Step8: Remove the first element from the queue
     * Step9: Add the value to the level list
     * Step10: If the left child is not null, add it to the queue
     * Step11: If the right child is not null, add it to the queue
     * Step12: Add the level list to the list
     * Step13: Return the list
     *
     * Time Complexity: O(n) - We are traversing all the nodes
     * Space Complexity: O(n) - We are using a queue to store the nodes
     *
     * @param root TreeNode<Int?> The root of the binary tree
     * @return List<List<Int>> The level order traversal of the binary tree
     *
     */
    fun levelOrderBFS(root: TreeNode<Int?>?): List<List<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        if (root == null) return list

        val q = ArrayDeque<TreeNode<Int?>>()
        q.add(root)

        while (q.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val size = q.size

            for (i in 0 until size) {
                val node = q.removeFirst()
                level.add(node.value!!)

                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }

            list.add(level)
        }

        return list
    }
}

fun main() {
    val node: TreeNode<Int?>? = insertLevelOrder(listOf(1, 2, 3, 4, 5, 6))
    val result = BinaryTreeLevelOrderTraversal.levelOrderBFS(node)
    println(result)

    val node1: TreeNode<Int?>? = insertLevelOrder(listOf(1))
    val result1 = BinaryTreeLevelOrderTraversal.levelOrderBFS(node1)
    println(result1)
}