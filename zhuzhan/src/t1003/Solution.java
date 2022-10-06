package t1003;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title 1003. 检查替换后的词是否有效
 * @link https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/
 * @from huawei interview coding https://www.nowcoder.com/discuss/1069532
 * @author xzq
 * @create 2022-10-06-11:52
 */
// 错一：之前想错了，不能只用两个变量记录 a b 的数量，因为不止每个单独的abc之间有位置关系，所有 abc 之间也有位置关系
// 只能用 栈 来消消乐，遇到 a b 直接 push，遇到 c 判断栈顶的两个元素是不是 a b 即可，最后判断 栈是不是 空
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'b') {
                stack.push(ch);
            } else {
                if (stack.size() < 2) {
                    return false;
                } else {
                    char t1 = stack.poll();
                    char t2 = stack.poll();
                    if (!(t1 == 'b' && t2 == 'a')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
