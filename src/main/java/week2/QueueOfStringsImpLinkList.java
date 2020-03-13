package week2;

public class QueueOfStringsImpLinkList implements QueueOfStrings {
    private Node first = null;
    private Node last = null;
    private int size;

    private class Node{
        String item;
        Node next;
    }

    public QueueOfStringsImpLinkList(){
        size = 0;
    }

    public void enqueue(String item) {
         Node oldLast = last;
         last = new Node();
         last.item = item;
         last.next = null;
         if(isEmpty()){   // special case if queue is empty
            first = last;
            }
         else {
             oldLast.next = last;
         }
        size++;
    }

    public String dequeue() {
        Node oldFirst = first;
        first = first.next;
        size--;
        if (isEmpty()){  // special case if queue is empty
            last = null;  // clean last reference
        }
        return oldFirst.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
