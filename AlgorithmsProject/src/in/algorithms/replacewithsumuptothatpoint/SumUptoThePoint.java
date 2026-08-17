package in.algorithms.replacewithsumuptothatpoint;

import java.util.Arrays;

public class SumUptoThePoint {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("Running sum: " + Arrays.toString(runningSum(arr)));
    }
}
