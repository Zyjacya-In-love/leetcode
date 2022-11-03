package t36;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/
 * @author xzq
 * @create 2022-07-13-16:42
 */
// 循环 9 次，每次检查对应的一行、一列、一块
// 行、列、块 分别用长度为 9 的数组记录，如果发现重复元素，返回 false
// 都成功检测，返回 true
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkColumn(board, i)) {
                return false;
            }
            if (!checkBlock(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBlock(char[][] board, int block) {
        boolean[] valid = new boolean[10];
        int row = (block/3)*3;
        int col = (block%3)*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = row+i;
                int y = col+j;
                if (board[x][y] == '.') continue;
                if (valid[board[x][y]-'0']) {
                    return false;
                }
                valid[board[x][y]-'0'] = true;
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int column) {
        boolean[] valid = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == '.') continue;
            if (valid[board[i][column]-'0']) {
                return false;
            }
            valid[board[i][column]-'0'] = true;
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        boolean[] valid = new boolean[10];
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == '.') continue;
            if (valid[board[row][j]-'0']) {
                return false;
            }
            valid[board[row][j]-'0'] = true; // 失误 1. 次：忘记 -'0' 了，导致 IndexOutOfBound
        }
        return true;
    }
}
// 通过   1 ms	41.3 MB