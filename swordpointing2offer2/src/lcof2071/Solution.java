package lcof2071;

import java.util.Random;

/**
 * 剑指 Offer II 071. 按权重生成随机数
 * https://leetcode-cn.com/problems/cuyjEf/
 * @author xzq
 * @create 2022-03-08-9:56
 */
class Solution {
    private int[] sum;
    private int n;
    private int range;
    private Random r;

    public Solution(int[] w) {
        n = w.length;
        sum = new int[n];
        sum[0] = w[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + w[i];
        }
        range = sum[n-1];
        r = new Random();
    }

    public int pickIndex() {
        int num = r.nextInt(range)+1;
        int s = 0, t = n;
        while (s < t) {
            int m = (s+t)>>1;
            if (sum[m] >= num) t = m;
            else s = m+1;
        }
        return s;
    }
}
