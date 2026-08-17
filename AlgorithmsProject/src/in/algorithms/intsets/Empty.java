package in.algorithms.intsets;

public class Empty extends IntSet {
    public static final Empty INSTANCE = new Empty();

    @Override
    public boolean contains(int x) {
        return false;
    }

    @Override
    public IntSet incl(int x) {
        return new NonEmpty(x, INSTANCE, INSTANCE);
    }

    @Override
    public IntSet union(IntSet other) {
        return other;
    }

    @Override
    public String toString() {
        return ".";
    }
}
