package in.algorithms.decomposition.badapproach;

public class Sum implements Expr {
    private final Expr left, right;
    public Sum(Expr left, Expr right) { this.left = left; this.right = right; }
    @Override public boolean isNumber() { return false; }
    @Override public boolean isSum() { return true; }
    @Override public int numValue() { throw new UnsupportedOperationException(); }
    @Override public Expr leftOp() { return left; }
    @Override public Expr rightOp() { return right; }
}
