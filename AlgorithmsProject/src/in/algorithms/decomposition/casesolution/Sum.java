package in.algorithms.decomposition.casesolution;

public class Sum extends Expr {
    public final Expr e1;
    public final Expr e2;

    public Sum(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int eval() { return e1.eval() + e2.eval(); }

    @Override
    public String show() { return e1.show() + " + " + e2.show(); }
}
