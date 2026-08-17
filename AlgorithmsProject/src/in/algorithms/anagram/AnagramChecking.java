package in.algorithms.anagram;

import java.util.Arrays;

public class AnagramChecking {
    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        String clean1 = s1.replaceAll("\\s", "").toLowerCase();
        String clean2 = s2.replaceAll("\\s", "").toLowerCase();
        if (clean1.length() != clean2.length()) return false;
        char[] c1 = clean1.toCharArray();
        char[] c2 = clean2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
