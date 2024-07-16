class BinarySearchTree<T: Comparable<T>>() {

    var root: BinaryNode<T>? = null

    override fun toString() = root?.toString() ?: "Empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {

        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    fun remove(value: T) { root = remove(root, value) }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {

                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }

                if (node.leftChild == null) {
                    return node.rightChild
                }

                if (node.rightChild == null) {
                    return node.leftChild
                }

                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)

            }

            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

    fun displayTreeStructure() {
        if (root == null) {
            println("Binary Tree is empty.")
        } else {
            printTreeStructure(root, 0)
        }
    }

    private fun printTreeStructure(node: BinaryNode<T>?, level: Int) {
        if (node != null) {
            printTreeStructure(node.rightChild, level + 1)
            val indent = " ".repeat(level * 2)
            if (level == 0) {
                println("$indent Root Node: ${node.value}")
            } else {
                println("$indent Node: ${node.value} (Level: $level)")
                if (node.leftChild == null && node.rightChild == null) {
                    println("$indent Leaf Node")
                } else if (node.leftChild == null) {
                    println("$indent Parent Node (Right Child Only)")
                } else if (node.rightChild == null) {
                    println("$indent Parent Node (Left Child Only)")
                } else {
                    println("$indent Parent Node")
                }
            }
            printTreeStructure(node.leftChild, level + 1)
        }
    }

}
