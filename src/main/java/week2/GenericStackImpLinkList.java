package week2;

public class GenericStackImpLinkList<Item> implements GenericStack<Item> {
    // Not implemented here but:
    // For an Array implementation we require an item casted Object implementation as follows:
    // a = (Item[]) new Object[capacity];
    // will throw a warning but is the current way to do it in java, sadly.

    private Node first = null;
    private int size;

    private class Node{
        Item item;
        Node next;
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
