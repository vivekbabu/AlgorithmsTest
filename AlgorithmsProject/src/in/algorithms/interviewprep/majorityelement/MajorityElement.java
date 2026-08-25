package in.algorithms.interviewprep.majorityelement;

// LeetCode 169: Majority Element - https://leetcode.com/problems/majority-element/description/
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int majorityCount = 1;

        for(int i =1 ; i< nums.length; i++) {

            if(nums[i] == majorityElement) majorityCount++;
            else {
                majorityCount --;
                if(majorityCount == 0) {
                    majorityElement = nums[i];
                    majorityCount = 1;
                }
            }
        }
        return majorityElement;
    }
}
