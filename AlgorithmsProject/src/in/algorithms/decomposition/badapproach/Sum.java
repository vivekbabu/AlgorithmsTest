package in.algorithms.decomposition.badapproach;

public class Sum implements Expr {
    private final Expr e1;
    private final Expr e2;

    public Sum(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean isNumber() { return false; }

    @Override
    public boolean isSum() { return true; }

    @Override
    public int numValue() { throw new UnsupportedOperationException(); }

    @Override
    public Expr leftOp() { return e1; }

    @Override
    public Expr rightOp() { return e2; }
}
