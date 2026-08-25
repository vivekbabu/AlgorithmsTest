package in.algorithms.interviewprep.validsudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ValidSudokuTest {

    private static char[][] emptyBoard() {
        char[][] board = new char[9][9];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        return board;
    }

    @Test
    public void testProblemStatementExampleOneValidBoard() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testProblemStatementExampleTwoInvalidBoard() {
        // Same board as example one, but the top-left cell is changed from '5' to '8',
        // creating a duplicate '8' in both column 0 and the top-left 3x3 box.
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testEmptyBoardIsValid() {
        Assert.assertTrue(ValidSudoku.isValidSudoku(emptyBoard()));
    }

    @Test
    public void testSingleFilledCellIsValid() {
        char[][] board = emptyBoard();
        board[4][4] = '9';
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInRowIsInvalid() {
        char[][] board = emptyBoard();
        board[0][0] = '5';
        board[0][1] = '5';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInColumnIsInvalid() {
        char[][] board = emptyBoard();
        board[0][0] = '5';
        board[1][0] = '5';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInBoxIsInvalidEvenWithDifferentRowAndColumn() {
        // (0,0) and (2,2) share no row or column, but both fall in the top-left 3x3 box.
        char[][] board = emptyBoard();
        board[0][0] = '5';
        board[2][2] = '5';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testSameDigitRepeatedInDifferentRowsColumnsAndBoxesIsValid() {
        // '5' appears three times, but each occurrence is in a distinct row, column, and box.
        char[][] board = emptyBoard();
        board[0][0] = '5';
        board[3][3] = '5';
        board[6][6] = '5';
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInLastRowIsDetected() {
        char[][] board = emptyBoard();
        board[8][0] = '1';
        board[8][8] = '1';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInLastColumnIsDetected() {
        char[][] board = emptyBoard();
        board[0][8] = '1';
        board[8][8] = '1';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDuplicateInBottomRightBoxIsDetected() {
        // (6,6) and (8,8) share no row or column, but both fall in the bottom-right 3x3 box.
        char[][] board = emptyBoard();
        board[6][6] = '1';
        board[8][8] = '1';
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testFullyValidCompleteSudokuSolution() {
        char[][] board = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testFullBoardWithSingleRowDuplicateIsInvalid() {
        // Same complete solution as above, but the last cell of row 0 is changed from '2' to '1',
        // duplicating the '1' already present at row 0, column 7.
        char[][] board = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '1'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        Assert.assertFalse(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testRowWithAllNineDigitsAndNoEmptyCellsIsValid() {
        char[][] board = emptyBoard();
        char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int c = 0; c < 9; c++) {
            board[0][c] = digits[c];
        }
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }

    @Test
    public void testDoesNotMistakeEmptyCellDotsForDuplicateValues() {
        // Many '.' cells share no row/column/box exemption logic issue - '.' must never be
        // compared against itself as if it were a real duplicate digit.
        char[][] board = emptyBoard(); // entirely dots
        board[0][0] = '1';
        Assert.assertTrue(ValidSudoku.isValidSudoku(board));
    }
}
