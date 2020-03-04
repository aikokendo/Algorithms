package week1;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
public class Percolation {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[40m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[47m";

    private boolean[][] grid;  // 0 closed, 1 open
    private final UFlazyImprovedCompression uf;
    private final UFlazyImprovedCompression ufBackWater;
    private final int size;
    private int openSites = 0;
    private final int vt;
    private final int vb;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("size should be bigger than 0.");

        // initialize grid
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        // initialize UF
        int totalNodes = (n*n)+2; // the grid nodes + top and bottom
        vt = 0;  // virtual top
        vb = (n*n)+1; // virtual bottom

        uf = new UFlazyImprovedCompression(totalNodes);
        ufBackWater = new UFlazyImprovedCompression(totalNodes - 1);
        // connect virtual top with top row
        // connect virtual bottom with bottom row
        // connect virtual top with top row - backwater
        for (int i = 1; i <= n; i++) {
            uf.union(vt, i);
            uf.union(vb, vb-i);
            ufBackWater.union(vt, i);
        }
        size = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Row and Column should be within the range of [1," + size + "]");
        }
        int current = (row-1)*size + col;
        int up = (row-2)*size + col;
        int down = (row)*size + col;
        int left = (row-1)*size + col - 1;
        int right = (row-1)*size + col + 1;
        if (!isOpen(row, col)) {
            grid[row-1][col-1] = true;
            openSites++;
            if (row - 1 > 0 && isOpen(row-1, col)) {
                uf.union(current, up);
                ufBackWater.union(current, up);
            }
            if (row + 1 <= size && isOpen(row+1, col)) {
                uf.union(current, down);
                ufBackWater.union(current, down);
            }
            if (col -1 > 0 && isOpen(row, col-1)) {
                uf.union(current, left);
                ufBackWater.union(current, left);
            }
            if (col + 1 <= size && isOpen(row, col+1)) {
                uf.union(current, right);
                ufBackWater.union(current, right);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Row and Column should be within the range of [1," + size + "]");
        }
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int current = (row-1)*size + col;
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Row and Column should be within the range of [1," + size + "]");
        }
        return isOpen(row, col) && ufBackWater.connected(vt, current);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        if (size == 1) { // corner case
            return isOpen(1, 1);
        }
        return uf.connected(vt, vb);
    }

    //print "prettily"
    public void print(){
        StringBuilder bld = new StringBuilder();
        if (size > 10) {
            System.out.println(" Grid too big to comfortably print");
        }
        for (int i = 1; i <= size; i++){
            for (int j = 1; j <= size; j++) {
                if (isFull(i,j)) {
                    bld.append(ANSI_BLUE_BACKGROUND + "   " + ANSI_RESET);
                }
                else if (isOpen(i,j)){
                    bld.append(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
                }
                else {
                    bld.append(ANSI_BLACK_BACKGROUND + "   " + ANSI_RESET);
                }
            }
            bld.append("\n");
        }
        System.out.println(bld.toString());
    }


}
