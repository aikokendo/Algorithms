package week3;

import java.util.Comparator;

public class InsertionSortComparator{

    public void sort (Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
                if(less(comparator,a[j],a[j-1])){
                    exch(a,j,j-1);
                }
                else{
                    // all sorted!
                    break;
                }
            }
        }
    }


    private boolean less(Comparator c, Object a, Object b){
        return c.compare(a,b) < 0;
    }

    private void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
