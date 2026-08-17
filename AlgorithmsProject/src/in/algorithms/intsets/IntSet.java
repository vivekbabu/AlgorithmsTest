package in.algorithms.intsets;

public interface IntSet {
    IntSet incl(int x);
    boolean contains(int x);
    IntSet union(IntSet other);
}
