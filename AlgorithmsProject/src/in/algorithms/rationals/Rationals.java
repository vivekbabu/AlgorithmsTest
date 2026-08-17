package in.algorithms.rationals;

public class Rationals {
    public final int numer;
    public final int denom;

    public Rationals(int numer, int denom) {
        if (denom == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        int g = gcd(Math.abs(numer), Math.abs(denom));
        int sign = denom < 0 ? -1 : 1;
        this.numer = (numer / g) * sign;
        this.denom = Math.abs(denom) / g;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Rationals add(Rationals that) {
        return new Rationals(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom);
    }

    public Rationals sub(Rationals that) {
        return new Rationals(this.numer * that.denom - that.numer * this.denom, this.denom * that.denom);
    }

    public Rationals mul(Rationals that) {
        return new Rationals(this.numer * that.numer, this.denom * that.denom);
    }

    public Rationals div(Rationals that) {
        return new Rationals(this.numer * that.denom, this.denom * that.numer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rationals)) return false;
        Rationals rationals = (Rationals) o;
        return numer == rationals.numer && denom == rationals.denom;
    }

    @Override
    public int hashCode() {
        return 31 * numer + denom;
    }

    @Override
    public String toString() {
        return numer + "/" + denom;
    }
}
