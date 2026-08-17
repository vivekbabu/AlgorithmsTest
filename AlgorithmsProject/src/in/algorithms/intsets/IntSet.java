package in.algorithms.intsets;

public abstract class IntSet {
    public abstract boolean contains(int x);
    public abstract IntSet incl(int x);
    public abstract IntSet union(IntSet other);
}
