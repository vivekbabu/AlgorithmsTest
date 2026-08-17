package in.algorithms.replacewithsumuptothatpoint;

public class SumUptoThePoint {
    public static int[] prefixSum(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            res[i] = sum;
        }
        return res;
    }
}
