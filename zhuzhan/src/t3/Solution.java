package t3;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author xzq
 * @create 2022-04-25-11:06
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIdx = new HashMap<>();
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            char now = s.charAt(right);
            if (charIdx.containsKey(now) && charIdx.get(now) >= left) {
                left = charIdx.get(now)+1;
            }
            charIdx.put(s.charAt(right), right);
            right++;
            ans = Math.max(ans, right-left);
        }
        return ans;
    }
}

