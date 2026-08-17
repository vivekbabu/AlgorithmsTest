package in.algorithms.wordcount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> map = new HashMap<>();
        if (text == null || text.trim().isEmpty()) return map;
        String[] words = text.toLowerCase().split("\\W+");
        for (String w : words) {
            if (!w.isEmpty()) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        return map;
    }
}
