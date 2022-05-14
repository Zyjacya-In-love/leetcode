package t69;

/**
 * 69. x 的平方根
 * https://leetcode.cn/problems/sqrtx/
 * @author xzq
 * @create 2022-05-14-9:33
 */
// 左闭右开 [a,b)
//class Solution {
//    public int mySqrt(int x) {
//        long s = 0, t = (long)x+1;
//        while (s < t) {
//            long m = s+((t-s)>>1);
//            if (m*m >= x) {
//                t = m;
//            } else {
//                s = m+1;
//            }
//        }
//        return s*s==x ? (int) s : (int) s-1;
//    }
//}
// 通过   1 ms	38.6 MB

// 左闭右闭 [a,b]
class Solution {
    public int mySqrt(int x) {
        int s = 0, t = x;
        while (s <= t) {
            int m = s + ((t-s)>>1);
            if ((long)m*m < x) {
                s = m+1;
            } else if ((long)m*m > x) {
                t = m-1;
            } else {
                return m;
            }
        }
        return t;
    }
}
// 通过   1 ms	38.5 MB