package in.algorithms.interviewprep.majorityelement;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void testProblemStatementExampleOne() {
        Assert.assertEquals(3, MajorityElement.majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    public void testProblemStatementExampleTwo() {
        Assert.assertEquals(2, MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    public void testSingleElementArray() {
        Assert.assertEquals(7, MajorityElement.majorityElement(new int[]{7}));
    }

    @Test
    public void testAllElementsIdentical() {
        Assert.assertEquals(5, MajorityElement.majorityElement(new int[]{5, 5, 5, 5}));
    }

    @Test
    public void testTwoElementArrayWithMajority() {
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{1, 1}));
    }

    @Test
    public void testMajorityElementAtTheStartOfTheArray() {
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{1, 1, 1, 2, 3}));
    }

    @Test
    public void testMajorityElementAtTheEndOfTheArray() {
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{2, 3, 1, 1, 1}));
    }

    @Test
    public void testMajorityElementScatteredThroughoutTheArray() {
        // 1 appears 4 times out of 7, more than floor(7/2)=3.
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{1, 2, 1, 3, 1, 4, 1}));
    }

    @Test
    public void testExactlyOneMoreThanHalfBoundary() {
        // length 5, floor(5/2)=2; the majority element must appear at least 3 times.
        Assert.assertEquals(2, MajorityElement.majorityElement(new int[]{1, 1, 2, 2, 2}));
    }

    @Test
    public void testMinorityElementsDoNotOverrideTheTrueMajority() {
        // length 3, floor(3/2)=1; 5 appears twice, which is enough to be the majority.
        Assert.assertEquals(5, MajorityElement.majorityElement(new int[]{6, 5, 5}));
    }

    @Test
    public void testAlternatingPatternWithTrueMajority() {
        // 1 appears 4 times out of 7 despite strictly alternating with 2.
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{1, 2, 1, 2, 1, 2, 1}));
    }

    @Test
    public void testAlternatingPatternMajorityNotAtStart() {
        // Same alternation, but the array starts with the minority element.
        Assert.assertEquals(1, MajorityElement.majorityElement(new int[]{2, 1, 2, 1, 1, 2, 1}));
    }

    @Test
    public void testNegativeNumbersMajority() {
        Assert.assertEquals(-1, MajorityElement.majorityElement(new int[]{-1, -1, -1, 2, 2}));
    }

    @Test
    public void testMixedPositiveNegativeAndZero() {
        Assert.assertEquals(0, MajorityElement.majorityElement(new int[]{0, 0, 0, 1, -1}));
    }

    @Test
    public void testBoundaryValueElements() {
        Assert.assertEquals(1000000000, MajorityElement.majorityElement(new int[]{1000000000, 1000000000, 1000000000, -1000000000}));
        Assert.assertEquals(-1000000000, MajorityElement.majorityElement(new int[]{-1000000000, -1000000000, 5}));
    }

    @Test
    public void testLargeArrayWithClearMajority() {
        int n = 50000;
        int[] nums = new int[n];
        // Majority value fills just over half the array; the rest are distinct filler values.
        int majorityCount = n / 2 + 1;
        for (int i = 0; i < majorityCount; i++) {
            nums[i] = 42;
        }
        for (int i = majorityCount; i < n; i++) {
            nums[i] = i; // all distinct, none repeats enough to compete
        }

        Assert.assertEquals(42, MajorityElement.majorityElement(nums));
    }
}
