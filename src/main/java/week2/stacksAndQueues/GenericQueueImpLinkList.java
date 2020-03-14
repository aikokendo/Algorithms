package week2.stacksAndQueues;

public class GenericQueueImpLinkList<Item> implements  GenericQueue<Item> {
    // Not implemented here but:
    // For an Array implementation we require an item casted Object implementation as follows:
    // a = (Item[]) new Object[capacity];
    // will throw a warning but is the current way to do it in java, sadly.

    private Node first = null;
    private Node last = null;
    private int size;

    private class Node{
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null){
            first = last;
        }
        else{
            oldLast.next = last;
        }
        size++;

    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        size--;
        if(isEmpty()){
            last = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
