package week4.priorityQueues;

public class MinPQOrderedImp<Key extends Comparable<Key>> implements MinPQ<Key> {

    // my attempt at an ordered linked list approach.
    // insert: best case - Constant
    //         average case - ~NLgN
    //         Worst case - N
    // delete: best/worst - constant

    private class Node{
        Key item;
        Node next;
    }

    private Node first; // smallest element first, as a stack
    private int size;

    @Override
    public void insert(Key v) {
        // create node then locate where it should go.
        size++;
        Node newNode = new Node();
        newNode.item = v;
        newNode.next = null;
        if (first == null){  // empty queue
            first = newNode;
            return;
        }

        if(less(v,first.item)){ // newest smallest item
            Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            return;
        }

        Node current = first;
        while(true){
            if(current.next == null){ // end of the list
                current.next = newNode;
                return;
            }
            else if(less(current.item,v) && less(v,current.next.item)) { // add a new node in the middle.
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            else if(current.item.compareTo(v) == 0){  // if they are the same, just add it after
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public Key delMin() {
        // the smallest is first.
        Key item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public String toString(){
        if(isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while(true){
            if(current == null){
                break;
            }
            else{
                sb.append(current.item);
            }
            current = current.next;
        }
        return sb.toString();
    }
}
