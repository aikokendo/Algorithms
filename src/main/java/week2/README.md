# Week 2
## Stacks and Queues
### Stacks
LIFO - Last In, First Out

Basic methods:
+ push(item)  -- adds an item to the end of the list
+ pop()  -- retrieves the latest item inserted
+ isEmpty() -- verifies if the stack is empty

Implementations: 
+ Linked-Lists: Node implementation, keeping track of newest item.
+ Dynamic Array: keep items in an array, keeping track of the last index in which data was inserted. Array should be resized as needed.

### Queues

FIFO - Fist In, First Out

Basic Methods:
+ Enqueue(item) -- adds an item to the end of the list
+ Dequeue() -- retrieves the oldest item in the list
+ isEmpty() -- verifies if the queue is empty

Implementations:
+ Linked-List: Node implementation, keeping track of oldest and newest item.
+ Dynamic Array: keep items in an array, keeping track of the index for the oldest and newest item inserted. Array should resize as needed.

## Iterators
Support iteration without revealing the internal representation of the data structure.
It is achieved by implementing Iterable and Iterator. 

Iterable: 
+ Requires the implementation of the method 
    public Iterator<Item> iterator() - which should return an iterator.
    
Iterator:
+ Requires the implementation of the method boolean hasNext() and Item next(). - keeps track of the elements and traverse the data structure.
## Bags

To be used when the client doesn't care about the order, just wants to keep everything and iterate it.

Solution: Implement either a stack with no pop or a queue with no dequeue.

## In Java
java.util.List - ready implementation for sequence of items. (add,remove,isEmpty, etc)
 + java.util.ArrayList - Uses resizing array.
 + java.util.LinkedList - Uses linked list.
 + java.util.Stack - supports push(), pop(), iteration.
 + java.util.Queue - an interface, not an implementation!
 
 These libraries are good for projects where execution time is not as important or negligible. but they may be too bloated or designed too broadly for our needs. In cases that performance is of outmost importance, having your own implementation could be beneficial.
 
 ## Applications
 + Dijkstra Two Stack Algorithm: Manages two stacks to keep track of an Arithmetic expression evaluation.
 
 ## Sorting
Implementation of the following sorting algorithms:
+ Selection Sort
+ Insertion Sort 
+ Shell Sort

## Shuffle
Implementation of the following shuffle algorithms:
+ Shuffle Sort
+ Knuth Shuffle