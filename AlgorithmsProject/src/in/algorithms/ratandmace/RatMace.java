package in.algorithms.ratandmace;

public class RatMace {
    public static boolean solveMaze(int[][] maze, int[][] sol, int x, int y, int n) {
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y, n)) {
            sol[x][y] = 1;
            if (solveMaze(maze, sol, x + 1, y, n)) return true;
            if (solveMaze(maze, sol, x, y + 1, n)) return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
    }
}
