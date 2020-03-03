package week1;

public class UF {
    private int[] ids;

    //initialize union-find data structure with N-objects (0 to N-1)
    public UF(int N){
        ids = new int[N];
        for (int k = 0; k < N; k++){
            ids[k] = k;
        }
    }

    //add connection between p and q
    public void union(int p, int q){
        int newId = ids[p];
        int oldId = ids[q];
        for (int k = 0; k < ids.length; k++){
            if (ids[k]== oldId){
                ids[k]= newId;
            }
        }

    }

    //are p and q in the same component?
    public boolean connected(int p, int q){
        return ids[p]==ids[q];
    }
}