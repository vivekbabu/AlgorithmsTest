package in.algorithms.interviewprep.searchinsertposition;

// LeetCode 35: Search Insert Position - https://leetcode.com/problems/search-insert-position/description/
//
// Given a sorted array of distinct integers and a target value, return the index if the target is
// found. If not, return the index where it would be if it were inserted in order.
//
// You must write an algorithm with O(log n) runtime complexity.
//
// Constraints:
//   - 1 <= nums.length <= 10^4
//   - -10^4 <= nums[i] <= 10^4
//   - nums contains distinct values sorted in ascending order.
//   - -10^4 <= target <= 10^4
public class SearchInsertPosition {

    /**
     * Returns the index of {@code target} in the ascending, duplicate-free array {@code nums}, or
     * — if {@code target} is absent — the index at which it would be inserted to keep {@code nums}
     * sorted (equivalently, the count of elements strictly less than {@code target}). Runs in
     * O(log n).
     *
     * @param nums a non-empty array of distinct integers sorted in ascending order
     * @param target the value to locate or place
     * @return an index in the range {@code [0, nums.length]}
     */
    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int middle = start + (end - start) / 2;
            if(nums[middle] == target) return middle;

            if(nums[middle] > target) end = middle -1;
            else start = middle + 1;
        }

        return start;

    }
}
