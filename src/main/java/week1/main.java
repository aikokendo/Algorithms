package week1;

import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args){
        Random rand = new Random();
        int n = rand.nextInt(10)+1;
        Percolation per = new Percolation(n);
        StringBuilder bld = new StringBuilder();

        bld.append("Size of grid: " + n + "\n Attempted unions: \n");
        while (!per.percolates()) {
            int row = rand.nextInt(n)+1;
            int col = rand.nextInt(n)+1;
            per.open(row,col);
            bld.append("[" + row + "," + col + "]");
            if (!per.percolates()){
                bld.append(",");
            }
        }
        bld.append("\nFinally percolated!");
        bld.append("\nOpen sites: " + per.numberOfOpenSites() + "/" + n*n + "\n");
        System.out.println(bld.toString());
        per.print();

    }
}
