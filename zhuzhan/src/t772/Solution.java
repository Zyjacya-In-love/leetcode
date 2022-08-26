package t772;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title 772. 基本计算器 III
 * @link https://leetcode.cn/problems/basic-calculator-iii/
 * @from 2021年快手三面 https://www.nowcoder.com/discuss/1016536?type=post&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=F3AB38B6F9FDF307A69727FE93E636B3-1661479511718
 * @author xzq
 * @create 2022-08-26-10:27
 */
// 224. 基本计算器、227. 基本计算器 II 的合体版本，包括 加减乘除 左右括号
// 括号处理思路和 224 一样，用递归的方式处理括号中表达式，把括号中的表达式算出来作为 num
// 加减乘除的处理和 227 一样，加减法直接放进栈里，乘除法直接算出来再放进栈里，
//      相当于做了一个优先级（乘除法大于加法），最后再统一处理加减法，把栈里的元素都拿出来加一起作为结果
//      这里和 227 的区别是改了 224 括号的一个 bug，当 c == '(' 时，说明刚拿到括号里的值，这时的 c 是括号不是 +-*/ 不能操作放进栈里
//      如果直接放进栈里 sign 就变成 '(' 了，后面一定会再遇到一个 +-*/)，再进这段代码就会把 res = 0 放进栈里，
//      栈里出现多余的 0 这在只有加减法的时候没有问题，0加减任何数都不变，但是乘除会出错
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
            if ((!Character.isDigit(c) && (c != '(' && c != ' ')) || pos == s.length()-1) { // + - * / ) 到结尾
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
// 通过   1 ms	39.7 MB