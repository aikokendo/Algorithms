package week2;

public class StackOfStringsImpLinkList implements StackOfStrings {

    private Node first = null;
    private int size;

    private class Node{
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public String pop() {
        String item = first.item;
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
