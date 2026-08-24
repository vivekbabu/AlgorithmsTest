package in.algorithms.decomposition;

import org.junit.Assert;
import org.junit.Test;

public class DecompositionPatternsTest {

    @Test
    public void testPolymorphicDecomposition() {
        in.algorithms.decomposition.polymorphic.Expr expr =
                new in.algorithms.decomposition.polymorphic.Sum(
                        new in.algorithms.decomposition.polymorphic.Number(10),
                        new in.algorithms.decomposition.polymorphic.Number(20)
                );
        Assert.assertEquals(30, expr.eval());
        Assert.assertEquals("10 + 20", expr.show());
    }

    @Test
    public void testCaseSolutionDecomposition() {
        in.algorithms.decomposition.casesolution.Expr expr =
                new in.algorithms.decomposition.casesolution.Sum(
                        new in.algorithms.decomposition.casesolution.Number(5),
                        new in.algorithms.decomposition.casesolution.Number(15)
                );
        Assert.assertEquals(20, expr.eval());
        Assert.assertEquals("5 + 15", expr.show());
    }

    @Test
    public void testBadApproachDecomposition() {
        in.algorithms.decomposition.badapproach.Expr n1 = new in.algorithms.decomposition.badapproach.Number(7);
        in.algorithms.decomposition.badapproach.Expr n2 = new in.algorithms.decomposition.badapproach.Number(3);
        in.algorithms.decomposition.badapproach.Expr sum = new in.algorithms.decomposition.badapproach.Sum(n1, n2);

        Assert.assertTrue(n1.isNumber());
        Assert.assertFalse(n1.isSum());
        Assert.assertEquals(7, n1.numValue());

        Assert.assertTrue(sum.isSum());
        Assert.assertFalse(sum.isNumber());
        Assert.assertEquals(7, sum.leftOp().numValue());
        Assert.assertEquals(3, sum.rightOp().numValue());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBadApproachNumberHasNoLeftOperand() {
        new in.algorithms.decomposition.badapproach.Number(1).leftOp();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBadApproachSumHasNoNumValue() {
        in.algorithms.decomposition.badapproach.Expr sum = new in.algorithms.decomposition.badapproach.Sum(
                new in.algorithms.decomposition.badapproach.Number(1),
                new in.algorithms.decomposition.badapproach.Number(2));
        sum.numValue();
    }

    @Test
    public void testPolymorphicNestedSumExpression() {
        in.algorithms.decomposition.polymorphic.Expr expr =
                new in.algorithms.decomposition.polymorphic.Sum(
                        new in.algorithms.decomposition.polymorphic.Sum(
                                new in.algorithms.decomposition.polymorphic.Number(1),
                                new in.algorithms.decomposition.polymorphic.Number(2)),
                        new in.algorithms.decomposition.polymorphic.Number(3));

        Assert.assertEquals(6, expr.eval());
        Assert.assertEquals("1 + 2 + 3", expr.show());
    }

    @Test
    public void testCaseSolutionNestedSumExpression() {
        in.algorithms.decomposition.casesolution.Expr expr =
                new in.algorithms.decomposition.casesolution.Sum(
                        new in.algorithms.decomposition.casesolution.Number(4),
                        new in.algorithms.decomposition.casesolution.Sum(
                                new in.algorithms.decomposition.casesolution.Number(5),
                                new in.algorithms.decomposition.casesolution.Number(6)));

        Assert.assertEquals(15, expr.eval());
        Assert.assertEquals("4 + 5 + 6", expr.show());
    }

    @Test
    public void testAllThreeApproachesAgreeOnEvaluatedResult() {
        int polymorphicResult = new in.algorithms.decomposition.polymorphic.Sum(
                new in.algorithms.decomposition.polymorphic.Number(2),
                new in.algorithms.decomposition.polymorphic.Number(3)).eval();
        int caseSolutionResult = new in.algorithms.decomposition.casesolution.Sum(
                new in.algorithms.decomposition.casesolution.Number(2),
                new in.algorithms.decomposition.casesolution.Number(3)).eval();

        Assert.assertEquals(polymorphicResult, caseSolutionResult);
        Assert.assertEquals(5, polymorphicResult);
    }
}
