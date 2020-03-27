package week3;

import week2.sorting.Sort;
import java.util.Random;

public class main {

    public static void main(String[] args){
        Random rand = new Random();
//        Sort mySort = new MergeSort();
//        Sort mySort = new BottomUpMergeSort();
//        Sort mySort = new QuickSort();
        Sort mySort = new QuickSort3Way();
        QuickSelect mySelect = new QuickSelect();

        int size = 20;
        Integer[] a = new Integer[size];
        for (int i = 0; i < a.length; i++){
            a[i] = rand.nextInt(size);
        }


        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();

        mySort.sort(a);
//        System.out.println(mySelect.select(a,19));

        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();


        InsertionSortComparator newSort = new InsertionSortComparator();
        String[] b = new String[3];
        b[0] = "a";
        b[1] = "B";
        b[2] = "A";
        System.out.println(b[0] + b[1]+ b[2]);
        newSort.sort(b, String.CASE_INSENSITIVE_ORDER);
        System.out.println(b[0] + b[1]+ b[2]);





    }
}
