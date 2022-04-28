package t76;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author xzq
 * @create 2022-04-28-9:17
 */
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE, start = -1;
        while (right < s.length()) {
            char addChar = s.charAt(right);
            if (need.containsKey(addChar)) {
                window.put(addChar, window.getOrDefault(addChar, 0) + 1);
                if (window.get(addChar).equals(need.get(addChar))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right-left+1 < len) {
                    len = right-left+1;
                    start = left;
                }
                char delChar = s.charAt(left);
                if (window.containsKey(delChar)) {
                    if (window.get(delChar).equals(need.get(delChar))) {
                        valid--;
                    }
                    window.put(delChar, window.get(delChar) - 1);
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}

// 问题：256 特别长的样例没过
// 原因：java中的包装类型Integer缓存了-128~127之间的包装对象，如果在这个范围类因为是同一个对象所以==和equals效果一致，过了这个范围就只能equals
// from：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/1482194