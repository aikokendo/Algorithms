package week3;

import week2.sorting.Sort;

import java.util.Random;

public class QuickSort3Way implements Sort {

    @Override
    public void sort(Comparable[] a) {
        shuffle(a);  // guarantee performance
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0){
                exch(a, lt++, i++); // is lower so we move our middle forward.
            }
            else if (cmp > 0){
                exch(a,gt--, i);   // is higher so we exchange it with the last element
            }
            else{
                i++; // if equal, we ignore.
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private void shuffle(Comparable[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            exch(a,i,rand.nextInt(i+1));
        }
    }

}
