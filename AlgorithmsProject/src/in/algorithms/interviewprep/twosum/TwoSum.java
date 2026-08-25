package in.algorithms.interviewprep.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode 1: Two Sum - https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numberPositions = new HashMap<>();
       for(int i = 0; i < nums.length; i++) {
           List<Integer> list = numberPositions.getOrDefault(nums[i], new ArrayList<>());
           list.add(i);
           numberPositions.put(nums[i], list);
       }

       for(int i=0;i<nums.length; i++) {
           int number = target - nums[i];
           List<Integer> list = numberPositions.getOrDefault(number, new ArrayList<>());
           for(int item : list) {
               if(item != i) return new int[]{i, item};
           }
       }
       return new int[] {-1, -1};
    }
}
