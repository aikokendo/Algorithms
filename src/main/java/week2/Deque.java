package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    private class ItemIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){return current!=null;}
        public void remove(){
            // Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
            throw new UnsupportedOperationException();
        }
        public Item next(){
            // Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // construct an empty deque
    public Deque(){
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }


    // add the item to the front
    public void addFirst(Item item){
        // Throw an IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
        if (item == null){
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        if (last == null){   //special case if list is empty
            last = first;
        }
        else{
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        // Throw an IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
        if (item == null){
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        if (first == null){  //special case if list is empty
            first = last;
        }
        else{
            oldLast.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        // Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
        if (first == null){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if (first == null){  // special case, list is empty
            last = null;
        }
        else{
            first.prev = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        // Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
        if (last == null){
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.prev;
        if (last == null){  //special case, list is empty
            first = null;
        }
        else{
            last.next = null;
        }
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    public static void main( String[] args){
        Deque<String> d = new Deque<String>();
        d.addFirst("Hello");
        d.addLast("Bye");
        System.out.println(d.size());
        for (String s: d){
            System.out.println(s);
        }
        System.out.println(d.removeLast());
        System.out.println(d.removeFirst());
        if (d.isEmpty()) System.out.println("deque is empty");

    }

}
