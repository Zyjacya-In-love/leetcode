package t224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * https://leetcode.cn/problems/basic-calculator/
 * @author xzq
 * @create 2022-05-09-13:23
 */
class Solution {
    private int pos = 0;
    public int calculate(String s) {
        Deque<Integer> st = new LinkedList<>();
        int num = 0;
        char sign = '+';
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == '(') {
                pos++;
                num = calculate(s);
            }
            if (Character.isDigit(c)) {
                num = num*10+(c-'0');
            }
            if ((!Character.isDigit(c) && c != ' ') || pos == s.length()-1) {
                switch (sign) {
                    case '+' :
                        st.push(num);
                        break;
                    case '-' :
                        st.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
            pos++;
        }
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
// 通过   6 ms	42.5 MB
