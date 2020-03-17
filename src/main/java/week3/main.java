package week3;

import week2.sorting.Sort;

import java.util.Random;

public class main {

    public static void main(String[] args){
        Random rand = new Random();
//        Sort mySort = new MergeSort();
        Sort mySort = new BottomUpMergeSort();

        int size = 33;
        Integer[] a = new Integer[size];
        for (int i = 0; i < a.length; i++){
            a[i] = rand.nextInt(size);
        }


        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();

        mySort.sort(a);


        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();

    }
}
