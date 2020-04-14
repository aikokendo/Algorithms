package week2.stacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericQueueImpLinkList<Item> implements  GenericQueue<Item>,Iterable<Item> {
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

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current!= null;
        }

        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
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

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}
