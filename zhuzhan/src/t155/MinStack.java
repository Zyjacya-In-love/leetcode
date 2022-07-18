package t155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title 155. 最小栈
 * @link https://leetcode.cn/problems/min-stack/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-18-20:35
 */
// 办法 ① ：用两个栈，一个栈放元素，一个栈放当前最小元素，同步 push pop
// 办法 ② ：用一个栈，存储当前元素和当前最小元素之间的差值（sub），当前最小元素为 min，
//                  push 的时候，检查 min 和 当前元素 val 的关系，
//                          if val >= min：无需更新 min，push(val-min)
//                          else val < min：说明最小值需要更新了，先 push(val-min)，然后 min = val
//                  top 的时候，检查栈顶元素 正负 情况
//                          if sub >= 0：说明没在这个元素更新最小值那么，返回 min+sub
//                          else sub < 0：说明在这里更新的最小值，返回 min
//                  pop 的时候，检查栈顶元素 正负 情况
//                          if sub >= 0，对最小值没影响，直接 pop
//                          else sub < 0：在这里更新了最小值，所以需要更新回去 min = min-sub，再 pop
class MinStack {

    private long minVal = Integer.MAX_VALUE;
    private Deque<Long> stack = new LinkedList<>(); // 错 1. 次：因为 val-minVal 可能回超 int eg：-2147483648-2147483647

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val-minVal);
        if (val < minVal) {
            minVal = val;
        }
    }

    public void pop() {
        if (stack.peek() < 0) {
            minVal = minVal-stack.peek();
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek()< 0) {
            return (int) minVal;
        }
        return (int) (minVal+stack.peek());
    }

    public int getMin() {
        return (int) minVal;
    }
}
// 通过   6 ms	43.3 MB

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
