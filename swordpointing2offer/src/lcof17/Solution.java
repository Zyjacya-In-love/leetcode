package lcof17;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author xzq
 * @create 2022-04-04-19:25
 */
// 面试 要求 大数
//class Solution {
//    public int[] printNumbers(int n) {
//        int len = (int) (Math.pow(10, n)) - 1;
//        int[] ans = new int[len];
//        for (int i = 1; i <= len; i++) {
//            ans[i-1] = i;
//        }
//        return ans;
//    }
//}
class Solution {
    private int n;
    private int count = 0;
    private char[] num;
    private int start;
    private int nineNum = 0;
    private int[] res;
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        start = n-1;
        res = new int[(int) Math.pow(10, n) - 1];
        dfs(0);
        return res;
    }
    private void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                res[count++] = Integer.parseInt(s);
            }
            if (nineNum == n-start) {
                start--;
            }
            return;
        }
        for (int i = 0; i <= 9; ++i) {
            if (i == 9) nineNum++;
            num[x] = (char) (i+'0');
            dfs(x+1);
        }
        nineNum--;
    }
}