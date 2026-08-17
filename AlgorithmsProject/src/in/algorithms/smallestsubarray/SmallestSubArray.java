package in.algorithms.smallestsubarray;

public class SmallestSubArray {
    public static int smallestSubWithSum(int[] arr, int n, int x) {
        int currSum = 0, minLen = n + 1;
        int start = 0, end = 0;

        while (end < n) {
            while (currSum <= x && end < n) {
                currSum += arr[end++];
            }
            while (currSum > x && start < n) {
                if (end - start < minLen) minLen = end - start;
                currSum -= arr[start++];
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        System.out.println("Smallest subarray length: " + smallestSubWithSum(arr, arr.length, 51));
    }
}
