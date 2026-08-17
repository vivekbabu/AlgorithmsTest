package in.algorithms.collections;

import java.util.Arrays;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Algorithms", "Testing");
        list.forEach(System.out::println);
    }
}
