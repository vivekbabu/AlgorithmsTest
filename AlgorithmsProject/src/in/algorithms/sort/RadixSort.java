import java.util.*;

class RadixSort {


    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }

    private static void radixsort(int[] arr, int n) {
        int max = getMax(arr, n);
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            countSort(arr, n, exp);
        }
    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[arr[i] / exp % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for(int j= n-1; j>=0;j--) {
            output[count[arr[j]/ exp % 10] - 1] = arr[j];
            count[arr[j]/ exp % 10] --;
        }

        for(int i=0;i < n; i++) {
            arr[i] = output[i];
        }

    }

    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
} 
