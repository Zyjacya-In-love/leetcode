package t54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/
 * @author xzq
 * @create 2022-05-16-11:11
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int minLen = Math.min(m, n);
        int loop = minLen/2;
        int startX = 0;
        int startY = 0;
        int offset = 1;
        while (loop-- > 0) {
            int i = startX;
            int j = startY;
            for (; j < startY+n-offset; j++) {
                ans.add(matrix[i][j]);
            }
            for (; i < startX+m-offset; i++) {
                ans.add(matrix[i][j]);
            }
            for (; j > startY; j--) {
                ans.add(matrix[i][j]);
            }
            for (; i > startX; i--) {
                ans.add(matrix[i][j]);
            }
            startX++;
            startY++;
            offset += 2;
        }
        if ((minLen&1)==1) {
            for (int i = startX; i <= startX+m-offset; i++) {
                for (int j = startY; j <= startY+n-offset; j++) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}
// 通过   0 ms	39.3 MB