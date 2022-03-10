package lcof53.t2;

/**
 * @author xzq
 * @create 2022-03-09-22:40
 */
class Solution {
    public int missingNumber(int[] nums) {
        int s = 0, t = nums.length;
        while(s < t) {
            int m = (s+t)>>1;
            if (nums[m] == m) s = m+1;
            else t = m;
        }
        return s;
    }
}
