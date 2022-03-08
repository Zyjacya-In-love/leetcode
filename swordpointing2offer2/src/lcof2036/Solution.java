package lcof2036;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 036. 后缀表达式
 * https://leetcode-cn.com/problems/8Zf90G/
 * @author xzq
 * @create 2022-03-08-9:42
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stnum = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0)) || (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)) {
                stnum.push(Integer.valueOf(tokens[i]));
            } else {
                int b = stnum.pop();
                int a = stnum.pop();
                int c = 0;
                if (tokens[i].equals("+")) {
                    c = a+b;
                } else if (tokens[i].equals("-")){
                    c = a-b;
                } else if (tokens[i].equals("*")){
                    c = a*b;
                } else if (tokens[i].equals("/")){
                    c = a/b;
                }
                stnum.push(c);
            }
        }
        return stnum.peek();
    }
}
