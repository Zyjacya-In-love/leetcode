package t48;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/
 * @author xzq
 * @create 2022-07-13-17:18
 */
// 按行写 2 组后，观察法推出规律：[i,j] -> [j,n-1-i]
// 由于原地旋转，所以每次将循环结中 4 个位置旋转好，相当于每次旋转好一层，一共 n/2 层
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) { // 失误 2. 次：每层不是旋转到中间就可以了，除了本层的最后一个都要旋转。因为是按层旋转的，中间后面的在之后的层中不会被旋转，而最后一个和第一个在一个循环结里，所以不用再旋转了
                int last = matrix[i][j];
                int x = i;
                int y = j;
                for (int k = 0; k < 4; k++) {
                    int tmp = matrix[y][n-1-x];
                    matrix[y][n-1-x] = last;
                    last = tmp;
                    tmp = x; // 失误 1. 次：目的是交换 x,y，但是忘记保留 x 了，直接给 x 赋值 y
                    x = y;
                    y = n-1-tmp;
                }
            }
        }
    }
}
// 通过   0 ms	40.6 MB