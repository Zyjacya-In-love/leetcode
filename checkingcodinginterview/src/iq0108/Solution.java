package iq0108;

import java.util.HashSet;

/**
 * 面试题 01.08. 零矩阵
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * @author xzq
 * @create 2022-04-13-14:52
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int r : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[r][j] = 0;
            }
        }
        for (int c : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}