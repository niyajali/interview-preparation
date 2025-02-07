package com.niyaj.neetcode

/**
 * Binary Tree Right Side View
 * You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of the tree,
 * ordered from top to bottom.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3]
 *
 * Output: [1,3]
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,6,7]
 *
 * Output: [1,3,7]
 * Constraints:
 *
 * 0 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
object BinaryTreeRightSideView {
    /**
     * Breadth First Search
     * Step1: If root is null, return empty list
     * Step2: Create a queue and add the root node to it
     * Step3: Create a list to store the result
     * Step4: Iterate the queue until it is empty
     * Step5: For each level, iterate the nodes and add the rightmost node to the result
     * Step6: Return the result
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode
     * @return List<Int>
     */
    fun rightSideViewBFS(root: TreeNode<Int?>?): List<Int> {
        if (root == null) return emptyList() // If root is null, return empty list

        val q = ArrayDeque(listOf(root)) // Queue to store the nodes
        val result = mutableListOf<Int>() // List to store the result

        while (q.isNotEmpty()) {
            var rightSide: TreeNode<Int?>? = null
            var size = q.size

            while (size > 0) {
                val node = q.removeFirst()
                rightSide = node
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }

                size--
            }

            rightSide?.let { result.add(it.value!!) }
        }

        return result
    }

    /**
     * Depth First Search
     * Step1: If root is null, return empty list
     * Step2: Create a list to store the result
     * Step3: Create a helper function to traverse the tree
     * Step4: If the depth is equal to the size of the result, add the rightmost node to the result
     * Step5: Recursively call the helper function for right and left nodes
     * Step6: Return the result
     * Step7: Repeat the above steps for all the nodes
     * Step8: Return the result
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode
     * @return List<Int>
     */
    fun rightSideViewDFS(root: TreeNode<Int?>?): List<Int> {
        val res = mutableListOf<Int>()

        fun dfs(root: TreeNode<Int?>?, depth: Int) {
            if (root == null) return

            if (depth == res.size) {
                res.add(root.value!!)
            }

            dfs(root.right, depth + 1)
            dfs(root.left, depth + 1)
        }

        dfs(root, 0);
        return res
    }
}

fun main() {
    val root: TreeNode<Int?> = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.right?.right = TreeNode(5)

    println(BinaryTreeRightSideView.rightSideViewBFS(root)) // [1, 3, 5]
    println(BinaryTreeRightSideView.rightSideViewDFS(root)) // [1, 3, 5]

    val root2: TreeNode<Int?> = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)
    root2.left?.right = TreeNode(5)
    root2.right?.right = TreeNode(4)

    println(BinaryTreeRightSideView.rightSideViewBFS(root2)) // [1, 3, 4]
    println(BinaryTreeRightSideView.rightSideViewDFS(root2)) // [1, 3, 4]
}