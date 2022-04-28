package t567;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * @author xzq
 * @create 2022-04-28-10:33
 */
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) return false;
//        char[] s1Array = s1.toCharArray();
//        char[] s2Array = s2.toCharArray();
//        HashMap<Character, Integer> need = new HashMap<>();
//        for (char c : s1Array) {
//            need.put(c, need.getOrDefault(c, 0)+1);
//        }
//        int left = 0, right = 0;
//        HashMap<Character, Integer> window = new HashMap<>();
//        int valid = 0;
//        for (; right < s1Array.length-1; right++) {
//            char addChar = s2Array[right];
//            if (need.containsKey(addChar)) {
//                window.put(addChar, window.getOrDefault(addChar, 0)+1);
//                if (window.get(addChar).equals(need.get(addChar))) {
//                    valid++;
//                }
//            }
//        }
//        while (right < s2Array.length) {
//            char addChar = s2Array[right];
//            if (need.containsKey(addChar)) {
//                window.put(addChar, window.getOrDefault(addChar, 0)+1);
//                if (window.get(addChar).equals(need.get(addChar))) {
//                    valid++;
//                }
//            }
//            if (valid == need.size()) {
//                return true;
//            }
//            char delChar = s2Array[left];
//            if (need.containsKey(delChar)) {
//                if (window.get(delChar).equals(need.get(delChar))) {
//                    valid--;
//                }
//                window.put(delChar, window.get(delChar)-1);
//            }
//            left++;
//            right++;
//        }
//        return false;
//    }
//}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        int[] cnt = new int[30];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i)-'a']--;
        }
        int left = 0, right = 0;
        while (right < m) {
            int now = s2.charAt(right)-'a';
            cnt[now]++;
            while (cnt[now] > 0) {
                cnt[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == n) {
                return true;
            }
            right++;
        }
        return false;
    }
}