package lcof48;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @author xzq
 * @create 2022-03-15-22:32
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIdx = new HashMap<>(s.length());
        int l = 0, r = 0;
        int ans = 0;
        while (r < s.length()) {
            char now = s.charAt(r);
            if (charIdx.containsKey(now) && (charIdx.get(now) >= l && charIdx.get(now) < r)) {
                l = charIdx.get(now)+1;
            } else {
                ans = Math.max(ans, r-l+1);
            }
            if (s.length()-l <= ans) {
                break;
            }
            charIdx.put(now, r);
            r++;
        }
        return ans;
    }
}
