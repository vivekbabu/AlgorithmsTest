package in.algorithms.nqeens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static List<List<Integer>> queens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        placeQueens(0, n, new ArrayList<>(), result);
        return result;
    }

    private static void placeQueens(int k, int n, List<Integer> current, List<List<Integer>> result) {
        if (k == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(col, current)) {
                current.add(col);
                placeQueens(k + 1, n, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isSafe(int col, List<Integer> queens) {
        int row = queens.size();
        for (int r = 0; r < row; r++) {
            int c = queens.get(r);
            if (c == col || Math.abs(c - col) == (row - r)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> solutions4 = queens(4);
        System.out.println("4-Queens solutions: " + solutions4.size());
        List<List<Integer>> solutions8 = queens(8);
        System.out.println("8-Queens solutions: " + solutions8.size());
    }
}
