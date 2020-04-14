package week4.priorityQueues;



public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public BinaryHeap(int capacity){
        pq = (Key[]) new Comparable[capacity+1];
        N = 0;
    }

    public void insert(Key x){
        pq[++N] = x;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(pq,1,N--); // promote lowest node to root, as is the one that will move the tree the least
        sink(1);
        pq[N+1] = null; // clean up
        return max;
    }

    public int size(){
        return N - 1;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    private void swim(int k){
        while(k > 1 && less(pq[k/2],pq[k])){  // as long as we are not in the root, and parent is smaller than child
            exch(pq,k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){

        while(2*k <= N){  // still have children.
            int j = 2*k;
            if (j < N && less(pq[j],pq[j+1])) j++; // choose the child that is largest.
            if(!less(pq[k],pq[j])) break; // if parent is already greater than greater child, break
            exch(pq,k,j);
            k = j;
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


    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(pq[i] + ", ");
        }

        sb.deleteCharAt(sb.length()-2);
        return sb.toString();
    }

}
