package week3;

import week2.sorting.Sort;

import java.util.Random;

public class QuickSort implements Sort {

    private static InsertionSort mySort;
    private static int CUTOFF = 10;

    @Override
    public void sort(Comparable[] a) {
        mySort = new InsertionSort();
        shuffle(a);  // guarantee performance
        sort(a,0,a.length-1);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) { //they crossed
                break;
            }
            exch(a, i, j);
        }
        exch(a,lo,j);

        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        // same as merge sort, for smaller subarrays, is much more cost effective to execute an insertion sort.
        if( hi <= lo + CUTOFF - 1) {
            mySort.sort(a,lo,hi);
            return;
        }

        // another improvement is to use the median as the pivot
        // median of a sample, slightly reduces the number of compares
        int m = medianOf3(a,lo,lo + (hi - lo)/2, hi);
        exch(a,lo,m);

        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int medianOf3(Comparable[] a, int x, int y, int z){
        if (less(a[x],a[y])){
            if(less(a[z],a[x])){
                return x;
            }
            else{
                if (less(a[z],a[y])){
                    return z;
                }
                return y;
            }
        }
        else{
            if(less(a[x],a[z])){
                return x;
            }
            else{
                if(less(a[z],a[y])){
                    return y;
                }
                return z;
            }
        }
    }

    private void shuffle(Comparable[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            exch(a,i,rand.nextInt(i+1));
        }
    }


    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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

    }
}
