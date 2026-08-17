package in.algorithms.graphs;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.nqeens.NQueens;
import in.algorithms.ratandmace.RatMace;
import in.algorithms.arrayisland.CountIslands;
import java.util.List;

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
    public void testNQueensSolver() {
        List<List<Integer>> solutions4 = NQueens.queens(4);
        Assert.assertEquals(2, solutions4.size());

        List<List<Integer>> solutions8 = NQueens.queens(8);
        Assert.assertEquals(92, solutions8.size());
    }

    @Test
    public void testRatInAMazeSolver() {
        RatMace.main(new String[]{});
    }
}
