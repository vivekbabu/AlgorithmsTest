
package in.algorithms.expressionevaluation;
public class ExpressionEvalator {
	public static void main(String[] args) {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		PostFixEvaluator evaluator = new PostFixEvaluator();
		String output = infixToPostfix.convertToPostFix("2+(4*(3-1))+(4-3*2)");
		System.out.println(output);
		System.out.println(evaluator.evaluatePostfixExpression(output));
		output = infixToPostfix.convertToPostFix("2+(4*(3-1))+(4-3)*2");
		System.out.println(output);
		System.out.println(evaluator.evaluatePostfixExpression(output));
	}
}
