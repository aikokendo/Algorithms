package week3;

import week2.sorting.Sort;

public class BottomUpMergeSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i<N; i+=i){ // to repeat for all subarrays as 1,2,4,8,16, etc...
            for(int lo = 0; lo<N-i; lo+=i+i){ // increase double, since we are increasing both subarrays.
                int hi = lo + i + i - 1;
                if (hi >= N){
                    hi = N-1;
                }
                int mid = lo + i - 1;
                merge(a,lo,mid,hi);
            }
        }

    }


    private static void merge(Comparable[] a, int lo, int mid, int hi){
        assert isSorted(a,lo,mid); // verifies precondition
        assert isSorted(a,mid+1,hi); // verifies precondition

        Comparable[] aux = a.clone();
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


}
