package in.algorithms.expressionevaluation;

import in.algorithms.stack.Stack;

public class PostFixEvaluator {

private Stack<String> resultStack = new Stack<String>();

public Integer evaluatePostfixExpression(String postfixExpression) {
  resultStack = new Stack<String>();
  Integer result = 0;
  for (int i = 0; i < postfixExpression.length(); i++) {
    Character character = postfixExpression.charAt(i);
    if (InfixToPostfix.isOperator(character)) {
      String secondOperand = resultStack.pop();
      String firstOperand = resultStack.pop();
      result = performOperation(firstOperand, secondOperand, character);
      resultStack.push(result.toString());

    } else
      resultStack.push(character.toString());
  }

  return Integer.parseInt(resultStack.pop());
}

private Integer performOperation(String firstOperand, String secondOperand,
    Character operator) {
  Integer result = null;
  Integer op1 = Integer.parseInt(firstOperand);
  Integer op2 = Integer.parseInt(secondOperand);
  switch (operator) {
  case '+':
    return op1 + op2;
  case '-':
    return op1 - op2;
  case '*':
    return op1 * op2;
  case '/':
    return op1 / op2;
  case '^':
    return Integer.getInteger(String.valueOf(Math.pow(op1, op2)));
  default:
    break;
  }
  return result;
}
}
