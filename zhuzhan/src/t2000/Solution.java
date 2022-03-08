package t2000;

/**
 * 2000. 反转单词前缀
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 * @author xzq
 * @create 2022-03-08-10:20
 */
class Solution {
    public String reversePrefix(String word, char ch) {
        int pos = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                pos = i;
                break;
            }
        }
        String ans = new StringBuffer(word.substring(0, pos+1)).reverse().toString() + word.substring(pos+1);
        return ans;
    }
}
