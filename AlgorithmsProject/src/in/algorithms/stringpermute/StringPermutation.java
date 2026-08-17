package in.algorithms.stringpermute;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public List<String> permute(char[] a, int l, int r) {
        List<String> result = new ArrayList<>();
        permuteHelper(a, l, r, result);
        return result;
    }

    private void permuteHelper(char[] a, int l, int r, List<String> result) {
        if (l == r) {
            result.add(new String(a));
        } else {
            for (int i = l; i <= r; i++) {
                swap(a, l, i);
                permuteHelper(a, l + 1, r, result);
                swap(a, l, i);
            }
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
