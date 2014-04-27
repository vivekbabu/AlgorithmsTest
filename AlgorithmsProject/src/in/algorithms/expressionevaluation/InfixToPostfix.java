package in.algorithms.expressionevaluation;

import java.util.HashMap;
import java.util.Map;

import in.algorithms.stack.Stack;

public class InfixToPostfix {
	Map<Character, Integer> precedenceMap = new HashMap<Character, Integer>();
	StringBuilder postfixExpression = new StringBuilder();
	public InfixToPostfix() {
		precedenceMap.put('(', 0);
		precedenceMap.put('+', 1);
		precedenceMap.put('-', 1);
		precedenceMap.put('*', 2);
		precedenceMap.put('/', 2);
		precedenceMap.put('^', 3);
	}
	
	public static boolean isOperator(char character) {
		boolean isOperator = false;
		switch (character) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^': isOperator = true;break;
		default:
			break;
		}
		return isOperator;
	}
	
	Stack<Character> operatorStack = new Stack<Character>();
	
	public String convertToPostFix(String expression) {
		operatorStack = new Stack<Character>();
		postfixExpression = new StringBuilder();
		for(int i = 0; i< expression.length() ; i++) {
			char character = expression.charAt(i);
			if(character == '(')
				operatorStack.push(character);
			else if (isOperator(character)) {
				Character stackCharacter = operatorStack.pop();
				while(isPrecedenceHigher(stackCharacter, character)) {
					postfixExpression.append(stackCharacter);
					stackCharacter = operatorStack.pop();
				}
				if(stackCharacter != null)
					operatorStack.push(stackCharacter);
				operatorStack.push(character);
			}
			else if(character == ')') {
				Character stackCharacter = operatorStack.pop();
				while(stackCharacter!= '(') {
					postfixExpression.append(stackCharacter);
					stackCharacter = operatorStack.pop();
				}
			}
			else 
				postfixExpression.append(character);
		}
		Character stackCharacter = operatorStack.pop();
		while(stackCharacter!=null) {
			postfixExpression.append(stackCharacter);
			stackCharacter = operatorStack.pop();
		}
			
		return postfixExpression.toString();
		
	}

	private boolean isPrecedenceHigher(Character stackCharacter, char character) {
		if(stackCharacter == null)
			return false;
		else return precedenceMap.get(stackCharacter) > precedenceMap.get(character);
	}
	
}
