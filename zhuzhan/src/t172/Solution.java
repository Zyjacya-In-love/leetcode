package t172;

/**
 * @title 172. 阶乘后的零
 * @link https://leetcode.cn/problems/factorial-trailing-zeroes/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-26-23:51
 */
// O(nlogn)：从 2 到 n 遍历每个数 2 和 5 的数量，因为所有的 0 本质都是 2*5 得来的，所以最后 返回 min(cnt2, cnt5)
// 统计一个数中 2 的数量，需要 logn 的时间
class Solution {
    public int trailingZeroes(int n) {
        int cnt2 = 0, cnt5 = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = i;
            while (tmp%2 == 0) {
                cnt2 += 1; // 错 1. 次：一个数 里面有多少个 2，不是 /2 可以获得的
                tmp /= 2;
            }
            tmp = i;
            while (tmp%5 == 0) {
                cnt5 += 1;
                tmp /= 5;
            }
        }
        return Math.min(cnt2, cnt5);
    }
}
// 通过   19 ms	38.5 MB
