package week4.priorityQueues;

public class MaxPQUnorderedImp<Key extends Comparable<Key>> implements MaxPQ<Key> {
    private Key[] pq;  // pq[i] = ith element in pq
    private int N;  // number of elements on pq

    public MaxPQUnorderedImp(int capacity){
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    @Override
    public void insert(Key v) {
        pq[N++] = v;
    }

    @Override
    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++){
            if(less(pq[max],pq[i])){
                max = i;
            }
        }
        exch(pq,max,N-1);
        return pq[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(pq[i].toString());
        }
        return sb.toString();
    }

}
