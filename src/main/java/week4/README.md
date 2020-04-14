# Priority Queues, Binary Heap and Heap Sort

## Priority Queue
As opposed to stack that deletes the last item inserted, or queue that deletes the oldest item inserted, priority queues keep track of the size of each element and deletes the largest/smallest item first. 

## Binary Heap
Is a heap data structure that takes the form of a complete binary tree. It keeps track of the size of its elements and allow the implementation of priority queues.
each parent key is greater or equal to the child keys.

+ Insert: 
    + add a new element at the end of the array.
    + execute swim on new element recursively
        + compare element with its parent
        + if greater than, exchange, otherwise stop recursion.
    
+ Extract:
    + Exchange root with last item on the list. 
    + Discard new last item.
    + Execute sink on new root recursively
       + compare element with its children
       + if any of them is greater than the element, exchange, otherwise stop recursion.
       

## Binary tree
 + empty structure, or notdes with links to both left and right Binary trees.
 + Complete Tree: Perfectly balanced tree (ignoring last level)
 
## Heap Sort
As heaps maintain an implicit order, we can use them to implement a sort algorithm.
+ Create max-heap sort with all N keys
+ Repeatedly remove the maximum key

# Symbol Tables

Key-value pair structures. In Python they are dictionaries, maps in java.

Conventions
+ Values != null
+ get returns null if not found
+ put overwrites if key already exists

Implementations:
+ Maintain unordered linked lists of key-value pairs.
    + Search: scan all keys to find match
    + Insert: scan all to find match; if no match, add to front of list.
+ Maintain Binary tree in symmetric order, in which parent is greater than its left child ( and subtree ) and smaller than its right child ( and subtree). Effectively implementing a Binary Search Tree.
    + insert and gets are straight forward LgN operations. Delete however can, if the Binary tree is not rebalanced, become sqrt(N).
    + In order **Tranverse**:
        + **Tranverse** left subtree
        + enqueue key
        + **Tranverse** right subtree 
        