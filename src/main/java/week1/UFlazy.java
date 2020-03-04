package week1;

public class UFlazy implements UF{
    private int[] ids;

    //initialize union-find data structure with N-objects (0 to N-1)
    public UFlazy(int N){
        ids = new int[N];
        for (int k = 0; k < N; k++){
            ids[k] = k;
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
        ids[i] = j;
    }

    //are p and q in the same component?
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

}
