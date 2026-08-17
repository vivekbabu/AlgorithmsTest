package in.algorithms.decomposition.badapproach;

public class ExprSimulator {
    public static int eval(Expr e) {
        if (e.isNumber()) return e.numValue();
        if (e.isSum()) return eval(e.leftOp()) + eval(e.rightOp());
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Expr expr = new Sum(new Number(6), new Sum(new Number(3), new Number(5)));
        System.out.println("BadApproach Eval: " + eval(expr));
    }
}
