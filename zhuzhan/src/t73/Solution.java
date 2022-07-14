package t73;

import java.util.HashSet;

/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/
 * @author xzq
 * @create 2022-07-14-18:35
 */
// 遍历一遍矩阵，把 0 位置的行列用 HashSet 记录下来，然后把 行列 HashSet 对应的行列都置为 0
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int r : rowSet) {
            for (int j = 0; j < n; j++) {
                matrix[r][j] = 0;
            }
        }
        for (int c : colSet) {
            for (int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
// 通过   1 ms	43.2 MB