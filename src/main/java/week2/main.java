package week2;

import java.util.Iterator;

public class main {

    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Starting Stack");
        System.out.println("-------------------------");
        StackOfStrings myStack = new StackOfStringsImpDynArray();
        myStack.push("Hola");
        myStack.push("hello");
        myStack.push("oi");
        myStack.push("nihao");
        myStack.push("neihou");
        myStack.push("konnichiwa");
        myStack.push("bonjour");
        myStack.push("annyeonghaseyo");
        myStack.push("Guten tag");

        while(!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }


        System.out.println("-------------------------");
        System.out.println("Starting Queue");
        System.out.println("-------------------------");

        QueueOfStrings myQueue = new QueueOfStringsImpDynArrays();
        myQueue.enqueue("Hola");
        myQueue.enqueue("hello");
        myQueue.enqueue("oi");
        myQueue.enqueue("nihao");
        myQueue.enqueue("neihou");
        myQueue.enqueue("konnichiwa");
        myQueue.enqueue("bonjour");
        myQueue.enqueue("annyeonghaseyo");
        myQueue.enqueue("Guten tag");

        while(!myQueue.isEmpty()){
            System.out.println(myQueue.dequeue());
        }

        System.out.println("-------------------------");
        System.out.println("Starting Generic Stack");
        System.out.println("-------------------------");

        GenericStack<Integer> myGenStack = new GenericStackImpWithIterator<Integer>();
        myGenStack.push(1);  // Integer does auto boxing for int values
        myGenStack.push(2);
        myGenStack.push(3);
        while(!myGenStack.isEmpty()){
            System.out.println(myGenStack.pop());
        }

        System.out.println("-------------------------");
        System.out.println("Starting Generic Queue");
        System.out.println("-------------------------");

        GenericQueue<Integer> myGenQueue = new GenericQueueImpLinkList<Integer>();
        myGenQueue.enqueue(1);
        myGenQueue.enqueue(2);
        myGenQueue.enqueue(3);
        while(!myGenQueue.isEmpty()){
            System.out.println(myGenQueue.dequeue());
        }

        System.out.println("-------------------------");
        System.out.println("Starting Generic Bag");
        System.out.println("-------------------------");
        GenericBagImpWithIterator<Integer> myBag = new GenericBagImpWithIterator<Integer>();
        myBag.add(1);
        myBag.add(2);
        myBag.add(3);
        for (Integer i: myBag){
            System.out.println(i);
        }

        System.out.println("-------------------------");
        System.out.println("Starting Dijkstra two stack algorithm");
        System.out.println("-------------------------");
        DijkstraTwoStack example = new DijkstraTwoStack();
        String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println(example.evaluate(expression));
        expression = "( 1 + ( 5 * ( 4 * 5 ) ) )";
        System.out.println(example.evaluate(expression));



    }


}
