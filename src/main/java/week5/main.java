package week5;

public class main {

    public static void main(String[] args){

        // Red-Black BST
        RedBlackBST<Integer,Integer> rb = new RedBlackBST<Integer,Integer>();
        rb.put(10,3);
        rb.put(9,2);
        rb.put(8,1);

        for (Integer i: rb.keys()){
            System.out.println(rb.get(i));
        }


        // 1d interval search test
        BST<Integer,Integer> bst = new BST<Integer,Integer>();
        bst.put(8,8);
        bst.put(4,4);
        bst.put(2,2);
        bst.put(6,6);
        bst.put(10,10);

        System.out.println("number of elements in range: " + bst.size(4,9));
//        iterator
        for (Integer i: bst.keys(4,9)){
            System.out.println(i);
        }


        // intervalST

        IntervalST<Integer,Integer> ist = new IntervalST<Integer,Integer>();
        ist.put(17,19,0);
        ist.put(5,8,1);
        ist.put(21,24,2);
        ist.put(4,8,3);
        ist.put(15,18,4);
        ist.put(7,10,5);
        ist.put(16,22,6);

        for (Integer i: ist.intersects(21,23)){
            System.out.println(i);
        }

    }
}
