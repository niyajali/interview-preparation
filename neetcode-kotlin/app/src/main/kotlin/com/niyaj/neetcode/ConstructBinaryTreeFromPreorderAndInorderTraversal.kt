package com.niyaj.neetcode

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * You are given two integer arrays preorder and inorder.
 *
 * Preorder is the preorder traversal of a binary tree
 * inorder is the inorder traversal of the same tree
 * Both arrays are of the same size and consist of unique values.
 * Rebuild the binary tree from the preorder and inorder traversals and return its root.
 *
 * Example 1:
 *
 *
 *
 * Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
 *
 * Output: [1,2,3,null,null,null,4]
 * Example 2:
 *
 * Input: preorder = [1], inorder = [1]
 *
 * Output: [1]
 * Constraints:
 *
 * 1 <= inorder.length <= 1000.
 * inorder.length == preorder.length
 * -1000 <= preorder[i], inorder[i] <= 1000
 */
object ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Depth-First Search
     * Step1: If the preorder or inorder array is empty, return null
     * Step2: The first element of the preorder array is the root of the tree
     * Step3: Find the index of the root in the inorder array
     * Step4: The left subtree of every node contains only nodes with keys less than the node's key.
     * Step5: The right subtree of every node contains only nodes with keys greater than the node's key.
     * Step6: Recursively call buildTree for left and right nodes
     * Step7: Return the root
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param preorder IntArray
     * @param inorder IntArray
     * @return TreeNode<Int?>?
     */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode<Int?>? {
        // If the preorder or inorder array is empty, return null
        if (preorder.isEmpty() || inorder.isEmpty()) return null

        // The first element of the preorder array is the root of the tree
        val root: TreeNode<Int?>? = TreeNode(preorder[0])

        // Find the index of the root in the inorder array
        val mid = inorder.indexOf(preorder[0])

        // The left subtree of every node contains only nodes with keys less than the node's key.
        root?.left = buildTree(
            preorder = preorder.sliceArray(1..mid),
            inorder = inorder.sliceArray(0 until mid)
        )

        // The right subtree of every node contains only nodes with keys greater than the node's key.
        root?.right = buildTree(
            preorder = preorder.sliceArray(mid + 1 until preorder.size),
            inorder = inorder.sliceArray(mid + 1 until inorder.size)
        )

        return root
    }


    private var preIdx = 0
    private var inIdx = 0

    /**
     * Depth-First Search
     * Step1: If the preorder array is empty, return null
     * Step2: Create a helper function to traverse the tree
     * Step3: If the inorder value is equal to the limit, increment the inorder index and return null
     * Step4: The left subtree of every node contains only nodes with keys less than the node's key.
     * Step5: The right subtree of every node contains only nodes with keys greater than the node's key.
     * Step6: Recursively call dfs for left and right nodes
     * Step7: Return the root
     * Step8: Repeat the above steps for all the nodes
     * Step9: Return the root
     * Step10: Otherwise Return 0
     * Step11: Return the result
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param preorder IntArray
     * @param inorder IntArray
     * @return TreeNode<Int?>?
     *
     */
    fun buildTreeOptimal(preorder: IntArray, inorder: IntArray): TreeNode<Int?>? {
        fun dfs(limit: Int): TreeNode<Int?>? {
            if (preIdx >= preorder.size) {
                return null
            }

            if (inorder[inIdx] == limit) {
                inIdx++
                return null
            }

            val root: TreeNode<Int?>? = TreeNode(preorder[preIdx])
            preIdx++

            root?.left = dfs(root.value!!)
            root?.right = dfs(limit)

            return root
        }

        return dfs(Int.MAX_VALUE)
    }
}

fun main() {
    val preorder = intArrayOf(1, 2, 3, 4)
    val inorder = intArrayOf(2, 1, 3, 4)

    ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder).printTree()
    ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTreeOptimal(preorder, inorder).printTree()

    val preorder1 = intArrayOf(1)
    val inorder1 = intArrayOf(1)

    ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder1, inorder1).printTree()
    ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTreeOptimal(preorder1, inorder1).printTree()
}