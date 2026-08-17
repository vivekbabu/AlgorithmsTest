package in.algorithms.expression;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.expressionevaluation.InfixToPostfix;
import in.algorithms.expressionevaluation.PostFixEvaluator;
import in.algorithms.expressionevaluation.ExpressionEvalator;
import in.algorithms.balanced.BalancedExpression;

public class ExpressionEvaluationTest {

    @Test
    public void testInfixToPostfixConversion() {
        InfixToPostfix converter = new InfixToPostfix();

        // 2 + (4 * (3 - 1)) + (4 - 3) * 2 -> 2431-*43-2*++
        Assert.assertEquals("2431-*43-2*++", converter.convertToPostFix("2+(4*(3-1))+(4-3)*2"));
        Assert.assertEquals("2431-*432*-++", converter.convertToPostFix("2+(4*(3-1))+(4-3*2)"));
    }

    @Test
    public void testPostfixEvaluation() {
        PostFixEvaluator evaluator = new PostFixEvaluator();

        // 2 3 + = 5
        Assert.assertEquals(Integer.valueOf(5), evaluator.evaluatePostfixExpression("23+"));

        // 2 3 4 * + = 14
        Assert.assertEquals(Integer.valueOf(14), evaluator.evaluatePostfixExpression("234*+"));

        // (2 + 4 * (3 - 1) + (4 - 3) * 2) = 12
        Assert.assertEquals(Integer.valueOf(12), evaluator.evaluatePostfixExpression("2431-*43-2*++"));
    }

    @Test
    public void testEndToEndExpressionEvaluator() {
        ExpressionEvalator.main(new String[]{});
    }

    @Test
    public void testBalancedParentheses() {
        Assert.assertTrue(BalancedExpression.checkIfBalanced("(a+b)-((a-b))*(b)", 0));
        Assert.assertFalse(BalancedExpression.checkIfBalanced("a+b)-((a-b))*(b)", 0));
        Assert.assertFalse(BalancedExpression.checkIfBalanced("((())", 0));
        Assert.assertTrue(BalancedExpression.checkIfBalanced("()", 0));
        Assert.assertTrue(BalancedExpression.checkIfBalanced("", 0));
    }

    @Test
    public void testDecompositionApproaches() {
        // Polymorphic OOP
        in.algorithms.decomposition.polymorphic.Expr pExpr =
                new in.algorithms.decomposition.polymorphic.Sum(
                        new in.algorithms.decomposition.polymorphic.Number(6),
                        new in.algorithms.decomposition.polymorphic.Sum(
                                new in.algorithms.decomposition.polymorphic.Number(3),
                                new in.algorithms.decomposition.polymorphic.Number(5)));
        Assert.assertEquals(14, pExpr.eval());

        // Case Classes Pattern Matching
        in.algorithms.decomposition.casesolution.Expr cExpr =
                new in.algorithms.decomposition.casesolution.Sum(
                        new in.algorithms.decomposition.casesolution.Number(6),
                        new in.algorithms.decomposition.casesolution.Sum(
                                new in.algorithms.decomposition.casesolution.Number(3),
                                new in.algorithms.decomposition.casesolution.Number(5)));
        Assert.assertEquals(14, cExpr.eval());
        Assert.assertEquals("6+3+5", cExpr.show());
    }
}
