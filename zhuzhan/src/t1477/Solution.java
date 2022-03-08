package t1477;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * https://leetcode-cn.com/problems/simplified-fractions/
 * @author xzq
 * @create 2022-03-08-10:20
 */
class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) { // 分子
            for (int j = i+1; j <= n; j++) { // 分母
                if (gcd(i, j) != 1) continue;
                String tmp = String.valueOf(i) + "/" + String.valueOf(j);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
