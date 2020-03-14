package week2.sorting;


public class SelectionSort implements Sort{
    public void sort (Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            // find smallest and swamp with i
            for (int j = i; j < N; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);

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
