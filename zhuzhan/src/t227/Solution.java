package t227;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * https://leetcode.cn/problems/basic-calculator-ii/
 * @author xzq
 * @create 2022-05-09-12:51
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> st = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10+(c-'0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                int res = 0;
                switch (sign) {
                    case '+' :
                        res = num;
                        break;
                    case '-' :
                        res = -num;
                        break;
                    case '*' :
                        res = st.pop()*num;
                        break;
                    case '/' :
                        res = st.pop()/num;
                        break;
                }
                st.push(res);
                sign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
// 通过   12 ms	41.3 MB