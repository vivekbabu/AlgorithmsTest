package in.algorithms.rationals;

public class Rationals {
    public static class Rational {
        private final int numer;
        private final int denom;

        public Rational(int n, int d) {
            if (d == 0) throw new IllegalArgumentException("Denominator cannot be zero");
            int g = gcd(Math.abs(n), Math.abs(d));
            this.numer = n / g;
            this.denom = d / g;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public Rational add(Rational that) {
            return new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom);
        }

        public Rational sub(Rational that) {
            return add(that.neg());
        }

        public Rational neg() {
            return new Rational(-this.numer, this.denom);
        }

        public Rational mul(Rational that) {
            return new Rational(this.numer * that.numer, this.denom * that.denom);
        }

        @Override
        public String toString() {
            return numer + "/" + denom;
        }
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        System.out.println("1/2 + 2/3 = " + r1.add(r2));
    }
}
