package t37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author xzq
 * @create 2022-05-06-8:44
 */
//class Solution {
//    public void solveSudoku(char[][] board) {
//        solveSudoku(board, 0, 0);
//    }
//
//    private boolean solveSudoku(char[][] board, int i, int j) {
//        if (i == board.length) {
//            return true;
//        }
//        if (j == board[0].length) {
//            return solveSudoku(board, i+1, 0);
//        }
//        if (board[i][j] != '.') {
//            return solveSudoku(board, i, j+1);
//        }
//        for (int k = 1; k <= 9; k++) {
//            char now = (char) (k+'0');
//            if (isValid(board, i, j, now)) {
//                board[i][j] = now;
//                if (solveSudoku(board, i, j+1)) {
//                    return true;
//                }
//                board[i][j] = '.';
//            }
//        }
//        return false;
//    }
//
//    private boolean isValid(char[][] board, int i, int j, char now) {
//        for (int k = 0; k < 9; k++) {
//            if (board[i][k] == now) {
//                return false;
//            }
//            if (board[k][j] == now) {
//                return false;
//            }
//            if (board[(i/3)*3+k/3][(j/3)*3+k%3] == now) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
// 通过   9 ms	39.1 MB

/*
 * @create 2022-05-31-10:58
 */
//          太蠢了，调到 14:17 才发现，是因为 i++ 换下一行的时候 j 是从 startCol 开始的
//public class Solution {
//    public void solveSudoku(char[][] board) {
//        backtrack(board, 0, 0);
//    }
//
//    private boolean backtrack(char[][] board, int startRow, int startCol) {
////        if (startRow == 3 && startCol == 8) {
////            System.out.println("startRow startCol : " + startRow + " " + startCol);
////            System.out.println(Arrays.deepToString(board));
////        }
//        int j = startCol;
//        for (int i = startRow; i < board.length; i++) {
//            for (; j < board[0].length; j++) {
////                if (startRow == 3 && startCol == 8) {
////                    System.out.println("i j board[i][j] : " + i + " " + j + " " + board[i][j]);
////                }
//                if (board[i][j] == '.') {
//                    for (char k = '1'; k <= '9'; k++) {
//                        if (check(board, i, j, k)) {
//                            board[i][j] = k;
////                            System.out.println("modify i j k : " + i + " "+ j + " " + k );
//                            int nextCol = (j+1 < board[0].length ? j+1 : 0);
//                            int nextRow = (j+1 < board[0].length ? i : i+1);
//                            if (backtrack(board, nextRow, nextCol)) {
//                                return true;
//                            }
//                            board[i][j] = '.';
//                        }
//                    }
//                    return false;
//                }
//            }
//            j = 0;
//        }
//        return true;
//    }
//
//    private boolean check(char[][] board, int row, int col, char now) {
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][col] == now) {
//                return false;
//            }
//        }
//        for (int j = 0; j < board[0].length; j++) {
//            if (board[row][j] == now) {
//                return false;
//            }
//        }
//        int blockRow = (row/3)*3;
//        int blockCol = (col/3)*3;
//        for (int i = blockRow; i < blockRow+3; i++) {
//            for (int j = blockCol; j < blockCol+3; j++) {
//                if (board[i][j] == now) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
// 通过   7 ms	39.1 MB

// 参考 lc 官解 先把 point 都记录出来，并且 可用性判断的时候，用 bool数组判断
class Solution {

    private boolean[][] columnUsed;
    private boolean[][] rowUsed;
    private boolean[][] blockUsed;
    private List<int[]> points;

    public void solveSudoku(char[][] board) {
        rowUsed = new boolean[board.length][10];
        columnUsed = new boolean[board[0].length][10];
        blockUsed = new boolean[9][10];
        points = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    points.add(new int[]{i, j});
                } else {
                    int digit = board[i][j]-'0';
                    rowUsed[i][digit] = true;
                    columnUsed[j][digit] = true;
                    blockUsed[getBlock(i, j)][digit] = true;
                }
            }
        }
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int nowPointIndex) {
        if (nowPointIndex == points.size()) {
            return true;
        }
        int row = points.get(nowPointIndex)[0];
        int column = points.get(nowPointIndex)[1];
        for (int digit = 1; digit <= 9; digit++) {
            if (!rowUsed[row][digit] && !columnUsed[column][digit] && !blockUsed[getBlock(row, column)][digit]) {
                rowUsed[row][digit] = columnUsed[column][digit] = blockUsed[getBlock(row, column)][digit] = true;
                board[row][column] = (char) (digit+'0');
                if (backtrack(board, nowPointIndex+1)) {
                    return true;
                }
                board[row][column] = '.';
                rowUsed[row][digit] = columnUsed[column][digit] = blockUsed[getBlock(row, column)][digit] = false;
            }
        }
        return false;
    }

    private int getBlock(int i, int j) {
        return (i/3)*3+(j/3);
    }
}
// 通过   2 ms	38.8 MB