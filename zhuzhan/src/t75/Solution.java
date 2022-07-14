package t75;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 * @author xzq
 * @create 2022-07-14-19:35
 */
// 计数排序：用一个 count 数组记录 0 1 2 的数量，然后复原到 nums 中
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int pos = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[pos++] = i;
            }
        }
    }
}
// 通过   0 ms	39.8 MB