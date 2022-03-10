package lcof53.t1;

/**
 * @author xzq
 * @create 2022-03-09-22:30
 */
class Solution {
    public int search(int[] nums, int target) {
        int s = 0, t = nums.length;
        while (s < t) {
            int m = (s+t)>>1;
            if (nums[m] < target) s = m+1;
            else t = m;
        }
        int first = s;
        s = 0;
        t = nums.length;
        while (s < t) {
            int m = (s+t)>>1;
            if (nums[m] <= target) s = m+1;
            else t = m;
        }
        int last = s;
        return last-first;
    }
}
