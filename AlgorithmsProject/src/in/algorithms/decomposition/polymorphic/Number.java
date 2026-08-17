package in.algorithms.decomposition.polymorphic;

public class Number implements Expr {
    private final int value;
    public Number(int value) { this.value = value; }
    @Override public int eval() { return value; }
}
