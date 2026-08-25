package in.algorithms.interviewprep.validsudoku;

import java.util.HashSet;
import java.util.Set;

// LeetCode 36: Valid Sudoku - https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for(int i=0; i < 9;i++) {
            for(int j=0; j < 9; j++) {

                Character val = board[i][j];
                if(val == '.') continue;

                int box = (i/3) * 3 + (j/3);

                if(rows[i].contains(val) || cols[j].contains(val)|| boxes[box].contains(val)) return false;

                rows[i].add(val);
                cols[j].add(val);
                boxes[box].add(val);
           }
        }

        return true;


    }
}
