package t125;

/**
 * 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/
 * @author xzq
 * @create 2022-07-16-18:41
 */
// 先 s 变成 小写，然后左右指针 分别找 字母或数字 挨个比较，不等就返回 false
//class Solution {
//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase(); // 错 1. 次：当字符有大小写的时候不能只靠 s.charAt(l)-s.charAt(r) == 32 比较，eg："0P"
//        int l = 0, r = s.length()-1;
//        while (l < r) {
//            while (l < r && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))) {
//                l++;
//            }
//            while (l < r && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r))) {
//                r--;
//            }
//            if (l >= r) {
//                return true;
//            }
//            if (s.charAt(l) != s.charAt(r)) {
//                return false;
//            }
//            l++;
//            r--;
//        }
//        return true;
//    }
//}
// 通过   3 ms	41.6 MB

// 做的不得劲，写的四不像，纯用 java api 做一遍
// 把 digit 和 letter 拿出来组成一个新的字符串，将其反转与自身比较
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sGood = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sGood.append(Character.toLowerCase(s.charAt(i))); // 错 1. 次：忘记 转成一致的大小写了
            }
        }
        StringBuilder sGoodRev = new StringBuilder(sGood).reverse(); // StringBuilder 的 reverse() 是反转自身，然后把自身反返回
        return sGood.toString().equals(sGoodRev.toString());
    }
}
// 通过   4 ms	41.1 MB