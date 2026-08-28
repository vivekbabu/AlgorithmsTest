package in.algorithms.interviewprep.removeduplicatesfromsortedarray;

// LeetCode 26: Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
// that each unique element appears only once. The relative order of the elements should be kept
// the same. Return k, the number of unique elements.
//
// The judge only inspects the first k elements of nums (which must hold the unique values, in
// order) and the returned value k; elements beyond index k - 1 are ignored.
//
// Constraints:
//   - 1 <= nums.length <= 3 * 10^4
//   - -100 <= nums[i] <= 100
//   - nums is sorted in non-decreasing order.
public class RemoveDuplicatesFromSortedArray {

    /**
     * Removes duplicates from {@code nums} in place so that the first {@code k} entries hold the
     * distinct values in their original ascending order.
     *
     * @param nums a non-empty array sorted in non-decreasing order; mutated in place
     * @return {@code k}, the count of distinct values now stored in {@code nums[0 .. k - 1]}
     */
    public static int removeDuplicates(int[] nums) {
        int insertPosition = 0;
        int forwardPosition = 0;
        int length = nums.length;

        while(forwardPosition + 1 < length) {
            while(forwardPosition + 1 < length && nums[forwardPosition] == nums[forwardPosition +1])
                forwardPosition++;

            nums[insertPosition] = nums[forwardPosition];
            insertPosition++;
            forwardPosition++;
        }

        if(forwardPosition < length) {
            nums[insertPosition] = nums[forwardPosition];
            insertPosition++;
        }
        return insertPosition;

    }
}
