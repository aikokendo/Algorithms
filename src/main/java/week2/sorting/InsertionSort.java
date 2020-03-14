package week2.sorting;

public class InsertionSort implements Sort{

    public void sort (Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
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
