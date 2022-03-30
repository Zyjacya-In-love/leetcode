package lcof29;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @author xzq
 * @create 2022-03-30-19:49
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new int[0];
        }
        int m = matrix[0].length;
        if (m == 0) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        int lenRow = n-1;
        int lenCol = m-1;
        for (int i = 0; i < (Math.min(n, m) + 1) / 2; i++) {
            for (int j = i; j <= lenCol; j++) {
                ans.add(matrix[i][j]);
            }
            for (int j = i+1; j < lenRow; j++) {
                ans.add(matrix[j][lenCol]);
            }
            if (lenRow-i > 0) {
                for (int j = lenCol; j >= i; j--) {
                    ans.add(matrix[lenRow][j]);
                }
            }
            if (lenCol-i > 0) {
                for (int j = lenRow-1; j > i; j--) {
                    ans.add(matrix[j][i]);
                }
            }
            lenRow -= 1;
            lenCol -= 1;
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}