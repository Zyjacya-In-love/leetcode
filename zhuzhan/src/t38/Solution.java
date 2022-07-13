package t38;

/**
 * 38. 外观数列
 * https://leetcode.cn/problems/count-and-say/
 * @author xzq
 * @create 2022-07-13-17:06
 */
// 递归：
// 返回值以及参数：n 的描述，n
// 终止条件：n == 1 return "1"
// 单层操作：直接递归 n-1，对返回的 n-1 的字符串，顺序遍历字符串，计数相同的数字的部分，"计数"+"字符" 放进结果 StringBuilder
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char curr = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                sb.append(cnt).append(curr);
                curr = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt).append(curr);
        return sb.toString();
    }
}
// 通过   1 ms	39.1 MB