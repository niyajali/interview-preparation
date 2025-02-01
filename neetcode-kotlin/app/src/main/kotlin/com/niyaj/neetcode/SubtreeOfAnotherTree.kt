package com.niyaj.neetcode

/**
 * Subtree of Another Tree
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5], subRoot = [2,4,5]
 *
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
 *
 * Output: false
 * Constraints:
 *
 * 0 <= The number of nodes in both trees <= 100.
 * -100 <= root.val, subRoot.val <= 100
 */
object SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode<Int?>?, subRoot: TreeNode<Int?>?): Boolean {
        if (root == null || subRoot == null) return false
        if (isSameTree(root, subRoot)) return true

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun isSameTree(p: TreeNode<Int?>?, q: TreeNode<Int?>?): Boolean {
        if (p == null && q == null) return true

        if (p != null && q != null && p.value == q.value) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }

        return false
    }
}

fun main() {
    val root: TreeNode<Int?> = TreeNode(3)
    root.left = TreeNode(4)
    root.right = TreeNode(5)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(2)

    val subRoot: TreeNode<Int?> = TreeNode(4)
    subRoot.left = TreeNode(1)
    subRoot.right = TreeNode(2)

    println(SubtreeOfAnotherTree.isSubtree(root, subRoot))

    val root2: TreeNode<Int?> = TreeNode(3)
    root2.left = TreeNode(4)
    root2.right = TreeNode(5)

    val subRoot2: TreeNode<Int?> = TreeNode(4)
    subRoot2.left = TreeNode(1)
    subRoot2.right = TreeNode(2)

    println(SubtreeOfAnotherTree.isSubtree(root2, subRoot2))
}