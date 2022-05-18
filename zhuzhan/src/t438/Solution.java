package t438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author xzq
 * @create 2022-04-28-12:26
 */
//class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//        int n = s.length();
//        int m = p.length();
//        if (m > n) return new ArrayList<>();
//        int[] cnt = new int[30];
//        for (int i = 0; i < m; i++) {
//            cnt[p.charAt(i)-'a']--;
//        }
//        int left = 0, right = 0;
//        List<Integer> ans = new ArrayList<>();
//        while (right < n) {
//            int now = s.charAt(right)-'a';
//            cnt[now]++;
//            while (cnt[now] > 0) {
//                cnt[s.charAt(left)-'a']--;
//                left++;
//            }
//            if (right-left+1 == m) {
//                ans.add(left);
//            }
//            right++;
//        }
//        return ans;
//    }
//}
// 通过   4 ms	42.8 MB

/*
 * @create 2022-05-18-9:08
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] record = new int[30];
        int size = 0;
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i)-'a';
            if (record[index] == 0) {
                size++;
            }
            record[index]++;
        }
        int valid = 0;
        for (int i = 0; i < p.length() - 1; i++) {
            int index = s.charAt(i)-'a';
            record[index]--;
            if (record[index] == 0) {
                valid++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = p.length()-1;
        while (right < s.length()) {
            int index = s.charAt(right)-'a';
            record[index]--;
            if (record[index] == 0) {
                valid++;
            }
            if (valid == size) {
                ans.add(left);
            }
            index = s.charAt(left)-'a';
            if (record[index] == 0) {
                valid--;
            }
            record[index]++;
            left++;
            right++;
        }
        return ans;
    }
}
// 通过   7 ms	42.1 MB