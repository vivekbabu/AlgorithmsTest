package in.algorithms.maximumdifference;

public class MaximumDifference {
    public static int maxDiff(int[] arr) {
        int minElement = arr[0];
        int maxDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - minElement > maxDiff) {
                maxDiff = arr[i] - minElement;
            }
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println("Max difference: " + maxDiff(arr));
    }
}
