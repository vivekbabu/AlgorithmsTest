package in.algorithms.decomposition.badapproach;

public interface Expr {
    boolean isNumber();
    boolean isSum();
    int numValue();
    Expr leftOp();
    Expr rightOp();
}
