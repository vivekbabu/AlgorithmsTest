package in.algorithms.interviewprep.containsduplicate;

import java.util.HashSet;
import java.util.Set;

// LeetCode 217: Contains Duplicate - https://leetcode.com/problems/contains-duplicate/description/
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}
