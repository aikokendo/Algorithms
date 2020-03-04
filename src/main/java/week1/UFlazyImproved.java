package week1;

public class UFlazyImproved implements UF{
    private int[] ids;
    private int[] sz;  //keep size of tree in consideration so it doesn't create deep trees.

    //initialize union-find data structure with N-objects (0 to N-1)
    public UFlazyImproved(int N){
        ids = new int[N];
        sz = new int[N];
        for (int k = 0; k < N; k++){
            ids[k] = k;
            sz[k] = 1;
        }
    }

    //find the root of the current node
    private int root(int i){
        while( i != ids[i]){
            i = ids[i];
        }
        return i;
    }

    //add connection between p and q
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if (i == j){ //they already belong to the same tree
            return;
        }
        // when merging trees, we merge the smaller tree into the bigger one.
        if (sz[i]<sz[j]){  // if a tree is smaller than the other, we want to put the smaller tree into the bigger one.
            ids[i] = j;  // making small tree point to the bigger one! merged!
            sz[j] += sz[i];   //any nodes the smaller tree possessed have to be added to the bigger tree as now they are now merged.
        }
        else{
            ids[j] = i;
            sz[i] += sz[j];
        }
    }

    //are p and q in the same component?
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

}
