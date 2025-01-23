package com.niyaj.neetcode

class TreeNode<T>(val value: T) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null

    override fun toString(): String {
        return "TreeNode(value=$value, left=$left, right=$right)"
    }
}

inline fun <reified T> insertLevelOrder(values: List<T>): TreeNode<T>? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val queue: MutableList<TreeNode<T & Any>> = mutableListOf(root)

    var i = 1
    while (i < values.size) {
        val current = queue.removeAt(0)

        // Insert left child
        if (i < values.size && values[i] != null) {
            val leftNode = TreeNode(values[i]!!)
            current.left = leftNode
            queue.add(leftNode)
        }
        i++

        // Insert right child
        if (i < values.size && values[i] != null) {
            val rightNode = TreeNode(values[i]!!)
            current.right = rightNode
            queue.add(rightNode)
        }
        i++
    }

    return root as TreeNode<T>?
}


// Extension function to print the tree
fun <T> TreeNode<T>?.printTree(indent: String = "", isRight: Boolean = true) {
    if (this == null) return

    val prefix = if (isRight) "└── " else "├── "
    println(indent + prefix + value)

    val newIndent = indent + if (isRight) "    " else "│   "
    left.printTree(newIndent, false)
    right.printTree(newIndent, true)
}