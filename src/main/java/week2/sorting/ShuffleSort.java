package week2.sorting;

import java.util.Random;

public class ShuffleSort implements Shuffle{

    public void shuffle(Comparable[] a){
        Random rand = new Random();
        int N = a.length;
        Integer[] genIndex = new Integer[N];
        for (int i = 0; i < a.length; i++){
            genIndex[i] = rand.nextInt(N*10);
        }
        // insert sort
        for (int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
                if(less(genIndex[j],genIndex[j-1])){
                    exch(a,j,j-1);
                    exch(genIndex,j,j-1);
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
