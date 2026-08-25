package in.algorithms.interviewprep.maximumsubarray;

// LeetCode 53: Maximum Subarray - https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMax = nums[0];
        for(int i = 1; i < nums.length ; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(currentMax, maxSum);
        }

        return maxSum;

    }


}
