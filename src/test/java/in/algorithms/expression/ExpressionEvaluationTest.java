package in.algorithms.expression;

import in.algorithms.balanced.BalancedExpression;
import in.algorithms.expressionevaluation.ExpressionEvalator;
import in.algorithms.expressionevaluation.InfixToPostfix;
import in.algorithms.expressionevaluation.PostFixEvaluator;
import org.junit.Assert;
import org.junit.Test;
import java.util.NoSuchElementException;

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

    @Test
    public void testInfixToPostfixEdgeCases() {
        Assert.assertEquals("", ExpressionEvalator.infixToPostfix(""));
        Assert.assertEquals("a", ExpressionEvalator.infixToPostfix("a"));
        Assert.assertEquals("ab-", ExpressionEvalator.infixToPostfix("a-b"));
        Assert.assertEquals("ab*cd*+", ExpressionEvalator.infixToPostfix("a*b+c*d"));
        Assert.assertEquals("ab^c^", ExpressionEvalator.infixToPostfix("a^b^c")); // left-associative, since prec(^) <= prec(^) pops eagerly
    }

    @Test
    public void testEvaluatePostfixDivisionAndSubtraction() {
        Assert.assertEquals(2, ExpressionEvalator.evaluatePostfix("84/"));
        Assert.assertEquals(3, ExpressionEvalator.evaluatePostfix("52-"));
        Assert.assertEquals(1, ExpressionEvalator.evaluatePostfix("21-"));
    }

    @Test
    public void testPostFixEvaluatorAllOperators() {
        PostFixEvaluator evaluator = new PostFixEvaluator();
        Assert.assertEquals(Integer.valueOf(5), evaluator.evaluatePostfixExpression("23+"));
        Assert.assertEquals(Integer.valueOf(3), evaluator.evaluatePostfixExpression("52-"));
        Assert.assertEquals(Integer.valueOf(6), evaluator.evaluatePostfixExpression("23*"));
        Assert.assertEquals(Integer.valueOf(2), evaluator.evaluatePostfixExpression("84/"));
        Assert.assertEquals(Integer.valueOf(7), evaluator.evaluatePostfixExpression("7"));
    }

    @Test
    public void testPostFixEvaluatorCompoundExpression() {
        PostFixEvaluator evaluator = new PostFixEvaluator();
        // (6-2)*1 = 4
        Assert.assertEquals(Integer.valueOf(4), evaluator.evaluatePostfixExpression("62-1*"));
    }

    @Test(expected = NullPointerException.class)
    public void testPostFixEvaluatorPowerOperatorIsBroken() {
        // Known defect: performOperation('^') calls Integer.getInteger(String) which looks up a
        // system property rather than parsing the value, always yielding null and an NPE here.
        new PostFixEvaluator().evaluatePostfixExpression("23^");
    }

    @Test(expected = NoSuchElementException.class)
    public void testInfixToPostfixConverterAlwaysThrowsDueToUnguardedFinalPop() {
        // Known defect: convertToPostFix's trailing drain loop calls operatorStack.pop() one time
        // too many expecting a null sentinel, but this custom Stack throws when empty instead of
        // returning null - so every call currently throws, even for input with no operators.
        new InfixToPostfix().convertToPostFix("a+b");
    }
}
