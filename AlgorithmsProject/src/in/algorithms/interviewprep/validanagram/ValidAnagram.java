package in.algorithms.interviewprep.validanagram;

import java.util.HashMap;
import java.util.Map;

// LeetCode 242: Valid Anagram - https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            Integer currentVal = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++currentVal);
        }

        for(int i=0; i< t.length(); i++) {
            Integer currentVal = map.getOrDefault(t.charAt(i), 0);
            if(currentVal == 0) return false;
            if(currentVal == 1) map.remove(t.charAt(i));
            else
                map.put(t.charAt(i), --currentVal);
        }

        return map.keySet().isEmpty();




    }
}
