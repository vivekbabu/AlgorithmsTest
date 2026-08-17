package in.algorithms.kmpalgorithm;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    public static List<Integer> search(String pat, String txt) {
        List<Integer> matches = new ArrayList<>();
        if (pat == null || txt == null || pat.isEmpty() || txt.isEmpty()) return matches;
        int M = pat.length();
        int N = txt.length();
        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                matches.add(i - j);
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return matches;
    }

    public static int[] computeLPSArray(String pat) {
        int len = 0;
        int i = 1;
        int M = pat.length();
        int[] lps = new int[M];
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
