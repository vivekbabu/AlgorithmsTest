package in.algorithms.intsets;

public class NonEmpty extends IntSet {
    public final int elem;
    public final IntSet left;
    public final IntSet right;

    public NonEmpty(int elem, IntSet left, IntSet right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean contains(int x) {
        if (x < elem) return left.contains(x);
        if (x > elem) return right.contains(x);
        return true;
    }

    @Override
    public IntSet incl(int x) {
        if (x < elem) return new NonEmpty(elem, left.incl(x), right);
        if (x > elem) return new NonEmpty(elem, left, right.incl(x));
        return this;
    }

    @Override
    public IntSet union(IntSet other) {
        return left.union(right).union(other).incl(elem);
    }

    @Override
    public String toString() {
        return "{" + left + elem + right + "}";
    }
}
