package week4.symbolTables;

public class ST<Key extends Comparable<Key>,Value extends Comparable<Value>> {
    private int N;
    private Key[] keys;
    private Value[] vals;
    public ST(int capacity){
        keys = (Key[]) new Comparable[capacity+1];
        vals = (Value[]) new Comparable[capacity+1];
        N = 0;
    }

    public void put(Key key, Value val){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
        }
        else{
            keys[N] = key;
            vals[N++] = val;


            // shift new key to the right position.
            for(int j = N-1; j > 0; j--){
                if(less(keys[j],keys[j-1])){
                    exch(keys,j,j-1);
                    exch(vals,j,j-1);
                }
                else{
                    // all sorted!
                    break;
                }
            }
        }
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void delete(Key key){
        // we will move the key deleted to the end.
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            // found it!
            exch(keys,i,--N);
            exch(vals,i,N);
        }
        // now swim the element up
        for (int j = i; j < N-1; j++){
            if(less(keys[j+1],keys[j])){
                exch(keys,j,j+1);
                exch(vals,j,j+1);
            }
            else{
                // all sorted!
                break;
            }
        }

    }

    public Key[] keys(){
        return keys;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private int rank(Key key){
        // Binary Search
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }


    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
