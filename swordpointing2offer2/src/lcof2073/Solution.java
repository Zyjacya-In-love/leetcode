package lcof2073;

/**
 * 剑指 Offer II 073. 狒狒吃香蕉
 * https://leetcode-cn.com/problems/nZZqjQ/
 * @author xzq
 * @create 2022-03-08-9:55
 */
public class Solution {
    public boolean isEatUp(int[] piles, int h, int k) {
        int tim = 0;
        for (int pile : piles) {
            tim += ((pile+k-1)%k);
        }
        return tim <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, t = (int)(1e9+7);
        while (s < t) {
            int m = (s+t)>>1;
            if (isEatUp(piles, h, m)) t = m;
            else s = m+1;
        }
        return s;
    }
}
