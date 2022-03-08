package t1380;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. 矩阵中的幸运数
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @author xzq
 * @create 2022-03-08-10:19
 */
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int rawMin = matrix[i][0];
            int rawMinColIdx = 0;
            for (int j = 1; j < n; j++) {
                if (rawMin > matrix[i][j]) {
                    rawMin = matrix[i][j];
                    rawMinColIdx = j;
                }
            }
            int colMax = matrix[0][rawMinColIdx];
            for (int j = 1; j < m; j++) {
                colMax = Math.max(colMax, matrix[j][rawMinColIdx]);
            }
            if (rawMin == colMax) {
                ans.add(rawMin);
            }
        }
        return ans;
    }
}
