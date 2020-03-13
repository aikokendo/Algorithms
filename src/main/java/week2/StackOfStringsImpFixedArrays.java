package week2;

public class StackOfStringsImpFixedArrays implements StackOfStrings {

    private String[] myStack;
    private int N;

    public StackOfStringsImpFixedArrays(int capacity){ // Requires size to be defined at creation which is a limitation.
        myStack = new String[capacity];
        N = 0;
    }

    public void push(String item) {
        myStack[N++] = item;
    }

    public String pop() {
        String item = myStack[--N];
        myStack[N] = null; // avoid loitering
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
