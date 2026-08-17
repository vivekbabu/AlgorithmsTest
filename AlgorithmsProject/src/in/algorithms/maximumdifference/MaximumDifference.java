package in.algorithms.maximumdifference;

public class MaximumDifference {
    public static int maxDiff(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int minElem = arr[0];
        int maxDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - minElem > maxDiff) {
                maxDiff = arr[i] - minElem;
            }
            if (arr[i] < minElem) {
                minElem = arr[i];
            }
        }
        return maxDiff;
    }
}
