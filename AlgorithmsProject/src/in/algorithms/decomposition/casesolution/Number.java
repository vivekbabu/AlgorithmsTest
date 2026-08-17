package in.algorithms.decomposition.casesolution;

public class Number extends Expr {
    public final int n;
    public Number(int n) { this.n = n; }

    @Override
    public int eval() { return n; }

    @Override
    public String show() { return String.valueOf(n); }
}
