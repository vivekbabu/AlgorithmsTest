package in.algorithms.decomposition.casesolution;

public class ExprSimulator {
    public static void main(String[] args) {
        Expr expr = new Sum(new Number(6), new Sum(new Number(3), new Number(5)));
        System.out.println("CaseSolution Eval: " + expr.eval() + ", Show: " + expr.show());
    }
}
