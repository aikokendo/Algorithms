package week2;

public class StackOfStringsImpDynArray implements StackOfStrings {

    private String[] myStack;
    private int N;

    public StackOfStringsImpDynArray(){ // We dont require a initial size bc we will grow the array dynamically.
        myStack = new String[1];
        N = 0;
    }

    public void push(String item) {
        if(N == myStack.length){
            resize(2 * myStack.length);
        }
        myStack[N++] = item;
    }

    public String pop() {
        String item = myStack[--N];
        myStack[N] = null; // avoid loitering
        if(N > 0 && N == myStack.length/4){  //when is only a quarter full
            resize(myStack.length/2);  //we resize to half the size
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int newSize){
//        System.out.println("Resize called to change from : "+ myStack.length + " to " + newSize );
        String[] newStack = new String[newSize];
        for (int i = 0; i < N; i ++){
            newStack[i] = myStack[i];
        }
        myStack = newStack;
    }
}
