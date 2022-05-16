package t59;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * @author xzq
 * @create 2022-05-16-10:59
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int loop = n/2;
        int mid = n/2;
        int offset = 1;
        int cnt = 1;
        int[][] ans = new int[n][n];
        while (loop-- > 0) {
            int i = startX;
            int j = startY;
            for (; j < startY+n-offset; j++) {
                ans[i][j] = cnt++;
            }
            for (; i < startX+n-offset; i++) {
                ans[i][j] = cnt++;
            }
            for (; j > startY; j--) {
                ans[i][j] = cnt++;
            }
            for (; i > startX; i--) {
                ans[i][j] = cnt++;
            }
            startX++;
            startY++;
            offset += 2;
        }
        if ((n&1)==1) {
            ans[mid][mid] = cnt;
        }
        return ans;
    }
}
// 通过   0 ms	39.2 MB