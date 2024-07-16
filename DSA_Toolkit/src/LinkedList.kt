class LinkedList<T> {

    private var head: Node<T>? = null //first node
    private var tail: Node<T>? = null //last node
    private var size = 0 //number of elements

    //checks if the list is empty
    fun isEmpty(): Boolean {
        return size == 0
    }

    //retrives node at a specific index, returns null if out of bounds
    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    //inserts new node at the front of the list
    fun insert(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    //deletes a node at a specific index
    fun delete(index: Int): T? {
        if (isEmpty() || index < 0 || index >= size) {
            return null  //if invalid index
        }

        if (index == 0) {  //head node deletion
            val result = head?.value
            head = head?.next
            if (tail == head) {
                tail = null
            }
            size--
            return result
        }

        val prevNode = nodeAt(index - 1) //general node deletion
        if (prevNode == null || prevNode.next == null) {
            return null
        }

        val removedNode = prevNode.next!!
        prevNode.next = removedNode.next
        if (removedNode === tail) {
            tail = prevNode
        }
        size--
        return removedNode.value
    }


    //reverses the list
    fun reverseList(): Node<T>? {
        var prev: Node<T>? = null
        var current = head
        var next: Node<T>? = null

        //reversing part
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        head = prev //update head
        return prev //return new head
    }

    //removes duplicates and updates the size
    fun removeDuplicates(): Unit {
        if (head == null || head?.next == null) {
            return
        }

        var current = head!!
        val set = mutableSetOf<T>()

        set.add(current.value)

        while (current.next != null) {
            if (set.contains(current.next!!.value)) {
                current.next = current.next!!.next
                size--
            } else {
                set.add(current.next!!.value)
                current = current.next!!
            }
        }

        if (set.contains(current.value)) {
            current.next = null
            tail = current
        }
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }
}
