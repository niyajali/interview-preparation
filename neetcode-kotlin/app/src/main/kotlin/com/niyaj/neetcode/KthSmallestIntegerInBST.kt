package com.niyaj.neetcode

/**
 * Kth Smallest Integer in BST
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
 *
 * A binary search tree satisfies the following constraints:
 *
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 * Example 1:
 *
 *
 *
 * Input: root = [2,1,3], k = 1
 *
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: root = [4,3,5,2,null], k = 4
 *
 * Output: 5
 * Constraints:
 *
 * 1 <= k <= The number of nodes in the tree <= 1000.
 * 0 <= Node.val <= 1000
 */
object KthSmallestIntegerInBST {
    /**
     * Depth First Search
     * Step1: Initialize a stack and a variable to keep track of the current node
     * Step2: Repeat the following steps until the stack is empty or the current node is not null
     * Step3: Repeat the following steps until the current node is not null
     * Step4: Add the current node to the stack and move to the left node
     * Step5: Pop the last element from the stack and decrement k
     * Step6: If k is 0, return the value of the current node
     * Step7: Move to the right node
     * Step8: Repeat the above steps for all the nodes
     * Step9: Otherwise Return 0
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode
     * @param k Int
     */
    fun kthSmallest(root: TreeNode<Int?>?, k: Int): Int {
        val stack = mutableListOf<TreeNode<Int?>>()
        var curr = root
        var kth = k

        while (stack.isNotEmpty() || curr != null) {
            while (curr != null) {
                stack.add(curr)
                curr = curr.left
            }

            curr = stack.removeLast()
            kth--

            if (kth == 0) {
                return curr.value!!
            }

            curr = curr.right
        }

        return 0
    }
}

fun main() {
    val root: TreeNode<Int?> = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left!!.right = TreeNode(2)

    println(KthSmallestIntegerInBST.kthSmallest(root, 1)) // 1
    println(KthSmallestIntegerInBST.kthSmallest(root, 2)) // 2
    println(KthSmallestIntegerInBST.kthSmallest(root, 3)) // 3
    println(KthSmallestIntegerInBST.kthSmallest(root, 4)) // 4
}