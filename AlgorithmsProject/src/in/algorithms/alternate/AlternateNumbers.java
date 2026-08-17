package in.algorithms.alternate;

import java.util.Arrays;

public class AlternateNumbers {
    public void alternateTheNumbers(Integer[] arr) {
        if (arr == null || arr.length <= 1) return;
        // Partition negatives and positives
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int pos = i + 1;
        int neg = 0;
        while (pos < arr.length && neg < pos && arr[neg] < 0) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }
}
