package in.algorithms.secondfrequentnumberinalist;

import java.util.*;

public class SecondFrequentNumberInAList {
    public static Map.Entry<Integer, Integer> secondFrequent(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : list) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return entries.size() > 1 ? entries.get(1) : entries.get(0);
    }
}
