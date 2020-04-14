package week4.priorityQueues;

public interface MinPQ<Key extends Comparable<Key>> {
    void insert(Key v);
    Key delMin();
    boolean isEmpty();
    int size();
}
