package week4.priorityQueues;

public interface MaxPQ<Key extends Comparable<Key>> {
    void insert(Key v);
    Key delMax();
    boolean isEmpty();
    int size();
}
