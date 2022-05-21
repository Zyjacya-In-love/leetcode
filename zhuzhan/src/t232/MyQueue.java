package t232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author xzq
 * @create 2022-05-21-9:04
 */
class MyQueue {

    private Deque<Integer> stackIn, stackOut;

    public MyQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                int tmp = stackIn.pop();
                stackOut.push(tmp);
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        int res = pop();
        stackOut.push(res);
        return res;
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}
// 通过   0 ms	39.3 MB

/*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
