package in.algorithms.interviewprep.groupanagrams;

import java.util.*;

// LeetCode 49: Group Anagrams - https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            List<String> curentList = map.getOrDefault(sortedString, new ArrayList<>());
            curentList.add(str);
            map.put(sortedString, curentList);
        }

        return map.values().stream().toList();
    }
}
