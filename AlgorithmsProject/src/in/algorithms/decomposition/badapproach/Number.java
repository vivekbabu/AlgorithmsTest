package in.algorithms.decomposition.badapproach;

public class Number implements Expr {
    private final int n;
    public Number(int n) { this.n = n; }

    @Override
    public boolean isNumber() { return true; }

    @Override
    public boolean isSum() { return false; }

    @Override
    public int numValue() { return n; }

    @Override
    public Expr leftOp() { throw new UnsupportedOperationException(); }

    @Override
    public Expr rightOp() { throw new UnsupportedOperationException(); }
}
