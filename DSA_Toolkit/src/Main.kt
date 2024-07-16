fun main() {
    var menuChoice: Int

    do {
        println("\nData Structures Toolkit")
        println("1. Array")
        println("2. Linked List")
        println("3. Stack")
        println("4. Queue")
        println("5. Binary Search Tree")
        println("0. Exit")
        print("Enter your choice: ")

        menuChoice = readLine()?.toIntOrNull() ?: 0

        when (menuChoice) {
            1 -> arrayOp()
            2 -> linkedListOp()
            3 -> stackOp()
            4 -> queueOp()
            5 -> bstOp()
            0 -> println("Exiting Data Structures Toolkit...")
            else -> println("Invalid choice. Try again.")
        }

    } while (menuChoice != 0)
}

fun arrayOp() {
    var arr = IntArray(0)
    var choice: Int
    var currentSize = 0
    var size = 0

    do {
        println("\nArray Operations")
        println("1. Create an empty array")
        println("2. Insert elements into the array")
        println("3. Delete an element from the array")
        println("4. Arrange to ASCENDING")
        println("5. Arrange to DESCENDING")
        println("0. Exit")
        print("Enter your choice: ")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            //ARRAY CREATION
            1 -> {
                if (arr.isNotEmpty()){
                    println("Array already created. You can only create one array per session.")
                } else {
                    print("Enter array size: ")
                    size = readLine()?.toIntOrNull() ?: 0
                    arr = IntArray(size)
                    currentSize = 0
                    println("Empty array of size $size created.")
                }

            }
            //ARRAY ELEMENT INSERTION
            2 -> {
                if (currentSize < size){
                    print("Enter the element to be inserted: ")
                    val element = readLine()?.toIntOrNull() ?: 0
                    arr[currentSize] = element
                    currentSize++
                    println("Element $element inserted into the array.")
                } else{
                    println("Array is full. Cannot insert more elements.")
                }
            }
            //ARRAY ELEMENT DELETION
            3 -> {
                if (arr.isEmpty()) {
                    println("Error. Create an array first.")
                } else {
                    print("Enter the element to be deleted: ")
                    val element = readLine()?.toIntOrNull() ?: 0
                    //checks first if element is in the current array
                    if (element in arr.sliceArray(0 until currentSize)) {
                        // creates new array with only the elements not equal to input
                        arr = arr.sliceArray(0 until currentSize).filter { it != element }.toIntArray()
                        println("Element $element deleted from the array.")
                    } else {
                        println("Element $element not found in the array.")
                    }
                }
            }
            4 -> {
                if (arr.isNotEmpty()){
                    arr = bubbleSort(arr, true)
                    println("Array arranged in ascending order: ${arr.contentToString()}")
                } else {
                    println("Error. Create an array first.")
                }
            }
            5 -> {
                if (arr.isNotEmpty()){
                    arr = bubbleSort(arr, false)
                    println("Array arranged in descending order: ${arr.contentToString()}")
                } else {
                    println("Error. Create an array first.")
                }
            }
            0 -> println("Returning to main menu...")
            else -> println("Invalid choice. Try again.")
        }
    } while (choice != 0)
}

fun bubbleSort(arr: IntArray, ascending: Boolean) : IntArray {
    val n = arr.size
    for (i in 0 until n-1) {
        for (j in 0 until n - i - 1) {
            if((ascending && arr[j] > arr[j+1]) || (!ascending && arr[j] < arr[j+1])) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

fun linkedListOp() {
    val linkedlist = LinkedList<Int>()

    do {
        println("\nLinked List Operations")
        println("1. Create an empty linked list")
        println("2. Insert elements into the linked list")
        println("3. Delete an element from the linked list")
        println("4. Reverse the linked list")
        println("5. Remove duplicates from the linked list")
        println("6. Display the linked list")
        println("0. Exit")
        print("Enter your choice: ")

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> { println("Empty linked list created.") }
            2 -> {
                print("Enter the element to insert: ")
                val element = readLine()?.toIntOrNull() ?: 0
                linkedlist.insert(element)
                println("Element $element inserted into the linked list.")
            }
            3 -> {
                    print("Enter the index of the element to delete: ")
                    val elementIndex = readLine()?.toIntOrNull() ?: 0
                    linkedlist.delete(elementIndex)
            }
            4 -> {
                    linkedlist.reverseList()
                    println("Linked list reversed.")
            }
            5 -> {
                    linkedlist.removeDuplicates()
                    println("Duplicates removed from the linked list.")
            }
            6 -> {
                    print("Linked list: ")
                    println(linkedlist)
            }
            0 -> println("Returning to main menu...")
            else -> println("Invalid choice. Try again.")
        }
    } while (choice != 0)
}

fun stackOp() {
    var stack = IntArray(0)
    var top = -1
    var choice: Int

    do {
        println("\nStack Operations")
        println("1. Create an empty stack")
        println("2. Push elements onto the stack")
        println("3. Pop elements from the stack")
        println("4. Change specific element in the stack")
        println("5. Display the stack")
        println("0. Exit")
        print("Enter your choice: ")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            //CREATE STACK
            1 -> {
                if (stack.isNotEmpty()){
                    println("Stack already created. You can only create one stack per session.")
                } else {
                    print("Enter stack size: ")
                    val size = readLine()?.toIntOrNull() ?: 0
                    stack = IntArray(size)
                    top = -1
                    println("Empty stack created.")
                }

            }
            //PUSH
            2 -> {
                if (top == stack.size - 1) {
                    println("STACKOVERFLOW: Stack is full.")
                } else {
                    print("Enter an element to push: ")
                    val element = readLine()?.toIntOrNull() ?: 0
                    top++
                    stack[top] = element
                    println("Element $element pushed into the stack.")
                }
            }
            //POP
            3 -> {
                if (top == -1) {
                    println("STACKUNDERFLOW: Stack is empty.")
                } else {
                    val element = stack[top]
                    top--
                    println("Element $element popped from the stack.")
                }
            }
            //CHANGE ELEMENT
            4 -> {
                if (top == -1) {
                    println("Stack is empty. Cannot change elements.")
                } else {
                    print("Enter the position (0 to $top) of the element to change: ")
                    val position = readLine()?.toIntOrNull() ?: 0
                    if (position in 0..top) {
                        print("Enter new value: ")
                        val newValue = readLine()?.toIntOrNull() ?: 0
                        stack[position] = newValue
                        println("Element at position $position changed to $newValue")
                    } else {
                        println("Invalid position. Please enter a valid one.")
                    }
                }
            }
            //PRINT STACK
            5 -> {
                if (top == -1) {
                    println("Stack is empty.")
                } else {
                    println("Elements in the stack:")
                    val range = 0..top
                    for (i in range.reversed()) { //reversed so that it will look like a stack
                        println("${stack[i]}")
                    }
                }
            }
            0 -> println("Returning to main menu...")
            else -> println("Invalid choice. Try again.")
        }
    } while(choice != 0)
}

fun queueOp() {
    var queue = IntArray(0)
    var front = 0
    var rear = -1
    var numElements = 0
    var choice: Int

    do {
        println("\nQueue Operations")
        println("1. Create an empty queue")
        println("2. Enqueue elements onto the queue")
        println("3. Dequeue elements from the queue")
        println("4. Check FRONT of the queue")
        println("5. Check REAR of the queue")
        println("6. Display queue")
        println("0. Exit")
        print("Enter your choice: ")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            //CREATE QUEUE
            1 -> {
                if (queue.isNotEmpty()){
                    println("Queue already created. You can only create one queue per session.")
                } else {
                    print("Enter queue size: ")
                    val size = readLine()?.toIntOrNull() ?: 0
                    queue = IntArray(size)
                    front = 0
                    rear = -1
                    numElements = 0
                    println("Empty queue created.")
                }
            }
            //ENQUEUE
            2 -> {
                if (numElements == queue.size) {
                    println("Queue is full. Cannot enqueue new elements.")
                } else {
                    print("Enter element to enqueue: ")
                    val element = readLine()?.toIntOrNull() ?:0
                    rear = (rear + 1) % queue.size //modulo used to wrap around the beginning of the array
                    queue[rear] = element
                    numElements++
                    println("Element $element enqueued into the queue.")
                }
            }
            //DEQUEUE
            3 -> {
                if (numElements == 0) {
                    println("Queue is empty. Cannot dequeue elements.")
                } else {
                    val element = queue[front]
                    front = (front + 1) % queue.size
                    numElements--
                    if (front == queue.size) {
                        front = 0
                    }
                    println("Element $element dequeued from the queue.")
                }
            }
            //RETURNS FRONT ELEMENT
            4 -> {
                if (numElements == 0) {
                    println("Queue is empty. No front element.")
                } else {
                    println("Front element: ${queue[front]}.")
                }
            }
            //RETURNS REAR ELEMENT
            5 -> {
                if (numElements == 0) {
                    println("Queue is empty. No rear element.")
                } else {
                    println("Rear element: ${queue[rear]}.")
                }
            }
            //DISPLAYS QUEUE
            6 -> {
                if (numElements == 0) {
                    println("Queue is empty.")
                } else {
                    println("Elements in the queue: ")
                    for (i in 1 .. numElements) {
                        val index = (front + i - 1) % queue.size
                        print("${queue[index]} ")
                    }
                }
            }
            0 -> println("Returning to main menu...")
            else -> println("Invalid choice. Try again.")
        }
    } while (choice !=0)
}

fun bstOp() {
    var choice: Int
    val tree = BinarySearchTree<Int>().apply { }
    do {
        println("\nBinary Search Tree Operations")
        println("1. Create an empty binary tree")
        println("2. Insert elements into the binary tree")
        println("3. Delete elements from the binary tree")
        println("4. Display binary tree")
        println("5. Display tree structure")
        println("0. Exit")
        print("Enter your choice: ")

        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> { println("Empty binary tree created.") }
            //INSERTS ELEMENT
            2 -> {
                print("Enter an element to insert: ")
                val element = readLine()?.toIntOrNull() ?: 0
                tree.insert(element)
            }
            //DELETES AN ELEMENT
            3 -> {
                print("Enter an element to delete: ")
                val element = readLine()?.toIntOrNull() ?: 0
                tree.remove(element)
            }
            //PRINT TREE
            4 -> {
                println(tree)
            }
            //DISPLAYS STRUCTURE DETAILS
            5 -> {
                tree.displayTreeStructure()
            }
            0 -> println("Returning to main menu...")
            else -> println("Invalid choice. Try again.")
        }
    } while (choice != 0)

}