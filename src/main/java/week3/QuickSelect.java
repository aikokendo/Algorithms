package week3;

import java.util.Random;

public class QuickSelect {
    public static Comparable select(Comparable[] a, int k){
        shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while(hi > lo){
            int j = partition(a,lo,hi);  // j is already in its final position.
            if (j < k) lo = j + 1;  // if j is lower than k, we need to focus on all the elements over j.
            else if (j > k) hi = j - 1; // if j is greater than k, we need to focus on all elements uder j.
            else return a[k]; // j == k!
        }
        return a[k]; // hi and lo met
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

    private static void shuffle(Comparable[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            exch(a,i,rand.nextInt(i+1));
        }
    }


    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(){
        QuickSelect m = new QuickSelect();
//        m.select();
    }

}
