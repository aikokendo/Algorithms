package week2;

public class QueueOfStringsImpDynArrays implements QueueOfStrings{
     private int head;
     private int tail;
     private String[] myQueue;
     private int size;

    public QueueOfStringsImpDynArrays(){ // We don't require a initial size bc we will grow the array dynamically.
        myQueue = new String[1];
        head = 0;
        tail = 0;
    }

    public void enqueue(String item) {
        myQueue[tail++] = item;
        if(tail == myQueue.length){
            resize(2 * myQueue.length);
        }
    }

    public String dequeue() {
        String item = myQueue[head];
        myQueue[head++] = null;
        if(head != tail && size() == myQueue.length/4){
            resize(myQueue.length/2);
        }
        return item;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return tail-head;
    }

    private void resize(int newSize){
//        System.out.println("Resize called to change from : "+ myQueue.length + " to " + newSize );
        String[] newQueue = new String[newSize];
        int newIndex = 0;
        for (int i = head; i < tail; i ++){
            newQueue[newIndex++] = myQueue[i];
        }
        myQueue = newQueue;
        head = 0;
        tail = newIndex;

    }
}
