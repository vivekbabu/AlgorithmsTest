package in.algorithms.combination;

import java.util.Arrays;
import java.util.List;

public class CombinationsWithAnyFunction {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                System.out.println("(" + list.get(i) + ", " + list.get(j) + ")");
            }
        }
    }
}
