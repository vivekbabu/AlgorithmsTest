package in.algorithms.interviewprep.pascalstriangle;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleTest {

    @Test
    public void testProblemStatementExampleOne() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        );
        Assert.assertEquals(expected, PascalsTriangle.generate(5));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        Assert.assertEquals(expected, PascalsTriangle.generate(1));
    }

    @Test
    public void testNumRowsTwo() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1)
        );
        Assert.assertEquals(expected, PascalsTriangle.generate(2));
    }

    @Test
    public void testNumRowsThree() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1)
        );
        Assert.assertEquals(expected, PascalsTriangle.generate(3));
    }

    @Test
    public void testNumRowsSevenMatchesKnownValues() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1),
                Arrays.asList(1, 5, 10, 10, 5, 1),
                Arrays.asList(1, 6, 15, 20, 15, 6, 1)
        );
        Assert.assertEquals(expected, PascalsTriangle.generate(7));
    }

    @Test
    public void testResultHasExactlyNumRowsRows() {
        for (int numRows = 1; numRows <= 10; numRows++) {
            Assert.assertEquals("numRows=" + numRows, numRows, PascalsTriangle.generate(numRows).size());
        }
    }

    @Test
    public void testRowLengthMatchesRowIndexPlusOne() {
        List<List<Integer>> triangle = PascalsTriangle.generate(10);
        for (int i = 0; i < triangle.size(); i++) {
            Assert.assertEquals("row " + i, i + 1, triangle.get(i).size());
        }
    }

    @Test
    public void testEveryRowStartsAndEndsWithOne() {
        List<List<Integer>> triangle = PascalsTriangle.generate(15);
        for (List<Integer> row : triangle) {
            Assert.assertEquals(Integer.valueOf(1), row.get(0));
            Assert.assertEquals(Integer.valueOf(1), row.get(row.size() - 1));
        }
    }

    @Test
    public void testEveryRowIsASymmetricPalindrome() {
        List<List<Integer>> triangle = PascalsTriangle.generate(12);
        for (List<Integer> row : triangle) {
            List<Integer> reversed = new java.util.ArrayList<>(row);
            java.util.Collections.reverse(reversed);
            Assert.assertEquals(row, reversed);
        }
    }

    @Test
    public void testEachInteriorElementIsSumOfTheTwoAboveIt() {
        List<List<Integer>> triangle = PascalsTriangle.generate(10);
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> prevRow = triangle.get(i - 1);
            for (int j = 1; j < row.size() - 1; j++) {
                int expected = prevRow.get(j - 1) + prevRow.get(j);
                Assert.assertEquals("row " + i + ", col " + j, expected, row.get(j).intValue());
            }
        }
    }

    @Test
    public void testEachRowSumsToPowerOfTwo() {
        List<List<Integer>> triangle = PascalsTriangle.generate(10);
        for (int i = 0; i < triangle.size(); i++) {
            int sum = 0;
            for (int value : triangle.get(i)) {
                sum += value;
            }
            Assert.assertEquals("row " + i, 1 << i, sum);
        }
    }

    @Test
    public void testSecondElementOfEachRowEqualsRowIndex() {
        // Row i (0-indexed, i >= 1) has second element == i, e.g. row 4 = [1,4,6,4,1].
        List<List<Integer>> triangle = PascalsTriangle.generate(9);
        for (int i = 1; i < triangle.size(); i++) {
            Assert.assertEquals("row " + i, i, triangle.get(i).get(1).intValue());
        }
    }

    @Test
    public void testMaxConstraintBoundaryNumRows30() {
        List<List<Integer>> triangle = PascalsTriangle.generate(30);
        Assert.assertEquals(30, triangle.size());

        List<Integer> lastRow = triangle.get(29);
        Assert.assertEquals(30, lastRow.size());
        Assert.assertEquals(Integer.valueOf(1), lastRow.get(0));
        Assert.assertEquals(Integer.valueOf(1), lastRow.get(lastRow.size() - 1));
        Assert.assertEquals(Integer.valueOf(29), lastRow.get(1)); // C(29,1) = 29
        Assert.assertEquals(Integer.valueOf(20030010), lastRow.get(10)); // C(29,10)
    }
}
