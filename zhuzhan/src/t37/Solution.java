package t37;

import java.util.Arrays;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author xzq
 * @create 2022-05-06-8:44
 */
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        if (i == board.length) {
            return true;
        }
        if (j == board[0].length) {
            return solveSudoku(board, i+1, 0);
        }
        if (board[i][j] != '.') {
            return solveSudoku(board, i, j+1);
        }
        for (int k = 1; k <= 9; k++) {
            char now = (char) (k+'0');
            if (isValid(board, i, j, now)) {
                board[i][j] = now;
                if (solveSudoku(board, i, j+1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char now) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == now) {
                return false;
            }
            if (board[k][j] == now) {
                return false;
            }
            if (board[(i/3)*3+k/3][(j/3)*3+k%3] == now) {
                return false;
            }
        }
        return true;
    }
}
// 通过   9 ms	39.1 MB