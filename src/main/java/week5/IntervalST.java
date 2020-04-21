package week5;

import week2.stacksAndQueues.GenericQueueImpLinkList;

public class IntervalST<Key extends Comparable<Key>, Value> {
    // Nondegeneracy assumption: No two intervals have the same left endpoint.
    private Node root;

    private class Node{
        Key key;
        Value val;
        Node left; // smaller keys
        Node right; // larger keys
        Key rightEnd;
        Key maxEnd;

        public Node(Key key, Key rightEnd, Value val, Key maxEnd){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.rightEnd = rightEnd;
            this.maxEnd = maxEnd;
        }
    }

    public IntervalST(){

    }

    public void put(Key lo, Key hi, Value val){
        // if less, go left; if greater, go right; if null; insert.
        root = put(root,lo,hi,val);
    }

    private Node put(Node x,Key key,Key hi,Value val){
        if (x == null){
            return new Node(key,hi,val,hi);
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){ // less
            x.left = put(x.left,key,hi,val);
        }
        if(cmp>0) { // greater
            x.right = put(x.right,key,hi,val);
        }
        if(cmp==0){ // match, which means we are only updating
            x.val = val;
        }
        if(x.right != null && x.right.maxEnd.compareTo(x.maxEnd) > 0) {
            x.maxEnd = x.right.maxEnd;
        }
        return x;
    }

    public Value get(Key lo, Key hi){
        // if less, go left; if greater, go right; if equal; search hit.
        Node current = root;
        while(current != null){
            int cmp = lo.compareTo(current.key);
            if(cmp<0){ // less
                current = current.left;
            }
            if(cmp>0) { // greater
                current = current.right;
            }
            if(cmp==0){ // match
                return current.val;
            }
        }
        return null;

    }

    public void delete(Key lo, Key hi){
        // Hibbard Deletion
        // 1. to delete node k: look for node t containing key k
        // case 0: [0 children] delete t by setting parent link to null
        // case 1: [1 children] return link of child to the parent.
        // case 2: [2 children] find successor x of t. Delete the minimum in t's right subtree. put x in t's spot.
        // 2. Update counts
        // this leads to asymmetric trees.
        root = delete(root,lo,hi);
    }

    private Node delete(Node x, Key key, Key hi){
        if (x == null) return null; // key not found
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { //key is on the left, lets go down one more level
            x.left = delete(x.left,key,hi);
        }
        else if (cmp > 0) { // key is on the right, lets go down one more level
            x.right = delete(x.right,key,hi);
        }
        else { // match! found our node to delete
            if (x.rightEnd.compareTo(hi) != 0){
                return null; // shouldnt happen since we assume nondegeneracy.
            }
            if (x.right == null) return x.left; // no right side. and catches case 0.
            if (x.left == null) return x.right; // no left side. case 1 fulfilled.
            // now we are in case 2
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right); // returns new right and assigns it as a child to x
            x.left = t.left;
        }
        x.maxEnd = x.rightEnd;
        if(x.right != null && x.right.maxEnd.compareTo(x.maxEnd) > 0) {
            x.maxEnd = x.right.maxEnd;
        }
        return x;
    }

    private Node min(Node x){  // find the minimum node in a subtree
        if (x.left == null) return x; // found the leftmost node.
        return min(x.left);
    }


    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null){ // we reached leftmost
            return x.right;
        }
        x.left = deleteMin(x.left); // going deeper in the tree
        x.maxEnd = x.rightEnd;
        if(x.right != null && x.right.maxEnd.compareTo(x.maxEnd) > 0) {
            x.maxEnd = x.right.maxEnd;
        }
        return x;
    }

    public Iterable<Value> intersects(Key lo, Key hi){
        GenericQueueImpLinkList<Value> q = new GenericQueueImpLinkList<Value>();
        intersects(root,lo,hi, q);
        return q;
    }

    private void intersects(Node x, Key lo, Key hi, GenericQueueImpLinkList<Value> q){
        if (x == null) return;
        // if interval in node intersects query interval, we add it.
        if (intersects(x,lo,hi)){
            q.enqueue(x.val);
        }
        else if (x.left == null){
            intersects(x.right,lo,hi,q);
        }
        else if (lo.compareTo(x.left.maxEnd) > 0){
            intersects(x.right,lo,hi,q);
        }
        else {
            intersects(x.left, lo, hi, q);
            intersects(x.right, lo, hi, q);
        }
    }

    private boolean intersects(Node x, Key lo, Key hi){
        if (lo.compareTo(x.key)>= 0 && lo.compareTo(x.rightEnd) <= 0){
            return true;
        }
        else if(hi.compareTo(x.key)>=0 && hi.compareTo(x.rightEnd) <= 0){
            return true;
        }
        return false;
    }
}
