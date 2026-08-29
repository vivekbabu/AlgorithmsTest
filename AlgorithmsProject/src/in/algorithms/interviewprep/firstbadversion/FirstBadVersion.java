package in.algorithms.interviewprep.firstbadversion;

// LeetCode 278: First Bad Version - https://leetcode.com/problems/first-bad-version/description/
//
// You are a product manager and currently leading a team to develop a new product. Unfortunately,
// the latest version of your product fails the quality check. Since each version is developed
// based on the previous version, all the versions after a bad version are also bad.
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which
// causes all the following ones to be bad. You are given an API bool isBadVersion(version) which
// returns whether version is bad. Implement a function to find the first bad version. You should
// minimize the number of calls to the API.
//
// Constraints:
//   - 1 <= bad <= n <= 2^31 - 1
public class FirstBadVersion {

    /**
     * The {@code bool isBadVersion(int version)} API described in the problem. On LeetCode this is
     * provided by the judge; here it is passed in so the algorithm can be exercised in isolation.
     */
    public interface VersionControl {
        boolean isBadVersion(int version);
    }

    /**
     * Returns the smallest version number in {@code [1, n]} for which
     * {@code versionControl.isBadVersion} returns {@code true}, given that badness is monotonic
     * (once a version is bad, every later version is bad too). Makes O(log n) API calls.
     *
     * @param n the highest version number; there is at least one bad version in {@code [1, n]}
     * @param versionControl the bad-version oracle
     * @return the first bad version
     */
    public static int firstBadVersion(int n, VersionControl versionControl) {

        int left = 1;
        int right = n;

        while(left < right) {

            int mid = left + (right - left)/2;

            if(versionControl.isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
