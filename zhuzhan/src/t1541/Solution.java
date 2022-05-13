package t1541;

/**
 * 1541. 平衡括号字符串的最少插入次数
 * https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
 * @author xzq
 * @create 2022-05-13-15:40
 */
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance += 2;
                if ((balance&1)==1) {
                    balance--;
                    ans++;
                }
            } else {
                balance -= 1;
                if (balance < 0) {
                    ans++;
                    balance = 1;
                }
            }
        }
        return ans+balance;
    }
}
// 通过   12 ms	42.1 MB