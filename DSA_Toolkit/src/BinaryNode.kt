class BinaryNode<T>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagramBuilder(this)

    // top and bottom are used for spaces and lines to show the hierarchy of levels
    // root is used to position the current node's value with respect to its children
    private fun diagramBuilder(node: BinaryNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagramBuilder(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagramBuilder(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

}
