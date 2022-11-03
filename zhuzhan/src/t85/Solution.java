package t85;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @title 85. 最大矩形
 * @link https://leetcode.cn/problems/maximal-rectangle/description/
 * @from huawei9.28 nongyan11.3
 * @author xzq
 * @create 2022-11-03-11:00
 */
class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] heights = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (mat[i-1][j-1] != '0') {
                    heights[i][j] = heights[i-1][j]+1;
                }
            }
        }
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            int[] left = new int[n+1];
            int[] right = new int[n+1];
            stack.clear();
            for (int j = 1; j <= n; j++) {
                while (!stack.isEmpty() && heights[i][stack.peek()] >= heights[i][j]) {
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? 1 : stack.peek()+1;
                stack.push(j);
            }
            stack.clear();
            for (int j = n; j >= 1; j--) {
                while (!stack.isEmpty() && heights[i][stack.peek()] >= heights[i][j]) {
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? n : stack.peek()-1;
                stack.push(j);
            }
            for (int j = 1; j <= n; j++) {
                int w = right[j]-left[j]+1;
                int h = heights[i][j];
                int areaSum = w*h;
                res = Math.max(res, areaSum);
            }
        }
        return res;
    }
}