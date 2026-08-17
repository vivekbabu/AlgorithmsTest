package in.algorithms.secondfrequentnumberinalist;

import java.util.*;

public class SecondFrequentNumberInAList {
    public static Map.Entry<Integer, Integer> secondFrequent(List<Integer> list) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : list) freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        if (entries.size() >= 2) return entries.get(1);
        return entries.get(0);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 1, 1, 1, 2, 3, 3, 2, 1, 3, 3, 3, 2, 2, 1, 2, 1, 1, 1);
        Map.Entry<Integer, Integer> res = secondFrequent(nums);
        System.out.println("Second most frequent: Element=" + res.getKey() + ", Count=" + res.getValue());
    }
}
