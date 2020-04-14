package week4.symbolTables;

public class main {

    public static void main(String[] args){
        ST<String, Integer> st = new ST<String,Integer>(40);
        String[] someString = "hello world, this is a long text to simulate a stream".split("");
//        String[] someString = "hello".split("");
        for (int i = 0; i < someString.length; i++){
            st.put(someString[i],i);
        }

        Comparable[] keys = st.keys();

        for (int i = 0; i < st.size(); i++){
            System.out.println(keys[i].toString() + " :  " + st.get(keys[i].toString()));
        }

        // Binary Search Tree test

        BST<Integer,String> bst = new BST<Integer,String>();
        bst.put(8,"l");
        bst.put(4,"e");
        bst.put(2,"h");
        bst.put(6,"l");
        bst.put(10,"o");

        System.out.println(bst.get(2)+bst.get(4)+bst.get(6)+bst.get(8)+bst.get(10));

        //min - max
        System.out.println("min: " + bst.get(bst.min()) + ", max: " + bst.get(bst.max()));

        //ceiling - floor
        System.out.println("for key 3: ceiling: " + bst.ceiling(3) + ", floor: " + bst.floor(3));

        //size - rank - select
        System.out.println("size: " + bst.size() + ", with 3 as rank: " + bst.rank(3)+ ", and the item in rank 4 is:" + bst.select(4));

        // deletemin - deletemax
        bst.deleteMin();
        bst.deleteMax();
        bst.delete(6);

        //iterator
        for (Integer i: bst.keys()){
            System.out.println(i);
        }
    }
}
