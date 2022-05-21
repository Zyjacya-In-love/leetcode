package t20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * @author xzq
 * @create 2022-05-13-15:17
 */
//class Solution {
//    public boolean isValid(String s) {
//        HashMap<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('[', ']');
//        map.put('{', '}');
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                stack.push(s.charAt(i));
//            } else {
//                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)) {
//                    return false;
//                }
//                stack.poll();
//            }
//        }
//        return stack.isEmpty();
//    }
//}
// 通过   2 ms	39.5 MB

/*
 * @create 2022-05-21-9:41
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(map.get(ch));
            } else {
                if (stack.isEmpty() || ch != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
// 通过   2 ms	39.5 MB