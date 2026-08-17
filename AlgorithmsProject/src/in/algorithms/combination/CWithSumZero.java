package in.algorithms.combination;

import java.util.Arrays;
import java.util.List;

public class CWithSumZero {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 0, 1, 2, -1, -4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 0) {
                    System.out.println("Zero sum pair: (" + list.get(i) + ", " + list.get(j) + ")");
                }
            }
        }
    }
}
