package in.algorithms.highestsumconsecutive;

import java.util.List;

public class HighestSum {
    public static int highestSum(List<Integer> list, int index, int currentSum) {
        if (list == null || list.isEmpty()) return 0;
        int inclusive = list.get(0);
        int exclusive = 0;

        for (int i = 1; i < list.size(); i++) {
            int newInclusive = exclusive + list.get(i);
            exclusive = Math.max(inclusive, exclusive);
            inclusive = newInclusive;
        }
        return Math.max(inclusive, exclusive);
    }

    public static int maxSubArraySumKadane(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSoFar = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
