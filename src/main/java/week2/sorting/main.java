package week2.sorting;

import java.util.Random;
import java.util.SortedMap;

public class main {
    public static void main(String[] args){
        Random rand = new Random();
        int size = 5;
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(size);
        }

        for (int i: array){
            System.out.print(i+ ",");
        }
        System.out.println();

//        Sort mySort = new SelectionSort();
//        Sort mySort = new InsertionSort();
        Sort mySort = new ShellSort();
        mySort.sort(array);

        for (int i: array){
            System.out.print(i + ",");
        }

        System.out.println("\nShuffling with ShuffleSort: ");
        Shuffle myShuffle = new ShuffleSort();
        myShuffle.shuffle(array);
        for (int i: array){
            System.out.print(i + ",");
        }

        System.out.println("\nShuffling with Knuth Sort: ");
        Shuffle myShuffle2 = new KnuthShuffle();
        myShuffle2.shuffle(array);
        for (int i: array){
            System.out.print(i + ",");
        }


    }
}
