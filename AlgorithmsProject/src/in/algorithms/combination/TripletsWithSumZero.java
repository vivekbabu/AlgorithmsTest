package in.algorithms.combination;

import java.util.Arrays;
import java.util.List;

public class TripletsWithSumZero {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 0, 1, 2, -1, -4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    if (list.get(i) + list.get(j) + list.get(k) == 0) {
                        System.out.println("Zero sum triplet: (" + list.get(i) + ", " + list.get(j) + ", " + list.get(k) + ")");
                    }
                }
            }
        }
    }
}
