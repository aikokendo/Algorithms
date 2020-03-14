package week2.sorting;

import java.util.Random;

public class KnuthShuffle implements Shuffle{
    public void shuffle(Comparable[] a){
        int N = a.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            exch(a,i,rand.nextInt(i+1));
        }
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
