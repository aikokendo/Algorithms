package week2;

import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] myArray;
    private int tail;
    private int size;

    private class ItemIterator implements Iterator<Item>{
        private Item[] myA = reshuffle(myArray).clone();
        private int numElements = size;
        private int i = 0;
        public boolean hasNext(){return numElements != 0;}
        public void remove(){
            // Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
            throw new UnsupportedOperationException();
        }
        public Item next(){
            // Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = myA[i++];
            if (item == null){  // we get next item
                return next();
            }
            else{
                numElements--;
                return item;
            }
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue(){
        myArray = (Item[]) new Object[1];  // cast needed to use generic.
        tail = 0;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size==0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        // Throw an IllegalArgumentException if the client calls enqueue() with a null argument.
        if (item == null){
            throw new IllegalArgumentException();
        }
        myArray[tail++] = item;
        size++;
        if(tail == myArray.length){
            resize(2 * size); // why size and not the array length? the length may be full of holes. size is a better measurement.
        }
    }


    // remove and return a random item
    public Item dequeue(){
        // Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
        if (size == 0){
            throw new NoSuchElementException();
        }
        Random rand = new Random();
        Item item;
        while (true){
            int randNum = rand.nextInt(tail);
            if (myArray[randNum] != null){
                item = myArray[randNum];
                myArray[randNum] = null;
                size--;
                if (size > 0 && size == myArray.length/4){ //if only 1/4 is full of valid items, we should resize
                    resize(size*2);  // to double the size
                }
                return item;
            }
        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        Random rand = new Random();
        while (true) {
            int randNum = rand.nextInt(tail);
            if (myArray[randNum] != null) {
                return myArray[randNum];
            }
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new ItemIterator();
    }

    private void resize(int newSize){
        Item[] newQueue = (Item[]) new Object[newSize];
        int newIndex = 0;
        for (int i = 0; i < tail; i ++){  // traverse full array
            if (myArray[i] != null){
                newQueue[newIndex++] = myArray[i];
            }
        }
        myArray = newQueue;
        tail = newIndex;

    }

    private Item[] reshuffle(Item[] a){
        Random rand = new Random();
        for (int i = tail-1; i > 0; i--){
            int j = rand.nextInt(i);
            // exchange a[j] with a[i]
            Item aj = a[j];
            a[j] = a[i];
            a[i] = aj;
        }
        return a;
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        r.enqueue("h");
        r.enqueue("e");
        r.enqueue("l");
        r.enqueue("l");
        r.enqueue("o");

        for (String s: r){
            System.out.println(s);
        }



        System.out.println("--------------------------------------");
        System.out.println("dequeue: " + r.dequeue());
        System.out.println("--------------------------------------");
        for (String s: r){
            System.out.println(s);
        }

        System.out.println("--------------------------------------");
        System.out.println("sample: " + r.sample());
        System.out.println("dequeue: " + r.dequeue());
        System.out.println("--------------------------------------");
        for (String s: r){
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("dequeue: " + r.dequeue());
        System.out.println("dequeue: " + r.dequeue());
        System.out.println("current size " + r.size );
        System.out.println("dequeue: " + r.dequeue());
        if (r.isEmpty()) System.out.println("queue empty!");
        System.out.println("--------------------------------------");

        // Nested iterators are independent of each other.
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++){
            queue.enqueue(i);
        }
        for (int a : queue) {
            for (int b : queue)
                System.out.print(a + "-" + b + " ");
            System.out.println();
        }





    }
}