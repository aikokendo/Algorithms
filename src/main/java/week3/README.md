# Advanced Sorting algorithms

## MergeSort (recursive)
- Divide array into two halves
- Recursively sort each half
- Merge two sorted halves

MergeSort is Nlog(N). 

## Bottom-up MergeSort
No recursion! We start by the smallest arrays possible, size 1, and as we merge, the array is sorted.
- Pass through array, merging subarrays of size 1.
- Repeat for subarrays of size 2, 3, 8, 16, ... N/2

Bottom-up MergeSort is Nlog(N).

## Sorting Complexity
Computational Complexity: Study of efficiency of algorithms.
Things to consider to solve particular problems:
- Model computation
- Cost Model 
- Upper Bound / Lower Bound

## Stability
if sorting by "x", and then by "y", we preserve "x" sorting.

Stable sorts:
+ Insertion Sort
+ Merge Sort

Unstable sorts:
+ Selection Sort
+ Shell Sort
+ Quick Sort

## QuickSort

+ Shuffle Array (to guarantee performance)
+ partition so that for some j
    + entry a[j] is in place
    + no larger entry to the left of j
    + no smaller entry to the right of j
+ Sort each element recursively

## Selection 
Given an array of n items, find the kth largest.


