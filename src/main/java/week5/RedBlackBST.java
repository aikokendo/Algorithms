package week5;

import week2.stacksAndQueues.GenericQueueImpLinkList;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left; // smaller keys
        Node right; // larger keys
        boolean color; // color of parent link

        public Node(Key key, Value val, boolean color){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if (x == null) return false; // null links are black
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        // orient a right-leaning red link to left leaning
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        // orient a left-leaning red link to right leaning
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h){
        // recolor to split a 4-node
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val){
        // if less, go left; if greater, go right; if null; insert.
        root = put(root,key,val);
    }

    private Node put(Node x,Key key, Value val){
        if (x == null){
            return new Node(key,val,RED);
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){ // less
            x.left = put(x.left,key,val);
        }
        if(cmp>0) { // greater
            x.right = put(x.right,key,val);
        }
        if(cmp==0){ // match, which means we are only updating
            x.val = val;
        }
        // as we go back up the tree, we need to make sure it is balanced,
        // and we do not have 4-nodes or right leaning red links.

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x); // balance 4-node
        if(isRed(x.left) && isRed(x.right)) flipColors(x); //split 4-node
        return x;
    }

    public Value get(Key key){
        // exactly the same as a normal BST
        // ceiling, selection and other operations are also identical
        Node current = root;
        while(current != null){
            int cmp = key.compareTo(current.key);
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

    public Iterable<Key> keys(){
        GenericQueueImpLinkList<Key> q = new GenericQueueImpLinkList<>();
        inorder(root,q);
        return q;
    }

    private void inorder(Node x, GenericQueueImpLinkList<Key> q){
        if (x == null) return;
        inorder(x.left,q);
        q.enqueue(x.key);
        inorder(x.right,q);
    }



}
