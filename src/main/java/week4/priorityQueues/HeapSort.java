package week4.priorityQueues;

import week2.sorting.Sort;

public class HeapSort<Key extends Comparable<Key>>{

    public void sort(Key[] a) {
        // first pass: build a heap
        int N = a.length;
        for(int i = N/2; i >= 0; i--){ // starts on the first node with children.
            sink(a,i,N);
        }

        // second pass: remove max key
        N--;
        while(N > 1){
            exch(a, 0, N);  // extract largest item
            sink(a, 0, --N); // sink new root, excluding last position, as its already sorted.
        }
    }

    private void sink(Key[] pq, int k, int N){
        while(2*k < N){  // still have children.
            int j = 2*k;
            if (j+1 < N && less(pq[j],pq[j+1])) j++; // choose the child that is largest.
            if(!less(pq[k],pq[j])) break; // if parent is already greater than greater child, break
            exch(pq,k,j);
            k = j;
        }
    }

    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
