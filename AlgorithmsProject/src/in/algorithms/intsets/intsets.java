package in.algorithms.intsets;

public class intsets {
    public static void main(String[] args) {
        IntSet t1 = new NonEmpty(10, Empty.INSTANCE, Empty.INSTANCE);
        IntSet t2 = t1.incl(3).incl(4).incl(9);
        IntSet t4 = new NonEmpty(7, Empty.INSTANCE, Empty.INSTANCE).incl(3).incl(8);
        IntSet t7 = t2.union(t4);
        System.out.println("Union IntSet: " + t7);
    }
}
