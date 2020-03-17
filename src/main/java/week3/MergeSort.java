package week3;

import week2.sorting.Sort;

public class MergeSort implements Sort {

    private Comparable[] aux;
    private static InsertionSort mySort;
    private static int CUTOFF = 5;

    @Override
    public void sort(Comparable[] a) {
        mySort = new InsertionSort();
        aux = new Comparable[a.length];  // is good to do the declaration outside of the recursion
        sort(a,aux,0,a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1,hi);
        if (less(a[mid],a[mid+1])) return;  // already sorted! No need to merge.
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a,lo,mid); // verifies precondition
        assert isSorted(a,mid+1,hi); // verifies precondition

        // Merge sort has too much overhead for tiny sub arrays.
        // is more efficient to just run an insertionsort after certain cutoff.
        if( hi<= lo + CUTOFF - 1){
            mySort.sort(a,lo,hi);
            return;
        }

        aux = a.clone();
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++){
            if (i > mid){  //got first half already assigned
                a[k] = aux[j++];
            }
            else if( j > hi) { // got second half already assigned
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }

        assert isSorted(a, lo, hi);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i< hi; i++){
            if (less(a[i+1],a[i])){
                return false;
            }
        }
        return true;
    }


    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }



    private class InsertionSort{

        public void sort (Comparable[] a, int lo, int hi) {
            for (int i = lo; i <= hi; i++){
                for(int j = i; j > lo; j--){
                    if(less(a[j],a[j-1])){
                        exch(a,j,j-1);
                    }
                    else{
                        // all sorted!
                        break;
                    }
                }
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




}
