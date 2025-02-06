package com.niyaj.neetcode

/**
 * Count Good Nodes in Binary Tree
 * Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x
 *
 * Given the root of a binary tree root, return the number of good nodes within the tree.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [2,1,1,3,null,1,5]
 *
 * Output: 3
 *
 *
 * Example 2:
 *
 * Input: root = [1,2,-1,3,4]
 *
 * Output: 4
 * Constraints:
 *
 * 1 <= number of nodes in the tree <= 100
 * -100 <= Node.val <= 100
 */
object CountGoodNodesInBinaryTree {
    fun goodNodesDFS(root: TreeNode<Int?>?): Int {
        return dfs(root, root?.value!!)
    }

    /**
     * Depth First Search(Preorder)
     * Step1: If root is null, return 0
     * Step2: If the current node value is greater than or equal to the max value, increment the count
     * Step3: Recursively call dfs for left and right nodes
     * Step4: Return the count
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode
     * @param max Int
     */
    private fun dfs(root: TreeNode<Int?>?, max: Int): Int {
        if (root == null) return 0

        var res = if (root.value!! >= max) 1 else 0

        val newMax = maxOf(max, root.value)
        res += dfs(root.left, newMax)
        res += dfs(root.right, newMax)

        return res
    }

    fun goodNodesBFS(root: TreeNode<Int?>?): Int {
        if (root == null) return 0

        var res = 0
        val q = ArrayDeque(listOf(Pair(root, Int.MIN_VALUE)))

        while (q.isNotEmpty()) {
            val (node, max) = q.removeFirst()

            if (node.value!! >= max) {
                res++
            }

            val newMax = maxOf(max, node.value)
            node.left?.let { q.add(Pair(it, newMax)) }
            node.right?.let { q.add(Pair(it, newMax)) }
        }

        return res
    }
}

fun main() {
    val root: TreeNode<Int?> = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(3)
    root.right?.left = TreeNode(1)
    root.right?.right = TreeNode(5)

    println(CountGoodNodesInBinaryTree.goodNodesDFS(root)) // 3
    println(CountGoodNodesInBinaryTree.goodNodesBFS(root)) // 3

    val root2: TreeNode<Int?> = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(-1)
    root2.left?.left = TreeNode(3)
    root2.left?.right = TreeNode(4)

    println(CountGoodNodesInBinaryTree.goodNodesDFS(root2)) // 4
    println(CountGoodNodesInBinaryTree.goodNodesBFS(root2)) // 4

}