package t66;

import java.util.ArrayList;
import java.util.List;

/**
 * 66. 加一
 * https://leetcode.cn/problems/plus-one/
 * @author xzq
 * @create 2022-07-14-18:19
 */
// 模拟加法
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length-1; i >= 0 ; i--) {
            int now = digits[i]+carry;
            res.add(now%10);
            carry = now/10;
        }
        if (carry > 0) {
            res.add(carry);
        }
        int[] ans = new int[res.size()];
        for (int i = res.size()-1; i >= 0; i--) {
            ans[res.size()-1-i] = res.get(i);
        }
        return ans;
    }
}
// 通过   0 ms	40.1 MB