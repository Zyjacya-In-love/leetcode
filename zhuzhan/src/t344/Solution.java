package t344;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 * @author xzq
 * @create 2022-05-13-9:25
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
// 通过   0 ms	47.9 MB