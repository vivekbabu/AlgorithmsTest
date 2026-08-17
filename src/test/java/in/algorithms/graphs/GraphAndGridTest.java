package in.algorithms.graphs;

import in.algorithms.arrayisland.CountIslands;
import in.algorithms.bfs.BFS;
import in.algorithms.dfs.DFS;
import in.algorithms.graphfind.QuickFind;
import in.algorithms.nqeens.NQueens;
import in.algorithms.ratandmace.RatMace;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class GraphAndGridTest {

    @Test
    public void testCountIslands() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Assert.assertEquals(5, CountIslands.countIslands(grid));
    }

    @Test
    public void testBFSAndDFS() {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0, 3));
        adj.put(3, Arrays.asList(3));

        List<Integer> bfsOrder = BFS.traverse(adj, 2);
        Assert.assertEquals(Arrays.asList(2, 0, 3, 1), bfsOrder);

        List<Integer> dfsOrder = DFS.traverse(adj, 2);
        Assert.assertEquals(Arrays.asList(2, 0, 1, 3), dfsOrder);
    }

    @Test
    public void testQuickFind() {
        QuickFind qf = new QuickFind(10);
        Assert.assertEquals(10, qf.count());
        Assert.assertFalse(qf.connected(4, 3));

        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);

        Assert.assertTrue(qf.connected(4, 8));
        Assert.assertFalse(qf.connected(8, 6));
        Assert.assertEquals(7, qf.count());
    }

    @Test
    public void testNQueens() {
        List<List<Integer>> solutions4 = NQueens.queens(4);
        Assert.assertEquals(2, solutions4.size());

        List<List<Integer>> solutions8 = NQueens.queens(8);
        Assert.assertEquals(92, solutions8.size());
    }

    @Test
    public void testRatInMaze() {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] sol = new int[4][4];
        boolean solved = RatMace.solveMaze(maze, sol, 0, 0, 4);
        Assert.assertTrue(solved);
        Assert.assertEquals(1, sol[3][3]);
    }
}
