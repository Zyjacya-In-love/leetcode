package lcof2076;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 * https://leetcode-cn.com/problems/xx4gT2/
 * @author xzq
 * @create 2022-03-08-9:58
 */
class Solution {
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public int partition(int[] nums, int l, int r) {
        int partIdx = l;
        r--;
        while (l < r) {
            while (l < r && nums[r] > nums[partIdx]) r--;
            while (l < r && nums[l] <= nums[partIdx]) l++;
            swap(nums, l, r);
        }
        swap(nums, l, partIdx);
        return l;
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int idx = partition(nums, l, r);
            if (idx == n-k) return nums[n-k];
            if (idx > n-k) r = idx;
            else l = idx+1;
        }
        return nums[n-k];
    }
}
