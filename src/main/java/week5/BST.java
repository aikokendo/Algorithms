package week5;

import week2.stacksAndQueues.GenericQueueImpLinkList;

public class BST<Key extends Comparable<Key>, Value> extends week4.symbolTables.BST {

    public  boolean contains(Key key){
        return get(key) != null;
    }
    public int size(Key lo, Key hi){
        if(contains(hi)){
            return rank(hi) - rank(lo) + 1;
        }
        else{
            return rank(hi) - rank(lo);
        }
    }

    public Iterable<Key> keys(Key lo, Key hi){
        GenericQueueImpLinkList<Key> q = new GenericQueueImpLinkList<>();
        inorder(root,lo,hi,q);
        return q;
    }

    private void inorder(Node x, Key lo, Key hi, GenericQueueImpLinkList<Key> q){
        if (x == null) return;
        int loCmp = lo.compareTo((Key) x.key);
        int hiCmp = hi.compareTo((Key) x.key);
        if(loCmp <= 0) {
            inorder(x.left, lo, hi, q);
        }
        if (loCmp <= 0 && hiCmp >= 0) {
            q.enqueue((Key) x.key);
        }
        if(hiCmp >= 0){
            inorder(x.right,lo,hi,q);
        }
    }

}
