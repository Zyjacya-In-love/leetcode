package lcof63;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @author xzq
 * @create 2022-03-13-10:51
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            ans = Math.max(ans, price-minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return ans;
    }
}
