package in.algorithms.interviewprep.movezeroes;

// LeetCode 283: Move Zeroes - https://leetcode.com/problems/move-zeroes/description/
//
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order
// of the non-zero elements. This must be done in-place without making a copy of the array.
//
// Constraints:
//   - 1 <= nums.length <= 10^4
//   - -2^31 <= nums[i] <= 2^31 - 1
//
// Follow-up: minimise the total number of operations.
public class MoveZeroes {

    /**
     * Rearranges {@code nums} in place so that every zero is moved after every non-zero element,
     * while the non-zero elements keep their original relative order.
     *
     * @param nums the array to rearrange in place
     */
    public static void moveZeroes(int[] nums) {
       int forwardPosition = 0;
       int currentPosition = 0;
       int length = nums.length;
       while(forwardPosition < length) {
           while(forwardPosition < length && nums[forwardPosition]== 0)
               forwardPosition++;

           if(forwardPosition >= length)
               break;

           int temp = nums[currentPosition];
           nums[currentPosition]= nums[forwardPosition];
           nums[forwardPosition]= temp;
           currentPosition++;
           forwardPosition++;
       }
    }
}
