package in.algorithms.decomposition.polymorphic;

public class Sum implements Expr {
    private final Expr left, right;
    public Sum(Expr left, Expr right) { this.left = left; this.right = right; }
    @Override public int eval() { return left.eval() + right.eval(); }
}
