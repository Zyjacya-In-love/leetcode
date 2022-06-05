package t135;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * https://leetcode.cn/problems/candy/
 * @author xzq
 * @create 2022-06-05-12:55
 */
// 贪心：先从左往右，将每一个右边大于左边的情况 都置成 左边的值+1，
//      再从右往左，将每一个左边大于右边的情况，将 当前值和右边值+1 比较取较大者
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1); // 错一次：比较取较大者
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
// 通过   2 ms	41.8 MB