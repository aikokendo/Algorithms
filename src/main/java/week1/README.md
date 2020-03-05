# Week 1
## Union-Find
### Dynamic Connectivity
Given a set of N objects:
- Union Command: connect two objects
- Find/Connect query: is there a path connecting the two objects?

assume connections are reflexive, symmetric and transitive.

### Percolation
An application for a quick union-find problem. 

the program should identify if, given a grid of open and closed positions, the top row is connected to the bottom row.
A simple way to understand this, is to imagine that water is being pour over the grid. We would say it will percolate if that flow of water can make it from the top of the grid to the bottom of the grid through open positions.

+ Backwater: False positives in the isFull() method can happen if percolation has been achieved already. Considering the isFull() method should identify those positions that are "full of water" (following the previous analogy) it should only be true for those open positions that are connected to the top.
In order to address this, a second union-find is maintained to keep track of what positions are connected to the virtual top.

### Binary Search
Basic implementation of binary search, not recursive.