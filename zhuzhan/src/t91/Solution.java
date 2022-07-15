package t91;

import java.util.Arrays;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author xzq
 * @create 2022-04-25-9:08
 */
//class Solution {
//    public int numDecodings(String s) {
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        int n = s.length();
//        int[] dp = new int[n+1];
//        dp[0] = dp[1]= 1;
//        for (int i = 2; i <= n; i++) {
//            if (s.charAt(i-1) != '0') {
//                dp[i] += dp[i-1];
//            }
//            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6'))) {
//                dp[i] += dp[i-2];
//            }
//        }
//        return dp[n];
//    }
//}


/*
 * @create 2022-07-15-22:17
 */
// 定义：dp[i] 表示 s[0:i] 子串 解码 方法的 总数
// 状态转移方程：dp[i] += dp[i-1]  '9' >= s[i] >= '1'
//              dp[i] += dp[i-2]  s[i-1] == '1' || (s[i-1] == '2' && '6' >= s[i] >= '0')
// 初始化：一个字符只有一种解码方式 s[0] != '0' -> dp[0] = 1，
//         两个字符， ① '9' >= s[1] >= '1' dp[1]+=dp[0]
//                   ② s[0] == '1' || (s[0] == '2' && '6' >= s[1] >= '0') dp[1]+=1
// 遍历顺序：dp[i] 更新依赖于前两个元素，所有 正序 s
//class Solution {
//    public int numDecodings(String s) {
//        int n = s.length();
//        int[] dp = new int[n];
//        if (s.charAt(0) != '0') {
//            dp[0] = 1;
//        }
//        if (s.length() == 1) { // 错 1. 次：这个算法要求 s 的长度必须大于等于2，只有一个字符会出错 eg："0"
//            return dp[0];
//        }
//        if (s.charAt(1) != '0') {
//            dp[1] += dp[0];
//        }
//        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) {
//            dp[1]++;
//        }
//        for (int i = 2; i < n; i++) {
//            if (s.charAt(i) != '0') {
//                dp[i] += dp[i-1];
//            }
//            if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
//                dp[i] += dp[i-2];
//            }
//        }
//        return dp[n-1];
//    }
//}
// 通过   0 ms	40.2 MB

// 写的太差了，改改
// 定义：dp[i] 表示 s[0:i-1] 子串 解码 方法的 总数，dp[0] 表示 空串
// 状态转移方程：dp[i] += dp[i-1]  s[i-1] != '0'
//              dp[i] += dp[i-2]  s[i-2] == '1' || (s[i-2] == '2' && '6' >= s[i-1] >= '0')
// 初始化：空串有一种解码方式 dp[0] = 1，一个字符有可能有一种解码方式 s[0] != '0' -> dp[1] = 1，
// 遍历顺序：dp[i] 更新依赖于前两个元素，所有 正序 s
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
// 通过   0 ms	39.9 MB