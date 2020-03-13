package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericBagImpWithIterator<Item> implements GenericBag<Item>,Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    private class Node{
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item>{
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

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public void add(Item item) {
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


    public int size() {
        return size;
    }
}
