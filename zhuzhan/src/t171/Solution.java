package t171;

/**
 * @title 171. Excel 表列序号
 * @link https://leetcode.cn/problems/excel-sheet-column-number/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-26-23:36
 */
// 每进一位相当于 26 倍
// 遍历字符串，每次乘 26，加上下一位
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans *= 26;
            ans += columnTitle.charAt(i)-'A'+1;
        }
        return ans;
    }
}
// 通过   0 ms	39.8 MB