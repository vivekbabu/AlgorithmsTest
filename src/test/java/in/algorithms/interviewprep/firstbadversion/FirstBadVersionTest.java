package in.algorithms.interviewprep.firstbadversion;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersionTest {

    /**
     * A {@link FirstBadVersion.VersionControl} where every version {@code >= bad} is bad. Counts
     * how many times the API is queried and rejects out-of-range probes, so the tests can also
     * verify the algorithm stays within {@code [1, n]} and makes few calls.
     */
    private static final class CountingOracle implements FirstBadVersion.VersionControl {
        private final int bad;
        private final int n;
        int calls = 0;

        CountingOracle(int bad, int n) {
            this.bad = bad;
            this.n = n;
        }

        @Override
        public boolean isBadVersion(int version) {
            calls++;
            Assert.assertTrue("API queried with version " + version + " outside [1, " + n + "]",
                    version >= 1 && version <= n);
            return version >= bad;
        }
    }

    private static void assertFirstBad(int bad, int n) {
        CountingOracle oracle = new CountingOracle(bad, n);

        int result = FirstBadVersion.firstBadVersion(n, oracle);

        Assert.assertEquals("first bad version for bad=" + bad + ", n=" + n, bad, result);

        // Binary search over [1, n] must not need more than ~2*ceil(log2(n)) + a small constant.
        int budget = 2 * (Integer.SIZE - Integer.numberOfLeadingZeros(Math.max(1, n))) + 4;
        Assert.assertTrue(
                "expected O(log n) API calls but made " + oracle.calls + " for n=" + n
                        + " (budget " + budget + ")",
                oracle.calls <= budget);
    }

    // ---------------------------------------------------------------------
    // Problem-statement example
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExample() {
        // n = 5, bad = 4:
        //   isBadVersion(3) -> false
        //   isBadVersion(5) -> true
        //   isBadVersion(4) -> true
        //   => first bad = 4
        assertFirstBad(4, 5);
    }

    // ---------------------------------------------------------------------
    // Smallest inputs (constraint: 1 <= bad <= n)
    // ---------------------------------------------------------------------

    @Test
    public void testSingleVersionWhichIsBad() {
        assertFirstBad(1, 1);
    }

    @Test
    public void testTwoVersionsFirstIsBad() {
        assertFirstBad(1, 2);
    }

    @Test
    public void testTwoVersionsSecondIsBad() {
        assertFirstBad(2, 2);
    }

    // ---------------------------------------------------------------------
    // Bad version at the boundaries of the range
    // ---------------------------------------------------------------------

    @Test
    public void testFirstVersionIsBad() {
        assertFirstBad(1, 100);
        assertFirstBad(1, 12345);
    }

    @Test
    public void testLastVersionIsBad() {
        assertFirstBad(100, 100);
        assertFirstBad(9999, 9999);
    }

    @Test
    public void testSecondVersionIsBad() {
        assertFirstBad(2, 100);
    }

    @Test
    public void testSecondToLastVersionIsBad() {
        assertFirstBad(99, 100);
    }

    // ---------------------------------------------------------------------
    // Bad version somewhere in the middle
    // ---------------------------------------------------------------------

    @Test
    public void testMiddleVersionIsBad() {
        assertFirstBad(50, 100);
        assertFirstBad(500, 1000);
    }

    @Test
    public void testEveryPossibleBadVersionInASmallRange() {
        int n = 200;
        for (int bad = 1; bad <= n; bad++) {
            assertFirstBad(bad, n);
        }
    }

    @Test
    public void testEveryPossibleBadVersionAcrossSeveralOddAndEvenRanges() {
        for (int n : new int[]{1, 2, 3, 7, 8, 15, 16, 17, 63, 64, 65}) {
            for (int bad = 1; bad <= n; bad++) {
                assertFirstBad(bad, n);
            }
        }
    }

    // ---------------------------------------------------------------------
    // Powers of two and their neighbours for n (index-arithmetic edge cases)
    // ---------------------------------------------------------------------

    @Test
    public void testRangesAroundPowersOfTwo() {
        int[] ns = {1023, 1024, 1025, 65535, 65536, 65537};
        for (int n : ns) {
            assertFirstBad(1, n);
            assertFirstBad(n, n);
            assertFirstBad(n / 2, n);
            assertFirstBad(n / 2 + 1, n);
        }
    }

    // ---------------------------------------------------------------------
    // Large n up to the constraint bound (2^31 - 1) — overflow safety
    // ---------------------------------------------------------------------

    @Test
    public void testMaxNFirstVersionBad() {
        assertFirstBad(1, Integer.MAX_VALUE);
    }

    @Test
    public void testMaxNLastVersionBad() {
        assertFirstBad(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void testMaxNMiddleVersionBad() {
        assertFirstBad(1_073_741_824, Integer.MAX_VALUE); // 2^30
    }

    @Test
    public void testMaxNBadVersionJustBelowTheTop() {
        assertFirstBad(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    }

    @Test
    public void testLargeNWithAssortedBadVersions() {
        int n = 2_000_000_000;
        int[] bads = {1, 2, 3, 7, 1000, 999_999, 1_000_000_000, n - 2, n - 1, n};
        for (int bad : bads) {
            assertFirstBad(bad, n);
        }
    }

    @Test
    public void testMidpointComputationDoesNotOverflow() {
        // If the implementation computes (low + high) / 2 with int arithmetic it overflows here
        // and would query a negative version, which the oracle rejects.
        int n = Integer.MAX_VALUE;
        assertFirstBad(Integer.MAX_VALUE - 5, n);
        assertFirstBad(2_147_000_000, n);
        assertFirstBad(1_500_000_000, n);
    }

    // ---------------------------------------------------------------------
    // Call-count sanity: it really is logarithmic, not linear
    // ---------------------------------------------------------------------

    @Test
    public void testCallCountIsLogarithmicForLargeN() {
        int n = Integer.MAX_VALUE;
        CountingOracle oracle = new CountingOracle(1_234_567_890, n);

        int result = FirstBadVersion.firstBadVersion(n, oracle);

        Assert.assertEquals(1_234_567_890, result);
        Assert.assertTrue(
                "a logarithmic search over 2^31 versions should need well under 100 calls, made "
                        + oracle.calls,
                oracle.calls < 100);
    }
}
