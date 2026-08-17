package in.algorithms.balanced;

public class BalancedExpression {
    public static boolean checkIfBalanced(String s, int currentCount) {
        if (s.isEmpty()) return currentCount == 0;
        char head = s.charAt(0);
        String tail = s.substring(1);
        if (head == '(') return checkIfBalanced(tail, currentCount + 1);
        if (head == ')') return currentCount > 0 && checkIfBalanced(tail, currentCount - 1);
        return checkIfBalanced(tail, currentCount);
    }

    public static void main(String[] args) {
        System.out.println("(a+b)-((a-b))*(b) balanced: " + checkIfBalanced("(a+b)-((a-b))*(b)", 0));
        System.out.println("a+b)-((a-b))*(b) balanced: " + checkIfBalanced("a+b)-((a-b))*(b)", 0));
    }
}
