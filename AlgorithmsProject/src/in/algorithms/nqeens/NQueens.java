package in.algorithms.nqeens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<Integer>> queens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        placeQueens(0, n, new ArrayList<>(), result);
        return result;
    }

    private static void placeQueens(int row, int n, List<Integer> current, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(col, current)) {
                current.add(col);
                placeQueens(row + 1, n, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isSafe(int col, List<Integer> queens) {
        int row = queens.size();
        for (int r = 0; r < row; r++) {
            int c = queens.get(r);
            if (c == col || Math.abs(c - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }
}
