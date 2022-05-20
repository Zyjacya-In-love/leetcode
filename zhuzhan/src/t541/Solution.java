package t541;

/**
 * 541. 反转字符串 II
 * https://leetcode.cn/problems/reverse-string-ii/
 * @author xzq
 * @create 2022-05-19-16:43
 */
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i+=2*k) {
            int left = i;
            int right = Math.min(i+k-1, s.length()-1);
//            int right = i+k-1;
//            if (right >= s.length()) {
//                right = s.length()-1;
//            }
            reverse(chars, left, right);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
// 通过   1 ms	41.4 MB
