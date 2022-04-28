package t438;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author xzq
 * @create 2022-04-28-12:26
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) return new ArrayList<>();
        int[] cnt = new int[30];
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i)-'a']--;
        }
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < n) {
            int now = s.charAt(right)-'a';
            cnt[now]++;
            while (cnt[now] > 0) {
                cnt[s.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == m) {
                ans.add(left);
            }
            right++;
        }
        return ans;
    }
}