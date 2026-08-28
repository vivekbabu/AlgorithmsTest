package in.algorithms.interviewprep.binarysearch;

// LeetCode 704: Binary Search - https://leetcode.com/problems/binary-search/description/
//
// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, return its index. Otherwise,
// return -1. You must write an algorithm with O(log n) runtime complexity.
//
// Constraints:
//   - 1 <= nums.length <= 10^4
//   - -10^4 < nums[i], target < 10^4
//   - All the integers in nums are unique.
//   - nums is sorted in ascending order.
public class BinarySearch {

    /**
     * Returns the index of {@code target} in the ascending, duplicate-free array {@code nums},
     * or {@code -1} if it is not present. Runs in O(log n).
     *
     * @param nums a non-empty array sorted in strictly ascending order
     * @param target the value to locate
     * @return the index of {@code target}, or {@code -1} if {@code nums} does not contain it
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int middle = start + (end - start)/2;
            if(nums[middle]  == target ) return middle;

            if(nums[middle] > target) end = middle - 1;

            else start = middle + 1;
        }

        return -1;
    }
}
