package in.algorithms.interviewprep.baseballgame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class BaseballGameTest {

    private static void assertPoints(String[] operations, int expected) {
        int actual = BaseballGame.calPoints(operations);
        Assert.assertEquals(
                "calPoints(" + Arrays.toString(operations) + ")",
                expected, actual);
    }

    /** Independent reference implementation using a stack of the still-valid scores. */
    private static int reference(String[] operations) {
        Deque<Integer> record = new ArrayDeque<>(); // top = most recent score
        for (String op : operations) {
            switch (op) {
                case "+": {
                    int last = record.pop();
                    int secondLast = record.peek();
                    record.push(last);
                    record.push(last + secondLast);
                    break;
                }
                case "D":
                    record.push(2 * record.peek());
                    break;
                case "C":
                    record.pop();
                    break;
                default:
                    record.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int v : record) {
            sum += v;
        }
        return sum;
    }

    // ---------------------------------------------------------------------
    // Problem-statement examples
    // ---------------------------------------------------------------------

    @Test
    public void testProblemStatementExampleOne() {
        // ["5","2","C","D","+"]
        // 5 -> [5]
        // 2 -> [5,2]
        // C -> [5]
        // D -> [5,10]
        // + -> [5,10,15]
        // sum = 30
        assertPoints(new String[]{"5", "2", "C", "D", "+"}, 30);
    }

    @Test
    public void testProblemStatementExampleTwo() {
        // ["5","-2","4","C","D","9","+","+"]
        // 5 -> [5]
        // -2 -> [5,-2]
        // 4 -> [5,-2,4]
        // C -> [5,-2]
        // D -> [5,-2,-4]
        // 9 -> [5,-2,-4,9]
        // + -> [5,-2,-4,9,5]
        // + -> [5,-2,-4,9,5,14]
        // sum = 27
        assertPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}, 27);
    }

    @Test
    public void testProblemStatementExampleThree() {
        // ["1","C"] -> record empties -> sum = 0
        assertPoints(new String[]{"1", "C"}, 0);
    }

    // ---------------------------------------------------------------------
    // Single-operation inputs (constraint: length >= 1)
    // ---------------------------------------------------------------------

    @Test
    public void testSinglePositiveInteger() {
        assertPoints(new String[]{"7"}, 7);
    }

    @Test
    public void testSingleNegativeInteger() {
        assertPoints(new String[]{"-13"}, -13);
    }

    @Test
    public void testSingleZero() {
        assertPoints(new String[]{"0"}, 0);
    }

    // ---------------------------------------------------------------------
    // Plain integers only, no special tokens
    // ---------------------------------------------------------------------

    @Test
    public void testOnlyIntegersArePlainlySummed() {
        assertPoints(new String[]{"1", "2", "3", "4", "5"}, 15);
    }

    @Test
    public void testOnlyIntegersWithNegativesAndZero() {
        assertPoints(new String[]{"10", "-4", "0", "-6", "3"}, 3);
    }

    @Test
    public void testIntegersThatSumToZero() {
        assertPoints(new String[]{"100", "-50", "-50", "25", "-25"}, 0);
    }

    // ---------------------------------------------------------------------
    // "D" — double the previous score
    // ---------------------------------------------------------------------

    @Test
    public void testDoubleOnAPositiveScore() {
        // [3] -> D -> [3,6] -> sum 9
        assertPoints(new String[]{"3", "D"}, 9);
    }

    @Test
    public void testDoubleOnANegativeScore() {
        // [-4] -> D -> [-4,-8] -> sum -12
        assertPoints(new String[]{"-4", "D"}, -12);
    }

    @Test
    public void testDoubleOnZero() {
        assertPoints(new String[]{"0", "D"}, 0);
    }

    @Test
    public void testConsecutiveDoubles() {
        // [2] -> D -> [2,4] -> D -> [2,4,8] -> D -> [2,4,8,16] -> sum 30
        assertPoints(new String[]{"2", "D", "D", "D"}, 30);
    }

    // ---------------------------------------------------------------------
    // "+" — sum of the previous two scores
    // ---------------------------------------------------------------------

    @Test
    public void testPlusOfTwoPositives() {
        // [1,2] -> + -> [1,2,3] -> sum 6
        assertPoints(new String[]{"1", "2", "+"}, 6);
    }

    @Test
    public void testPlusInvolvingNegatives() {
        // [5,-3] -> + -> [5,-3,2] -> sum 4
        assertPoints(new String[]{"5", "-3", "+"}, 4);
    }

    @Test
    public void testChainedPlusUsesTheTwoMostRecentScoresEachTime() {
        // [1,1] -> + -> [1,1,2] -> + -> [1,1,2,3] -> + -> [1,1,2,3,5] -> Fibonacci-ish, sum 12
        assertPoints(new String[]{"1", "1", "+", "+", "+"}, 12);
    }

    @Test
    public void testPlusAfterADouble() {
        // [3] -> D -> [3,6] -> + -> [3,6,9] -> sum 18
        assertPoints(new String[]{"3", "D", "+"}, 18);
    }

    // ---------------------------------------------------------------------
    // "C" — cancel the previous score
    // ---------------------------------------------------------------------

    @Test
    public void testCancelRemovesOnlyTheMostRecentScore() {
        // [4,5] -> C -> [4] -> sum 4
        assertPoints(new String[]{"4", "5", "C"}, 4);
    }

    @Test
    public void testCancelThenContinue() {
        // [10] -> D -> [10,20] -> C -> [10] -> D -> [10,20] -> sum 30
        assertPoints(new String[]{"10", "D", "C", "D"}, 30);
    }

    @Test
    public void testMultipleCancelsInARow() {
        // [1,2,3] -> C -> [1,2] -> C -> [1] -> C -> [] -> sum 0
        assertPoints(new String[]{"1", "2", "3", "C", "C", "C"}, 0);
    }

    @Test
    public void testCancelANegativeScore() {
        // [7,-100] -> C -> [7] -> sum 7
        assertPoints(new String[]{"7", "-100", "C"}, 7);
    }

    @Test
    public void testCancelAfterPlusRemovesOnlyTheSummedEntry() {
        // [2,3] -> + -> [2,3,5] -> C -> [2,3] -> sum 5
        assertPoints(new String[]{"2", "3", "+", "C"}, 5);
    }

    // ---------------------------------------------------------------------
    // Interaction of all four operation types
    // ---------------------------------------------------------------------

    @Test
    public void testCancelThenPlusReadsThroughToOlderScores() {
        // [1,2,3] -> C -> [1,2] -> + -> [1,2,3] -> sum 6
        assertPoints(new String[]{"1", "2", "3", "C", "+"}, 6);
    }

    @Test
    public void testDoubleThenCancelLeavesTheOriginal() {
        // [8] -> D -> [8,16] -> C -> [8] -> sum 8
        assertPoints(new String[]{"8", "D", "C"}, 8);
    }

    @Test
    public void testLongMixedSequence() {
        String[] ops = {"5", "2", "C", "D", "+", "3", "C", "D", "+", "C"};
        // 5      -> [5]
        // 2      -> [5,2]
        // C      -> [5]
        // D      -> [5,10]
        // +      -> [5,10,15]
        // 3      -> [5,10,15,3]
        // C      -> [5,10,15]
        // D      -> [5,10,15,30]
        // +      -> [5,10,15,30,45]
        // C      -> [5,10,15,30]
        // sum = 60
        assertPoints(ops, 60);
    }

    // ---------------------------------------------------------------------
    // Negative running totals
    // ---------------------------------------------------------------------

    @Test
    public void testResultCanBeNegative() {
        // [-10,-20] -> + -> [-10,-20,-30] -> D -> [-10,-20,-30,-60] -> sum -120
        assertPoints(new String[]{"-10", "-20", "+", "D"}, -120);
    }

    @Test
    public void testPlusOfMixedSignsGivingNegative() {
        // [3,-8] -> + -> [3,-8,-5] -> sum -10
        assertPoints(new String[]{"3", "-8", "+"}, -10);
    }

    // ---------------------------------------------------------------------
    // Value magnitude (constraint: integers in [-3*10^4, 3*10^4])
    // ---------------------------------------------------------------------

    @Test
    public void testLargeMagnitudeIntegerLiterals() {
        assertPoints(new String[]{"30000", "-30000", "+"}, 0);
    }

    @Test
    public void testLargeMagnitudeWithDoubleStillFitsInInt() {
        // [30000] -> D -> [30000,60000] -> + -> [30000,60000,90000] -> sum 180000
        assertPoints(new String[]{"30000", "D", "+"}, 180_000);
    }

    @Test
    public void testCancelUndoesLargeMagnitudeContribution() {
        assertPoints(new String[]{"12345", "30000", "C", "-12345"}, 0);
    }

    // ---------------------------------------------------------------------
    // Cross-check against an independent reference
    // ---------------------------------------------------------------------

    @Test
    public void testAgainstReferenceOnHandBuiltSequences() {
        String[][] cases = {
                {"1"},
                {"-1", "D", "D", "+"},
                {"7", "7", "+", "C", "C"},
                {"3", "C", "5", "D", "+", "2"},
                {"0", "0", "+", "D", "C"},
                {"100", "50", "C", "D", "+", "25", "C"},
        };
        for (String[] ops : cases) {
            assertPoints(ops, reference(ops));
        }
    }

    @Test
    public void testAgainstReferenceOnRandomValidSequences() {
        final long seed = 682_20260829L;
        final int magnitudeCap = 1_000_000; // keep every score and the total well inside a 32-bit int
        Random random = new Random(seed);

        for (int trial = 0; trial < 500; trial++) {
            int length = 1 + random.nextInt(1000); // 1..1000, the constraint bound
            String[] ops = new String[length];

            // A live mirror of the record so we only ever emit operations that are both legal
            // (enough previous scores) and overflow-safe (result magnitude stays bounded).
            Deque<Integer> mirror = new ArrayDeque<>(); // top = most recent score

            for (int i = 0; i < length; i++) {
                boolean canDouble = !mirror.isEmpty()
                        && Math.abs(2L * mirror.peek()) <= magnitudeCap;
                boolean canCancel = !mirror.isEmpty();
                boolean canPlus;
                if (mirror.size() >= 2) {
                    int a = mirror.pop();
                    int b = mirror.peek();
                    mirror.push(a);
                    canPlus = Math.abs((long) a + b) <= magnitudeCap;
                } else {
                    canPlus = false;
                }

                java.util.List<String> choices = new java.util.ArrayList<>();
                choices.add("INT");
                if (canDouble) choices.add("D");
                if (canCancel) choices.add("C");
                if (canPlus) choices.add("+");

                String pick = choices.get(random.nextInt(choices.size()));
                switch (pick) {
                    case "D":
                        ops[i] = "D";
                        mirror.push(2 * mirror.peek());
                        break;
                    case "C":
                        ops[i] = "C";
                        mirror.pop();
                        break;
                    case "+": {
                        int a = mirror.pop();
                        int b = mirror.peek();
                        mirror.push(a);
                        ops[i] = "+";
                        mirror.push(a + b);
                        break;
                    }
                    default: {
                        int value = random.nextInt(60_001) - 30_000; // [-30000, 30000]
                        ops[i] = Integer.toString(value);
                        mirror.push(value);
                    }
                }
            }

            assertPoints(ops, reference(ops));
        }
    }

    // ---------------------------------------------------------------------
    // Maximum length (constraint upper bound: 1000)
    // ---------------------------------------------------------------------

    @Test
    public void testMaximumLengthAllOnes() {
        String[] ops = new String[1000];
        Arrays.fill(ops, "1");
        assertPoints(ops, 1000);
    }

    @Test
    public void testMaximumLengthAlternatingScoreAndCancelNetsToZero() {
        // "5","C","5","C",... -> every score is immediately cancelled -> sum 0
        String[] ops = new String[1000];
        for (int i = 0; i < ops.length; i++) {
            ops[i] = (i % 2 == 0) ? "5" : "C";
        }
        assertPoints(ops, 0);
    }

    @Test
    public void testMaximumLengthOneSeedThenAllDoublesViaReference() {
        // "1" then 12 "D"s stays inside a 32-bit int (1<<12 = 4096); pad the rest with "C"/"1".
        String[] ops = new String[1000];
        ops[0] = "1";
        for (int i = 1; i <= 12; i++) {
            ops[i] = "D";
        }
        for (int i = 13; i < ops.length; i++) {
            ops[i] = (i % 2 == 0) ? "1" : "C"; // net-zero padding
        }
        assertPoints(ops, reference(ops));
    }
}
