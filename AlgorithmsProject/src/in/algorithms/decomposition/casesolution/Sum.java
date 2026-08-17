package in.algorithms.decomposition.casesolution;

public class Sum implements Expr {
    private final Expr left, right;
    public Sum(Expr left, Expr right) { this.left = left; this.right = right; }
    @Override public int eval() { return left.eval() + right.eval(); }
    @Override public String show() { return left.show() + "+" + right.show(); }
}
