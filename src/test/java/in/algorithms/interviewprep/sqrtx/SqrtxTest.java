package in.algorithms.interviewprep.sqrtx;

import org.junit.Assert;
import org.junit.Test;

public class SqrtxTest {

    private static void assertSqrt(int x, int expected) {
        int actual = Sqrtx.mySqrt(x);
        Assert.assertEquals("mySqrt(" + x + ")", expected, actual);
    }

    /**
     * Independent reference: the correct answer r is the unique non-negative integer with
     * r*r <= x < (r+1)*(r+1). Uses long arithmetic to stay exact for all int inputs.
     */
    private static int reference(int x) {
        long r = 0;
        while ((r + 1) * (r + 1) <= x) {
            r++;
        }
        return (int) r;
    }

    /** Asserts the returned r satisfies r*r <= x < (r+1)*(r+1). */
    private static void assertIsFloorSqrt(int x) {
        long r = Sqrtx.mySqrt(x);
        Assert.assertTrue("result must be non-negative for x=" + x, r >= 0);
        Assert.assertTrue("r*r must be <= x for x=" + x + " (r=" + r + ")", r * r <= x);
        Assert.assertTrue("(r+1)*(r+1) must be > x for x=" + x + " (r=" + r + ")",
                (r + 1) * (r + 1) > x);
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // x = 4 -> 2
        assertSqrt(4, 2);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // x = 8 -> 2 (sqrt(8) = 2.828..., rounded down is 2)
        assertSqrt(8, 2);
    }

    // ---------------------------------------------------------------------
    // Smallest inputs (constraint: x >= 0)
    // ---------------------------------------------------------------------

    @Test
    public void testZero() {
        assertSqrt(0, 0);
    }

    @Test
    public void testOne() {
        assertSqrt(1, 1);
    }

    @Test
    public void testTwo() {
        assertSqrt(2, 1);
    }

    @Test
    public void testThree() {
        assertSqrt(3, 1);
    }

    // ---------------------------------------------------------------------
    // Perfect squares return the exact root
    // ---------------------------------------------------------------------

    @Test
    public void testSmallPerfectSquares() {
        assertSqrt(9, 3);
        assertSqrt(16, 4);
        assertSqrt(25, 5);
        assertSqrt(36, 6);
        assertSqrt(49, 7);
        assertSqrt(100, 10);
    }

    @Test
    public void testEveryPerfectSquareUpTo1000Squared() {
        for (int r = 0; r <= 1000; r++) {
            assertSqrt(r * r, r);
        }
    }

    @Test
    public void testLargePerfectSquare() {
        // 46340^2 = 2,147,395,600 which is <= Integer.MAX_VALUE (2,147,483,647)
        assertSqrt(46340 * 46340, 46340);
    }

    // ---------------------------------------------------------------------
    // Values just below / just above / just at a perfect square
    // ---------------------------------------------------------------------

    @Test
    public void testOneLessThanAPerfectSquareRoundsDown() {
        assertSqrt(8, 2);    // 9 - 1
        assertSqrt(15, 3);   // 16 - 1
        assertSqrt(24, 4);   // 25 - 1
        assertSqrt(99, 9);   // 100 - 1
        assertSqrt(9999, 99);
    }

    @Test
    public void testOneMoreThanAPerfectSquareRoundsDown() {
        assertSqrt(10, 3);   // 9 + 1
        assertSqrt(17, 4);   // 16 + 1
        assertSqrt(26, 5);   // 25 + 1
        assertSqrt(101, 10); // 100 + 1
    }

    @Test
    public void testBoundariesAroundManyPerfectSquares() {
        for (int r = 1; r <= 2000; r++) {
            int square = r * r;
            assertSqrt(square, r);         // exactly the square
            assertSqrt(square - 1, r - 1); // just below -> previous root
            assertSqrt(square + 1, r);     // just above -> same root (if in range)
        }
    }

    // ---------------------------------------------------------------------
    // Constraint boundary: x up to Integer.MAX_VALUE
    // ---------------------------------------------------------------------

    @Test
    public void testIntegerMaxValue() {
        // floor(sqrt(2^31 - 1)) = 46340  (46340^2 = 2,147,395,600; 46341^2 overflows int and
        // as a long is 2,147,488,281 > 2,147,483,647)
        assertSqrt(Integer.MAX_VALUE, 46340);
    }

    @Test
    public void testJustBelowIntegerMaxValue() {
        assertSqrt(Integer.MAX_VALUE - 1, 46340);
    }

    @Test
    public void testLargestInputWhoseRootIs46339() {
        int upper = 46340 * 46340 - 1; // 2,147,395,599 -> root 46339
        assertSqrt(upper, 46339);
        assertSqrt(46339 * 46339, 46339);
    }

    @Test
    public void testNoIntermediateOverflowNearTheTop() {
        // A naive r*r check with int arithmetic overflows around here; the answer must still be 46340.
        assertIsFloorSqrt(Integer.MAX_VALUE);
        assertIsFloorSqrt(Integer.MAX_VALUE - 1);
        assertIsFloorSqrt(2_000_000_000);
        assertIsFloorSqrt(1_500_000_000);
    }

    // ---------------------------------------------------------------------
    // Assorted non-square values checked against the reference
    // ---------------------------------------------------------------------

    @Test
    public void testAssortedValuesAgainstReference() {
        int[] xs = {5, 6, 7, 10, 11, 12, 26, 50, 80, 143, 144, 145,
                999, 1000, 12345, 65535, 65536, 1_000_000, 1_000_003,
                123_456_789, 999_999_999, 2_147_000_000};
        for (int x : xs) {
            assertSqrt(x, reference(x));
        }
    }

    @Test
    public void testDenseSweepOfSmallValues() {
        for (int x = 0; x <= 10_000; x++) {
            assertSqrt(x, reference(x));
        }
    }

    @Test
    public void testSpacedSweepAcrossTheWholeRange() {
        // Step through the entire int range; step is coprime-ish with squares so it lands on a
        // wide mix of squares, square-minus-one, and generic values.
        long step = 7_654_321L;
        for (long x = 0; x <= Integer.MAX_VALUE; x += step) {
            assertSqrt((int) x, reference((int) x));
        }
        assertSqrt(Integer.MAX_VALUE, reference(Integer.MAX_VALUE));
    }

    // ---------------------------------------------------------------------
    // Structural property: monotonic non-decreasing in x
    // ---------------------------------------------------------------------

    @Test
    public void testResultIsMonotonicNonDecreasing() {
        int previous = 0;
        for (int x = 0; x <= 5_000_000; x += 137) {
            int current = Sqrtx.mySqrt(x);
            Assert.assertTrue("mySqrt must be non-decreasing; dropped at x=" + x,
                    current >= previous);
            previous = current;
        }
    }
}
