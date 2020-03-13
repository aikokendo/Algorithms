package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStackImpWithIterator<Item> implements GenericStack<Item>, Iterable<Item>{
    private Node first = null;
    private int size;

    private class Node{
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){ return current != null;}
        public void remove() { throw new UnsupportedOperationException();}
        public Item next(){
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


    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }



}
