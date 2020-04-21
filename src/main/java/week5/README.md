#Balanced Search Tree
## 2-3 Trees
Tree data structure where every node with children has either
 + 2 children (2-node) and one data element or
 + 3 children (3-node) with two data elements.
 
Insertion (2-node) at bottom:
+ search for key
+ replace 2-node with 3-node

Insertion (3-node) at bottom:
+ add key to 3-node, creating a temporary 4-node.
+ promote middle key into parent
+ repeat until necessary, if root reached and its 4-node, split into 2 nodes and make middle new root.

This insertion scheme guarantees a balanced and sorted tree, which provides guarantee performance and operations in general are of order clgN


## Red-Black BST
Is a kind of self-balancing BST, in which each node has an extra bit  representing the color (Red or Black) of the node. These colors are used to ensure the tree remains approximately balanced during insertion and deletion.

The Red-Black BST implemented is a Left leaning red-black BST (LLRBBST). in which:
+ It represents 2-3 tree as a BST
+ Use "internal" left-leaning links as "glue" for 3-nodes.

A LLRBBST possess the following properties:
+ No node has two red links connected to it: Since red links emulate the 3-node, having two red links would represent a 4-node which is not allowed in 2-3 trees.
+ Every path from root to null link has the same number of Black links: Perfect Black Balance.
+ Red links lean left.

Search, ceiling, selection and most operations are identical as a normal BST, and their perfomance benefit from the guaranteed balance.

However, LLRBBST do require helper methods to execute rotations and color flips. these are necessary to rebalance the tree.
and to do those checks when inserting into the tree.
 
## B-Trees
B-trees are a generalization of 2-3 trees by allowing up to M - 1 key link pairs per node.

guidelines:
+ M should be a large as possible, as a bigger M leads to a lower height.
+ at least 2-key link pairs at root.
+ at least M/2 key link pairs in other nodes.
+ External node contains client keys (the actual data).
+ Internal nodes contain copies of keys to guide search (only references).


# Geometric Applications

##1d range search
Allows to find intersections among geometric objects, used in games, movies, VR, Databases, etc.

1 dimensional = 1 key - similar to symbol table!

Extensions:
+ Range search: find all keys between k1 and k2
+ Range Count: number of keys between k1 and k2

Implementations:
+ unordered array: fast insert, slow range search.
+ ordered array: slow insert, binary search for k1 and k2 to do range search.
+ BST: 
    + count is calculated based on Rank. 
    + search is recursive:
        + recursively find all keys in left subtree [if in range]
        + check key in current node
        + recursively find all keys in right subtree [if in range]

## 1d interval search
used to search intervals that intersect a [lo,hi] interval.
+ create a BST where each node contains an interval [lo,hi]
+ use left endpoint as key, and keep the right endpoint as data element of the node.
+ keep a data element max endpoint that keeps track the max right endpoint for that subtree.


## Kd trees
k-dimensional trees, is a space partitioning data structure for organizing points in k-dimensional space. Is useful for range searches and nearest neighbor searches, as well as databases.
