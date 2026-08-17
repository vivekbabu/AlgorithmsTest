package in.algorithms.list;

public class ListUtils {
    public static <T> T nth(int n, List<T> list) {
        if (list.isEmpty()) throw new IndexOutOfBoundsException();
        if (n == 0) return list.head();
        return nth(n - 1, list.tail());
    }

    public static void main(String[] args) {
        List<Integer> list = new Cons<>(1, new Cons<>(2, new Cons<>(3, new Nil<>())));
        System.out.println("0th element: " + nth(0, list));
        System.out.println("2nd element: " + nth(2, list));
    }
}
