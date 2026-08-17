package in.algorithms.intsets;

public class NonEmpty implements IntSet {
    private final int element;
    private final IntSet left;
    private final IntSet right;

    public NonEmpty(int element, IntSet left, IntSet right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    @Override
    public IntSet incl(int x) {
        if (x < element) return new NonEmpty(element, left.incl(x), right);
        else if (x > element) return new NonEmpty(element, left, right.incl(x));
        else return this;
    }

    @Override
    public boolean contains(int x) {
        if (x < element) return left.contains(x);
        else if (x > element) return right.contains(x);
        else return true;
    }

    @Override
    public IntSet union(IntSet other) {
        return left.union(right).union(other).incl(element);
    }

    @Override
    public String toString() {
        return "{" + left + element + right + "}";
    }
}
