package in.algorithms.interviewprep.productofarrayexceptself;

// LeetCode 238: Product of Array Except Self - https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        int suffix=1, prefix = 1;

        int answer[] = new int[nums.length];

        for(int i =0; i < nums.length ; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        for(int j= nums.length - 1; j >=0; j --) {
            answer[j] *= suffix;
            suffix *= nums[j];
        }

        return answer;

    }
}
