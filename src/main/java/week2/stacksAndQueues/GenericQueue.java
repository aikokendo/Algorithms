package week2.stacksAndQueues;

public interface GenericQueue<Item> {
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}
