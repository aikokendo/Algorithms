package week4.priorityQueues;

import java.util.Random;

public class main {
    public static void main(String[] args){

        int M = 10;
        MinPQ<String> pq = new MinPQOrderedImp<String>();
        String[] someString = "hello world, this is a long text to simulate a stream".split("");
//
        for (String s: someString){
            pq.insert(s);
            if (pq.size() > M){
                pq.delMin();
            }
        }
        System.out.println(pq.toString());

//
//        MaxPQ<String> pq2 = new MaxPQUnorderedImp<String>(100);
//
//        for (String s: someString){
//            pq2.insert(s);
//            if (pq2.size() > M){
//                pq2.delMax();
//            }
//        }
//        System.out.println(pq2.toString());
        Random rand = new Random();
        int N = 10;
        int O = 5;
        BinaryHeap bh = new BinaryHeap(N);
        for (int i = 0; i < N; i++){
            bh.insert(rand.nextInt(10));
            if (bh.size() > O){
                bh.delMax();
            }
        }

        System.out.println(bh.toString());


        int size = 8;
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++){
            a[i] = rand.nextInt(size);
        }
        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();

        HeapSort hs = new HeapSort();
        hs.sort(a);

        for (int i: a){
            System.out.print(i+ ",");
        }
        System.out.println();





    }
}
