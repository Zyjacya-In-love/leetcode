package lcof44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @author xzq
 * @create 2022-04-05-14:18
 */
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int k = 2;
        int last = 9;
        long base = 90;
        while (last + base*k < n) {
            last += base*k;
            base *= 10;
            k++;
        }
        int num = (int) (Math.pow(10, k-1)) + (n-last-1)/k;
        int i = k-(n-last-1)%k-1;
        return num/(int)Math.pow(10,i)%10;
    }
}
