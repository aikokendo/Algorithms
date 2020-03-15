package week2.sorting;

public class ShellSort implements Sort{

    public void sort (Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) {
            h = 3*h + 1; // getting highest num 1,4,13,40... that is under N
        }
        System.out.println("h " + h);
        while(h>=1){
            for (int i = h; i < N; i++) { //start at N
                for (int j = i; j-h >= 0 && less(a[j],a[j-h]); j -=h) {
                        exch(a, j, j - h);
                }
            }
            h = h/3;
            System.out.println("h " + h);
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
