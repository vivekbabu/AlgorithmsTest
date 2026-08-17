package in.algorithms.arrayisland;

public class CountIslands {
    private static final int ROW = 5;
    private static final int COL = 5;
    public static int count = 0;

    private static final int[][] OFFSETS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public static boolean isSafe(int[][] grid, int r, int c, boolean[][] visited) {
        return (r >= 0) && (r < ROW) && (c >= 0) && (c < COL) && (grid[r][c] == 1 && !visited[r][c]);
    }

    public static void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] offset : OFFSETS) {
            int nr = r + offset[0];
            int nc = c + offset[1];
            if (isSafe(grid, nr, nc, visited)) {
                dfs(grid, nr, nc, visited);
            }
        }
    }

    public static int countIslands(int[][] grid) {
        boolean[][] visited = new boolean[ROW][COL];
        count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands: " + countIslands(grid));
    }
}
