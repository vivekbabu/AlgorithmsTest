package in.algorithms.wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static Map<String, Long> countWords(List<String> lines) {
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
                "hello world",
                "hello java",
                "algorithms in java and data structures"
        );
        Map<String, Long> counts = countWords(lines);
        System.out.println("Word counts: " + counts);
    }
}
