package in.algorithms.decomposition.polymorphic;

public class Number implements Expr {
    private final int n;
    public Number(int n) { this.n = n; }

    @Override
    public int eval() { return n; }

    @Override
    public String show() { return String.valueOf(n); }
}
