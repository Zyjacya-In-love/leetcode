package t875;

/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode.cn/problems/koko-eating-bananas/
 * @author xzq
 * @create 2022-05-12-22:08
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, t = (int) (1e9 + 1);
        while (s < t) {
            int m = ((s + t) >> 1);
            if (eatAll(piles, m, h)) {
                t = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    private boolean eatAll(int[] piles, int k, int maxHours) {
        int needHours = 0;
        for (int pile : piles) {
            needHours += (pile - 1) / k + 1;
        }
        return needHours <= maxHours;
    }
}
// 通过   6 ms	42 MB
