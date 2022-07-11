package t8;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode.cn/problems/string-to-integer-atoi/
 * @author xzq
 * @create 2022-07-11-19:20
 */
// 按题意模拟：
// ① 用 trim 去掉前导 空格
// ② 读取 正负号，设置标记位 flag
// ③ while 读取下一个字符，直到到达第一个非数字或者达到结尾
// ④ ans = ans*10 + now
// ⑤ 在 while 种判断 是否超范围，按照正负区分返回结果
// ⑥ 返回 flag*ans
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        int i = 0;
        int flag = 1;
        if (s.startsWith("-")) {
            i++;
            flag = -1;
        } else if (s.startsWith("+")) {
            i++;
        }
        int ans = 0;
        int maxDiv10 = Integer.MAX_VALUE/10;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int tmp = s.charAt(i)-'0';
            if (ans > maxDiv10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (ans == maxDiv10) {
                if (flag == 1 &&  tmp > 7) {
                    return Integer.MAX_VALUE;
                } else if (flag == -1 &&  tmp > 8) {
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans*10 + (tmp);
            i++;
        }
        return flag*ans;
    }
}
// 通过   1 ms	41.2 MB