package lcof58.t2;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author xzq
 * @create 2022-03-08-8:55
 */
//class Solution {
//    public String reverseLeftWords(String s, int n) {
//        return s.substring(n, s.length()) + s.substring(0, n);
//    }
//}

/*
 * @create 2022-05-20-17:10
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n-1);
        reverse(chars, n, s.length()-1);
        reverse(chars, 0, s.length()-1);
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
// 通过   1 ms	41.1 MB