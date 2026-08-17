package in.algorithms.expression;

import in.algorithms.balanced.BalancedExpression;
import in.algorithms.expressionevaluation.ExpressionEvalator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluationTest {

    @Test
    public void testBalancedParentheses() {
        Assert.assertTrue(BalancedExpression.isBalanced("({[]})"));
        Assert.assertTrue(BalancedExpression.isBalanced("()[]{}"));
        Assert.assertFalse(BalancedExpression.isBalanced("([)]"));
        Assert.assertFalse(BalancedExpression.isBalanced("(((("));
        Assert.assertTrue(BalancedExpression.isBalanced(""));
    }

    @Test
    public void testInfixToPostfix() {
        Assert.assertEquals("ab+", ExpressionEvalator.infixToPostfix("a+b"));
        Assert.assertEquals("abc*+", ExpressionEvalator.infixToPostfix("a+b*c"));
        Assert.assertEquals("ab+c*", ExpressionEvalator.infixToPostfix("(a+b)*c"));
    }

    @Test
    public void testEvaluatePostfix() {
        Assert.assertEquals(14, ExpressionEvalator.evaluatePostfix("234*+"));
        Assert.assertEquals(8, ExpressionEvalator.evaluatePostfix("2431-*432*-++"));
    }
}
