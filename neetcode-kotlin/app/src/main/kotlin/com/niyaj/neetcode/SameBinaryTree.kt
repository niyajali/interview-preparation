package com.niyaj.neetcode

/**
 * Same Binary Tree
 * Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
 *
 * Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
 *
 * Example 1:
 *
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: p = [4,7], q = [4,null,7]
 *
 * Output: false
 * Example 3:
 *
 *
 *
 * Input: p = [1,2,3], q = [1,3,2]
 *
 * Output: false
 * Constraints:
 *
 * 0 <= The number of nodes in both trees <= 100.
 * -100 <= Node.val <= 100
 */
object SameBinaryTree {
    /**
     * Depth First Search
     * Step1: If both nodes are null, return true
     * Step2: If one of the nodes is null, return false
     * Step3: If the values of the nodes are not equal, return false
     * Step4: Recursively call the dfs for left and right nodes
     * Step5: Repeat the above steps for all the nodes
     * Step6: Return the result
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param p TreeNode<Int?>
     * @param q TreeNode<Int?>
     * @return Boolean
     */
    fun isSameTree(p: TreeNode<Int?>?, q: TreeNode<Int?>?): Boolean {
        val root = ArrayDeque<Pair<TreeNode<Int?>?, TreeNode<Int?>?>>()
        root.add(Pair(p, q))

        while (root.isNotEmpty()) {
            val (node1, node2) = root.removeFirst()

            if (node1 == null && node2 == null) continue
            if (node1 == null || node2 == null) return false
            if (node1.value != node2.value) return false

            root.add(Pair(node1.left, node2.left))
            root.add(Pair(node1.right, node2.right))
        }

        return true
    }
}

fun main() {
    val p: TreeNode<Int?> = TreeNode(1)
    p.left = TreeNode(2)
    p.right = TreeNode(3)

    val q: TreeNode<Int?> = TreeNode(1)
    q.left = TreeNode(2)
    q.right = TreeNode(3)

    println(SameBinaryTree.isSameTree(p, q)) // true

    val p1: TreeNode<Int?> = TreeNode(4)
    p1.left = TreeNode(7)

    val q1: TreeNode<Int?> = TreeNode(4)
    q1.right = TreeNode(7)

    println(SameBinaryTree.isSameTree(p1, q1)) // false

    val p2: TreeNode<Int?> = TreeNode(1)
    p2.left = TreeNode(2)
    p2.right = TreeNode(3)

    val q2: TreeNode<Int?> = TreeNode(1)
    q2.left = TreeNode(3)
    q2.right = TreeNode(2)

    println(SameBinaryTree.isSameTree(p2, q2)) // false
}