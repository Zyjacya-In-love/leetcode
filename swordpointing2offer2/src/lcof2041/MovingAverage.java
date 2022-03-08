package lcof2041;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode-cn.com/problems/qIsx9U/
 * @author xzq
 * @create 2022-03-08-9:43
 */
class MovingAverage {
    private Deque<Integer> q;
    private int size;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        sum += val;
        q.offer(val);
        if (q.size() <= this.size) {
            return sum/q.size();
        }
        sum -= q.poll();
        return sum/this.size;
    }
}
