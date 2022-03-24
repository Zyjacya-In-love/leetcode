package lcof41;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @author xzq
 * @create 2022-03-24-22:10
 */
class MedianFinder {
    private PriorityQueue<Integer> pqLeftMax;
    private PriorityQueue<Integer> pqRightMin;
    /** initialize your data structure here. */
    public MedianFinder() {
        pqLeftMax = new PriorityQueue<Integer>((a, b)->{
            return -Integer.compare(a, b);
        });
        pqRightMin = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (pqLeftMax.isEmpty() || num < pqLeftMax.peek()) {
            pqLeftMax.offer(num);
        } else {
            pqRightMin.offer(num);
        }
    }

    public double findMedian() {
        if (pqLeftMax.isEmpty() && pqRightMin.isEmpty()) {
            return -1;
        }
        int pqLeftMaxLen = pqLeftMax.size();
        int pqRightMinLen = pqRightMin.size();
        int len = pqLeftMaxLen + pqRightMinLen;
        double res = 0;
        if ((len&1) == 1) {
            while (pqLeftMax.size() > pqRightMin.size()+1) {
                int x = pqLeftMax.poll();
                pqRightMin.offer(x);
            }
            while (pqLeftMax.size() < pqRightMin.size()+1) {
                int x = pqRightMin.poll();
                pqLeftMax.offer(x);
            }
            res = pqLeftMax.peek();
        } else {
            while (pqLeftMax.size() > pqRightMin.size()) {
                int x = pqLeftMax.poll();
                pqRightMin.offer(x);
            }
            while (pqLeftMax.size() < pqRightMin.size()) {
                int x = pqRightMin.poll();
                pqLeftMax.offer(x);
            }
            res = (pqLeftMax.peek()+pqRightMin.peek())/2.0;
        }
        return res;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
