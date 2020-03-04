package week1;

public class UFlazyImprovedCompression implements UF{
    private int[] ids;
    private int[] sz;

    //initialize union-find data structure with N-objects (0 to N-1)
    public UFlazyImprovedCompression(int N){
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
            ids[i] = ids[ids[i]];   //flattening the trees when checking for roots, because why not? xD
            i = ids[i];
        }
        return i;
    }

    //add connection between p and q
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if (i == j){
            return; //they already belong to the same tree
        }
        // when merging trees, we merge the smaller tree into the bigger one.
        if (sz[i]<sz[j]){
            ids[i] = j;
            sz[j] += sz[i];
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
