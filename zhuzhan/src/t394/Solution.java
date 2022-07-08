package t394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * https://leetcode.cn/problems/decode-string/
 * @author xzq
 * @create 2022-07-07-15:07
 */
// 利用 栈
// 遍历 s，有三种情况：
//              ①：当前是数字，循环遍历得到这个数字，入栈
//              ②：当前是 "[" 或者 字符，直接入栈
//              ③：当前是 "]" 出栈直到遇到 "["，每次出栈的字符都加入到另一个临时栈中，然后反转这个临时栈即是方括号中的字符串
//                  再次取原来栈的栈顶即是重复次数 k，然后把重复 k 次的方括号中字符串再入栈
class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder tmp = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    tmp.append(s.charAt(i));
                    i++;
                }
                stack.offerLast(tmp.toString());
                i--;
            } else if (Character.isLetter(c) ||  c == '[') {
                stack.offerLast(String.valueOf(c));
            } else {
                Deque<String> enStrStack = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    enStrStack.offerFirst(stack.pollLast());
                }
                stack.pollLast(); // "["
                int count = Integer.parseInt(stack.pollLast());
                StringBuilder enSb = new StringBuilder();
                for (String a : enStrStack) {
                    enSb.append(a);
                }
                String enStr = enSb.toString();
                StringBuilder mulEnSb = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    mulEnSb.append(enStr);
                }
                stack.offerLast(mulEnSb.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String a : stack) {
            ans.append(a);
        }
        return ans.toString();
    }
}
// 通过   1 ms	39.4 MB