package week4.symbolTables;

import week2.stacksAndQueues.GenericQueueImpLinkList;

public class BST<Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node{
        Key key;
        Value val;
        Node left; // smaller keys
        Node right; // larger keys
        int count;

        public Node(Key key, Value val, int count){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.count = count;
        }
    }

    public void put(Key key, Value val){
        // if less, go left; if greater, go right; if null; insert.
        root = put(root,key,val);
    }

    private Node put(Node x,Key key, Value val){
        if (x == null){
            return new Node(key,val,1);
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
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        // if less, go left; if greater, go right; if equal; search hit.
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

    public void delete(Key key){
        // Hibbard Deletion
        // 1. to delete node k: look for node t containing key k
        // case 0: [0 children] delete t by setting parent link to null
        // case 1: [1 children] return link of child to the parent.
        // case 2: [2 children] find successor x of t. Delete the minimum in t's right subtree. put x in t's spot.
        // 2. Update counts
        // this leads to asymmetric trees.
        root = delete(root,key);

    }

    private Node delete(Node x, Key key){
        if (x == null) return null; // key not found
        int cmp = key.compareTo(x.key);
        if (cmp < 0) { //key is on the left, lets go down one more level
            x.left = delete(x.left,key);
        }
        else if (cmp > 0) { // key is on the right, lets go down one more level
            x.right = delete(x.right,key);
        }
        else { // match! found our node to delete
            if (x.right == null) return x.left; // no right side. and catches case 0.
            if (x.left == null) return x.right; // no left side. case 1 fulfilled.
            // now we are in case 2
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right); // returns new right and assigns it as a child to x
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right); //update subtree
        return x;
    }

    private Node min(Node x){  // find the minimum node in a subtree
        if (x.left == null) return x; // found the leftmost node.
        return min(x.left);
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


    public Key min(){
        Node current = root;
        while(current.left!=null){
            current = current.left;
        }
        return current.key;
    }

    public Key max(){
        Node current = root;
        while(current.right!=null){
            current = current.right;
        }
        return current.key;
    }

    public Key floor(Key key){
        // largest key <= to given key
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key){
        if (x == null) return x;
        int cmp = key.compareTo(x.key);
        if (cmp == 0){ // match.
            return x;
        }
        if (cmp < 0){
            // must be to the left.
            return floor(x.left,key);
        }
        // must look on the right.
        Node t = floor(x.right,key);
        if(t!=null) return t;
        else return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key){
        if(x == null) return x;
        int cmp = key.compareTo(x.key);
        if (cmp == 0){ // match
            return x;
        }
        if (cmp > 0){ //checking to the right.
            return ceiling(x.right,key);
        }
        Node t = ceiling(x.left,key);
        if (t != null) return t;
        else return x;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.count;
    }

    public boolean isEmpty(){
        return (root == null);
    }


    public int rank(Key key){
        // how many keys < k?
        return rank(key,root);
    }

    private int rank(Key key, Node x){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0){ // we need to go lower in the left
            return rank(key,x.left);
        }
        else if (cmp> 0) { // we should consider the full left sub tree, and the subset of right sub tree that is lower than key
            return 1 + size(x.left) + rank(key, x.right);
        }
        return size(x.left); // match. should count all in left subtree
    }

    public Key select(int k){
        // what is the key in rank k
        return select(k,root);
    }

    private Key select(int k, Node x){
        if (x == null) return null;
        int keyRank = rank(x.key);
        if (keyRank > k){
            return select(k, x.left);
        }
        else if (keyRank < k){
            return select(k,x.right);
        }
        return x.key;
    }


    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null){ // we reached leftmost
            return x.right;
        }
        x.left = deleteMin(x.left); // going deeper in the tree
        x.count = 1 + size(x.left) + size(x.right); // updating count
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if (x.right == null) { // we reached rightmost
            return x.left;
        }
        x.right = deleteMax(x.right); // going deeper
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }


}
