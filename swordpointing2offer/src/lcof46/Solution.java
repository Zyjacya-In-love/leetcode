package lcof46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @author xzq
 * @create 2022-03-15-21:57
 */
public class Solution {
    public int translateNum(int num) {
        if (num < 10) return 1;
        List<Integer> nums = new ArrayList<>();
        while (num > 0) {
            int now = num%10;
            nums.add(now);
            num /= 10;
        }
        int[] dp = new int[nums.size()+1];
        dp[0] = dp[1] = 1;
        Collections.reverse(nums);
        for (int i = 1; i < nums.size(); i++) {
            dp[i+1] = dp[i] + ((nums.get(i-1) != 0 && nums.get(i-1)*10+nums.get(i) <= 25) ? dp[i-1] : 0);
        }
        return dp[nums.size()];
    }
}
