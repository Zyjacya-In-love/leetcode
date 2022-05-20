package lcof05;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author xzq
 * @create 2022-03-08-8:40
 */
//class Solution {
//    public String replaceSpace(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
//}
/*
 * @create 2022-05-19-19:08
 */
class Solution {
    public String replaceSpace(String s) {
        int blankCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                blankCnt++;
            }
        }
        char[] ans = new char[s.length()+2*blankCnt];
        int index = ans.length-1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                ans[index--] = '0';
                ans[index--] = '2';
                ans[index--] = '%';
            } else {
                ans[index--] = s.charAt(i);
            }
        }
        return new String(ans);
    }
}
// 通过   0 ms	39.6 MB

