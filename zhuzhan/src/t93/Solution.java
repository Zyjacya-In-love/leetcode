package t93;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses/
 * @author xzq
 * @create 2022-05-29-20:20
 */
class Solution {
    private StringBuilder path;
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        path = new StringBuilder();
        res = new ArrayList<>();
        if (s.length() > 12) { // 长度超过 12 不可能是 IP
            return res;
        }
        backtrack(s, 0, 0);
        return res;
    }

    private void backtrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            String tmp4 = s.substring(startIndex, s.length());
            if (check(tmp4)) {
                int pathLength = path.length();
                path.append(tmp4);
                res.add(path.toString());
                path.setLength(pathLength);
            }
            return;
        }
        int pathLength = path.length();
        int endIndex = Math.min(startIndex+3, s.length()); // 错一次
        for (int i = startIndex+1; i <= endIndex; i++) {
            String tmp = s.substring(startIndex, i);
            if (check(tmp)) {
                path.append(tmp);
                path.append(".");
                backtrack(s, i, pointNum+1);
                path.setLength(pathLength);
            } else { // 当前不合法，之后肯定也不合法，这里只会出现前导零的不合法错误
                break;
            }
        }
    }

    private boolean check(String s) {
        if (s.isEmpty() || s.length() > 3) { // 错两次
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        // 判断是否有非数字字符
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        int sNum = Integer.parseInt(s);
        return sNum >= 0 && sNum <= 255;
    }
}
// 通过   1 ms	40.3 MB