package lcof11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author xzq
 * @create 2022-03-10-13:10
 */

/**
 * 问：为什么官方的二分法的题解很多都是写的low + (high - low) // 2 而不是 (high + low) // 2
 * 答：当low和high都很大的时候，相加可能会爆int，而第一种写法不会。 但是第一种写法也不是万能的，比如low可以取负数的时候。对于下标而言，第一种更好
 */
class Solution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (numbers[0] < numbers[n-1]) return numbers[0];
        int s = 0, t = n;
        while (s < n-1 && numbers[s] == numbers[n-1]) s++;
        while (s < t) {
            int m = (s+t)>>1;
            if (numbers[m] > numbers[n-1]) s = m+1;
            else t = m;
        }
        return numbers[s];
    }
}