package lcof2019;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * https://leetcode-cn.com/problems/RQku0D/
 * @author xzq
 * @create 2022-03-08-9:27
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        boolean del1 = false;
        boolean res1 = true, res2 = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
//                System.out.println("left : " + left + " " + s.charAt(left) + " right : " + right + " " + s.charAt(right));
                if (del1) {
                    res1 = false;
                    break;
                } else {
                    if (s.charAt(left+1) == s.charAt(right)) {
                        left++;
                    } else if (s.charAt(left) == s.charAt(right-1)) {
                        right--;
                    } else {
                        return false;
                    }
                    del1 = true;
                }
            }
            left++;
            right--;
        }
        left = 0;
        right = s.length()-1;
        del1 = false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
//                System.out.println("left : " + left + " " + s.charAt(left) + " right : " + right + " " + s.charAt(right));
                if (del1) {
                    res2 = false;
                    break;
                } else {
                    if (s.charAt(left) == s.charAt(right-1)) {
                        right--;
                    } else if (s.charAt(left+1) == s.charAt(right)) {
                        left++;
                    } else {
                        return false;
                    }
                    del1 = true;
                }
            }
            left++;
            right--;
        }
        return res1 || res2;
    }
}
