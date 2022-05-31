package t51;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode.cn/problems/n-queens/
 * @author xzq
 * @create 2022-05-31-10:05
 */
class Solution {

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<StringBuilder> chessboard = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            chessboard.add(new StringBuilder(sb));
        }
        backtrack(chessboard, 0);
        return res;
    }

    private void backtrack(List<StringBuilder> chessboard, int row) {
        if (row == chessboard.size()) {
            ArrayList<String> tmp = new ArrayList<>();
            for (StringBuilder rowSb : chessboard) {
                tmp.add(rowSb.toString());
            }
            res.add(tmp);
            return;
        }
        for (int col = 0; col < chessboard.size(); col++) {
            if (check(chessboard, row, col)) {
                chessboard.get(row).setCharAt(col, 'Q');
                backtrack(chessboard, row+1);
                chessboard.get(row).setCharAt(col, '.');
            }
        }
    }

    private boolean check(List<StringBuilder> chessboard, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessboard.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row-1, j = col+1; i >= 0 && j < chessboard.size(); i--, j++) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
// 通过   9 ms	41.4 MB