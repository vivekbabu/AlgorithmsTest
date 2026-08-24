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

    @Test
    public void testRatInMazeWithNoSolution() {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        int[][] sol = new int[4][4];
        boolean solved = RatMace.solveMaze(maze, sol, 0, 0, 4);
        Assert.assertFalse(solved);
    }

    @Test
    public void testCountIslandsEdgeCases() {
        Assert.assertEquals(0, CountIslands.countIslands(null));
        Assert.assertEquals(0, CountIslands.countIslands(new int[0][0]));
        Assert.assertEquals(0, CountIslands.countIslands(new int[][]{{0, 0}, {0, 0}}));

        // Diagonal connectivity means the whole grid is a single island.
        int[][] allLand = {{1, 1}, {1, 1}};
        Assert.assertEquals(1, CountIslands.countIslands(allLand));

        // Diagonally adjacent 1s still count as one island (8-directional DFS).
        int[][] diagonal = {{1, 0}, {0, 1}};
        Assert.assertEquals(1, CountIslands.countIslands(diagonal));
    }

    @Test
    public void testBFSAndDFSEdgeCases() {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, Arrays.asList(1));
        adj.put(1, Collections.emptyList());
        adj.put(2, Arrays.asList(0)); // disconnected from {0,1} for traversal starting at 0

        Assert.assertEquals(Arrays.asList(0, 1), BFS.traverse(adj, 0));
        Assert.assertEquals(Arrays.asList(0, 1), DFS.traverse(adj, 0));

        Assert.assertTrue(BFS.traverse(adj, 99).isEmpty()); // start node not in graph
        Assert.assertTrue(DFS.traverse(null, 0).isEmpty());
        Assert.assertTrue(BFS.traverse(null, 0).isEmpty());
    }

    @Test
    public void testQuickFindUnionOfAlreadyConnectedNodesIsNoOp() {
        QuickFind qf = new QuickFind(5);
        qf.union(1, 2);
        int countAfterFirstUnion = qf.count();

        qf.union(1, 2); // already connected
        Assert.assertEquals(countAfterFirstUnion, qf.count());
        Assert.assertEquals(qf.find(1), qf.find(2));
    }

    @Test
    public void testNQueensBaseCases() {
        Assert.assertEquals(1, NQueens.queens(1).size());
        Assert.assertEquals(0, NQueens.queens(2).size()); // no solution for n=2
        Assert.assertEquals(0, NQueens.queens(3).size()); // no solution for n=3
        Assert.assertEquals(Arrays.asList(0), NQueens.queens(1).get(0));
    }
}
