package week1;

public class BinarySearch {

    public static int search(int[] a, int key){
        //given a sorted array and a key, find the index of the key in the array
        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi){
            //compare key against middle entry
            int mid = lo + (hi -  lo)/2;
            if (a[mid] == key) return mid; // found!
            else if (a[mid] > key)  hi = mid-1; // if key is smaller, go left
            else lo = mid+1; // if key is bigger, go right
        }
        return -1; // not found!
    }

    public static void main(String[] args){
        //basic test
        int[] a = {1,2,3,4,5};
        System.out.println(search(a, 1));
        System.out.println(search(a, 6));
        System.out.println(search(a, 3));
        System.out.println(search(a, 5));
        System.out.println(search(a, 4));
        System.out.println(search(a, 2));
    }


}
