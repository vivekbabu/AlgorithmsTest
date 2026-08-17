package in.algorithms.decomposition.casesolution;

public class Number implements Expr {
    private final int value;
    public Number(int value) { this.value = value; }
    @Override public int eval() { return value; }
    @Override public String show() { return String.valueOf(value); }
}
