package lcof51;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @author xzq
 * @create 2022-04-04-19:57
 */
class Solution {
    private int ans = 0;
    private int[] tmp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        ans = 0;
        tmp = new int[n];
        divide(nums, 0, n);
        return ans;
    }
    private void divide(int[] nums, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int m = (l+r)>>1;
        divide(nums, l, m);
        divide(nums, m, r);
        int i = l, j = m;
        int pos = l;
        while (i < m || j < r) {
            int lNum = (i == m) ? Integer.MAX_VALUE : nums[i];
            int rNum = (j == r) ? Integer.MAX_VALUE : nums[j];
            if (i < m && lNum <= rNum) {
                tmp[pos] = lNum;
                i++;
            } else {
                tmp[pos] = rNum;
                ans += (m-i);
                j++;
            }
            pos++;
        }
        for (int k = l; k < r; k++) {
            nums[k] = tmp[k];
        }
    }
}
