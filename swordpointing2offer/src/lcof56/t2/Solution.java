package lcof56.t2;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @author xzq
 * @create 2022-03-27-12:38
 */
class Solution {
    public int singleNumber(int[] nums) {
        int flag = 1<<31;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & flag) != 0) {
                    cnt++;
                }
            }
            res <<= 1;
            if (cnt%3 == 1) {
                res |= 1;
            }
            flag >>>= 1;
        }
        return res;
    }
}