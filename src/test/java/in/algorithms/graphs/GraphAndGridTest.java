package in.algorithms.graphs;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.nqeens.NQueens;
import in.algorithms.ratandmace.RatMace;

public class GraphAndGridTest {

    @Test
    public void testCountIslands() {
        in.algorithms.arrayisland.CountIslands$.MODULE$.calculateTheIslands();
        Assert.assertEquals(5, in.algorithms.arrayisland.CountIslands$.MODULE$.count());
    }

    @Test
    public void testNQueensSolver() {
        // N=4 should have 2 distinct solutions
        scala.collection.immutable.Set<scala.collection.immutable.List<Object>> solutions4 = NQueens.queens(4);
        Assert.assertEquals(2, solutions4.size());

        // N=8 should have 92 distinct solutions
        scala.collection.immutable.Set<scala.collection.immutable.List<Object>> solutions8 = NQueens.queens(8);
        Assert.assertEquals(92, solutions8.size());
    }

    @Test
    public void testRatInAMazeSolver() {
        RatMace.main(new String[]{});
    }
}
