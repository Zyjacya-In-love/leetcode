package t1342;

/**
 * 1342. 将数字变成 0 的操作次数
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @author xzq
 * @create 2022-03-08-10:21
 */
class Solution {
    public int numberOfSteps(int num) {
        int cnt = 0;
        int x = num;
        while(x != 0) {
            if ((x&1) == 1) cnt++;
            x >>= 1;
        }
        System.out.println(cnt);
        return (int)(Math.log(num)/Math.log(2))+cnt;
    }
}
