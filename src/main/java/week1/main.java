package week1;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        UF uf = new UF(N);
        while(in.hasNext()){
            int p = in.nextInt();
            int q = in.nextInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }
    }
}
