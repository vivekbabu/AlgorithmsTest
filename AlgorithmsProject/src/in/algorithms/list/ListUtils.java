package in.algorithms.list;

public class ListUtils {
    public static <T> T nth(int n, List<T> list) {
        if (list.isEmpty()) throw new IndexOutOfBoundsException();
        if (n == 0) return list.head();
        return nth(n - 1, list.tail());
    }
}
