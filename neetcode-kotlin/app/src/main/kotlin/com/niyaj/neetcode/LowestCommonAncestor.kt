package com.niyaj.neetcode

/**
 * Lowest Common Ancestor in Binary Search Tree
 * Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.
 *
 * The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.
 *
 * Example 1:
 *
 *
 *
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8
 *
 * Output: 5
 * Example 2:
 *
 *
 *
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 4
 *
 * Output: 3
 * Explanation: The LCA of nodes 3 and 4 is 3, since a node can be a descendant of itself.
 *
 * Constraints:
 *
 * 2 <= The number of nodes in the tree <= 100.
 * -100 <= Node.val <= 100
 * p != q
 * p and q will both exist in the BST.
 */
object LowestCommonAncestor {
    /**
     * Find the lowest common ancestor of two nodes in a binary search tree
     * Step1: Set the current node to the root
     * Step2: While the current node is not null
     * Step3: If the value of p and q is less than the current node value
     * Step4: Set the current node to the left node
     * Step5: Else if the value of p and q is greater than the current node value
     * Step6: Set the current node to the right node
     * Step7: Else return the current node
     * Step8: Return null
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param root the root node of the binary search tree
     * @param p the first node
     * @param q the second node
     * @return the lowest common ancestor of the two nodes
     */
    fun lowestCommonAncestor(root: TreeNode<Int>?, p: TreeNode<Int>?, q: TreeNode<Int>?): TreeNode<Int>? {
        var curr = root

        while (curr != null) {
            curr = if (p!!.value < curr.value && q!!.value < curr.value) {
                curr.left
            } else if (p.value > curr.value && q!!.value > curr.value) {
                curr.right
            } else {
                return curr
            }
        }

        return null
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(7)
    root.right!!.right = TreeNode(9)
    root.left!!.left!!.right = TreeNode(2)

    println(LowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right)?.value) // 5
    println(LowestCommonAncestor.lowestCommonAncestor(root, root.left, root.left!!.right)?.value) // 3
}