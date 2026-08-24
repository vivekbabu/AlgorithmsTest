package in.algorithms.math;

import in.algorithms.alternate.AlternateNumbers;
import in.algorithms.combination.AllCombination;
import in.algorithms.combination.CWithSumZero;
import in.algorithms.combination.CombinationsWithAnyFunction;
import in.algorithms.combination.TripletsWithSumZero;
import in.algorithms.maximumdifference.MaximumDifference;
import in.algorithms.nextbiggernumber.NextBiggerNumber;
import in.algorithms.pairwithsumx.PairWithSumX;
import in.algorithms.rationals.Rationals;
import in.algorithms.replacewithsumuptothatpoint.SumUptoThePoint;
import in.algorithms.roomalotter.RoomAlotter;
import in.algorithms.rotatedarray.RotatedArray;
import in.algorithms.secondfrequentnumberinalist.SecondFrequentNumberInAList;
import in.algorithms.sqaureroot.SquareRoot;
import in.algorithms.wateralotter.WaterAlotter;
import in.algorithms.wordcount.WordCount;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MathAndArrayTest {

    @Test
    public void testNextBiggerNumber() {
        Assert.assertEquals(Long.valueOf(1243), NextBiggerNumber.getNextBiggerNumber(1234L));
        Assert.assertEquals(Long.valueOf(536479), NextBiggerNumber.getNextBiggerNumber(534976L));
        Assert.assertNull(NextBiggerNumber.getNextBiggerNumber(4321L)); // Descending, no higher
    }

    @Test
    public void testAlternateNumbers() {
        AlternateNumbers alternater = new AlternateNumbers();
        Integer[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        alternater.alternateTheNumbers(arr);
        Assert.assertArrayEquals(new Integer[]{2, -2, 4, -5, 7, -8, 1, 8, 0, 5}, arr);
    }

    @Test
    public void testAlternateNumbersEdgeCases() {
        AlternateNumbers alternater = new AlternateNumbers();

        alternater.alternateTheNumbers(null); // no exception

        Integer[] single = {5};
        alternater.alternateTheNumbers(single);
        Assert.assertArrayEquals(new Integer[]{5}, single); // length <= 1 is a no-op

        Integer[] moreNegatives = {-1, -2, -3, 4, 5};
        alternater.alternateTheNumbers(moreNegatives);
        Assert.assertArrayEquals(new Integer[]{4, -2, 5, -1, -3}, moreNegatives);
    }

    @Test
    public void testCombinations() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<List<Integer>> powerSet = AllCombination.generateCombinations(input);
        Assert.assertEquals(8, powerSet.size()); // 2^3 = 8

        List<Integer> sums = CombinationsWithAnyFunction.combine(input, combo -> combo.stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(8, sums.size());
    }

    @Test
    public void testPairsAndTripletsWithSumZero() {
        List<Integer> list = Arrays.asList(-1, 0, 1, 2, -1, -4);
        List<List<Integer>> pairs = CWithSumZero.findPairsWithSumZero(list);
        Assert.assertFalse(pairs.isEmpty());

        List<List<Integer>> triplets = TripletsWithSumZero.findTripletsWithSumZero(list);
        Assert.assertFalse(triplets.isEmpty());
    }

    @Test
    public void testPairWithSumX() {
        int[] arr = {1, 4, 45, 6, 10, 8};
        List<List<Integer>> pairs = PairWithSumX.findPairs(arr, 16);
        Assert.assertEquals(1, pairs.size());
        Assert.assertEquals(Arrays.asList(6, 10), pairs.get(0));
    }

    @Test
    public void testMaximumDifference() {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        Assert.assertEquals(8, MaximumDifference.maxDiff(arr)); // 10 - 2 = 8
    }

    @Test
    public void testPrefixSum() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefix = SumUptoThePoint.prefixSum(arr);
        Assert.assertArrayEquals(new int[]{1, 3, 6, 10, 15}, prefix);
    }

    @Test
    public void testRotatedArraySearch() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(4, RotatedArray.search(arr, 0));
        Assert.assertEquals(0, RotatedArray.search(arr, 4));
        Assert.assertEquals(-1, RotatedArray.search(arr, 99));
    }

    @Test
    public void testSecondFrequentNumber() {
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 1, 1, 1, 2, 3, 3, 2, 1, 3, 3, 3, 2, 2, 1, 2, 1, 1, 1);
        Map.Entry<Integer, Integer> entry = SecondFrequentNumberInAList.secondFrequent(nums);
        Assert.assertNotNull(entry);
        Assert.assertEquals(Integer.valueOf(2), entry.getKey());
    }

    @Test
    public void testSquareRoot() {
        Assert.assertEquals(3.0, SquareRoot.sqrt(9.0), 0.001);
        Assert.assertEquals(5.0, SquareRoot.sqrt(25.0), 0.001);
        Assert.assertEquals(0.0, SquareRoot.sqrt(0.0), 0.001);
    }

    @Test
    public void testWaterAllotter() {
        WaterAlotter allotter = new WaterAlotter();
        Map<Integer, Double> glasses = allotter.allotWater(10, 3, 1.0);
        Assert.assertNotNull(glasses);
        Assert.assertEquals(1.0, glasses.get(1), 0.001);
    }

    @Test
    public void testRoomAllotter() {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        Assert.assertEquals(3, RoomAlotter.minMeetingRooms(start, end));
    }

    @Test
    public void testWordCount() {
        String txt = "Hello world hello test world hello";
        Map<String, Integer> counts = WordCount.countWords(txt);
        Assert.assertEquals(Integer.valueOf(3), counts.get("hello"));
        Assert.assertEquals(Integer.valueOf(2), counts.get("world"));
        Assert.assertEquals(Integer.valueOf(1), counts.get("test"));
    }

    @Test
    public void testRationals() {
        Rationals r1 = new Rationals(1, 2);
        Rationals r2 = new Rationals(1, 3);

        Assert.assertEquals(new Rationals(5, 6), r1.add(r2));
        Assert.assertEquals(new Rationals(1, 6), r1.sub(r2));
        Assert.assertEquals(new Rationals(1, 6), r1.mul(r2));
        Assert.assertEquals(new Rationals(3, 2), r1.div(r2));
    }

    @Test
    public void testRationalsNormalizesSignAndReduces() {
        Assert.assertEquals("-1/2", new Rationals(1, -2).toString());
        Assert.assertEquals("1/2", new Rationals(-1, -2).toString());
        Assert.assertEquals("2/3", new Rationals(4, 6).toString()); // reduced via gcd
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRationalsZeroDenominatorThrows() {
        new Rationals(1, 0);
    }

    @Test
    public void testRationalsEqualsAndHashCode() {
        Rationals a = new Rationals(1, 2);
        Rationals b = new Rationals(2, 4); // reduces to the same value
        Assert.assertEquals(a, b);
        Assert.assertEquals(a.hashCode(), b.hashCode());
        Assert.assertNotEquals(a, new Rationals(1, 3));
        Assert.assertNotEquals(a, "1/2");
    }

    @Test
    public void testNextBiggerNumberEdgeCases() {
        Assert.assertNull(NextBiggerNumber.getNextBiggerNumber(null));
        Assert.assertNull(NextBiggerNumber.getNextBiggerNumber(9L)); // single digit, no higher permutation
        Assert.assertNull(NextBiggerNumber.getNextBiggerNumber(111L)); // all identical digits
        Assert.assertEquals(Long.valueOf(21), NextBiggerNumber.getNextBiggerNumber(12L));
    }

    @Test
    public void testCombinationsEdgeCases() {
        Assert.assertTrue(AllCombination.generateCombinations(null).isEmpty());

        List<List<Integer>> emptyInputCombos = AllCombination.generateCombinations(Collections.emptyList());
        Assert.assertEquals(1, emptyInputCombos.size()); // just the empty combination
        Assert.assertTrue(emptyInputCombos.get(0).isEmpty());
    }

    @Test
    public void testPairsAndTripletsWithSumZeroEdgeCases() {
        Assert.assertTrue(CWithSumZero.findPairsWithSumZero(null).isEmpty());
        Assert.assertTrue(CWithSumZero.findPairsWithSumZero(Arrays.asList(1, 2, 3)).isEmpty());

        Assert.assertTrue(TripletsWithSumZero.findTripletsWithSumZero(null).isEmpty());
        Assert.assertTrue(TripletsWithSumZero.findTripletsWithSumZero(Arrays.asList(1, 2)).isEmpty()); // < 3 elements

        List<List<Integer>> triplets = TripletsWithSumZero.findTripletsWithSumZero(Arrays.asList(-1, 0, 1, 2, -1, -4));
        Assert.assertEquals(2, triplets.size());
        Assert.assertTrue(triplets.contains(Arrays.asList(-1, -1, 2)));
        Assert.assertTrue(triplets.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void testPairWithSumXNoMatchesAndNullArray() {
        Assert.assertTrue(PairWithSumX.findPairs(null, 10).isEmpty());
        Assert.assertTrue(PairWithSumX.findPairs(new int[]{1, 2, 3}, 100).isEmpty());
    }

    @Test
    public void testPrefixSumEdgeCases() {
        Assert.assertNull(SumUptoThePoint.prefixSum(null));
        Assert.assertArrayEquals(new int[]{}, SumUptoThePoint.prefixSum(new int[]{}));
        Assert.assertArrayEquals(new int[]{-1, -3}, SumUptoThePoint.prefixSum(new int[]{-1, -2}));
    }

    @Test
    public void testRotatedArraySearchEdgeCases() {
        Assert.assertEquals(-1, RotatedArray.search(null, 5));
        Assert.assertEquals(-1, RotatedArray.search(new int[]{}, 5));
        Assert.assertEquals(0, RotatedArray.search(new int[]{5}, 5));
        Assert.assertEquals(-1, RotatedArray.search(new int[]{5}, 9));
    }

    @Test
    public void testSecondFrequentNumberWithSingleDistinctValue() {
        // Only one distinct value exists, so it is returned even though it's not truly "second".
        Map.Entry<Integer, Integer> entry = SecondFrequentNumberInAList.secondFrequent(Arrays.asList(7, 7, 7));
        Assert.assertEquals(Integer.valueOf(7), entry.getKey());
        Assert.assertEquals(Integer.valueOf(3), entry.getValue());
    }

    @Test
    public void testSecondFrequentNumberEmptyOrNullReturnsNull() {
        Assert.assertNull(SecondFrequentNumberInAList.secondFrequent(null));
        Assert.assertNull(SecondFrequentNumberInAList.secondFrequent(Collections.emptyList()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootOfNegativeThrows() {
        SquareRoot.sqrt(-4.0);
    }

    @Test
    public void testSquareRootOfNonPerfectSquare() {
        Assert.assertEquals(1.41421356, SquareRoot.sqrt(2.0), 0.0001);
    }

    @Test
    public void testWaterAllotterOverflowSpillsIntoLowerRow() {
        WaterAlotter allotter = new WaterAlotter();
        Map<Integer, Double> glasses = allotter.allotWater(4, 2, 1.0);
        // With 4 units poured into a 2-row pyramid capped at 1.0, all three glasses fill exactly.
        Assert.assertEquals(1.0, glasses.get(1), 0.001);
        Assert.assertEquals(1.0, glasses.get(2), 0.001);
        Assert.assertEquals(1.0, glasses.get(3), 0.001);
    }

    @Test
    public void testRoomAllotterNoOverlapNeedsOneRoom() {
        int[] start = {1, 5, 9};
        int[] end = {3, 7, 11};
        Assert.assertEquals(1, RoomAlotter.minMeetingRooms(start, end));
    }

    @Test
    public void testRoomAllotterFullOverlapNeedsRoomPerMeeting() {
        int[] start = {1, 1, 1};
        int[] end = {5, 5, 5};
        Assert.assertEquals(3, RoomAlotter.minMeetingRooms(start, end));
    }

    @Test
    public void testWordCountWithPunctuationAndCase() {
        Map<String, Integer> counts = WordCount.countWords("Hello, world! Hello-world.");
        Assert.assertEquals(Integer.valueOf(2), counts.get("hello"));
        Assert.assertEquals(Integer.valueOf(2), counts.get("world"));
    }

    @Test
    public void testWordCountNullAndBlankReturnEmptyMap() {
        Assert.assertTrue(WordCount.countWords(null).isEmpty());
        Assert.assertTrue(WordCount.countWords("   ").isEmpty());
    }
}
