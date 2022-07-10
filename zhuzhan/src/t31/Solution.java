package t31;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 * @author xzq
 * @create 2022-07-09-20:18
 */
// ① 从后向前找第一个 ai < ai+1，然后 在 ai+1 - an-1 中找到逆向找到第一个 大于 ai 元素 ax，ax > ai >= ax+1
//      将 ai 与 ax 交换，使得后面比 ai 大的最小的元素作为第一个往前靠的元素，这样尽可能小的比原来排列大一点
//      other word，将当前没有参与排列的最大一个元素拉入伙，交换后 a0-ai 就排列完成，eg：123654 -> 124653
// ② 将 ai+1 - an-1 之间的元素反转，因为 ai+1 - an-1 之间的元素是倒序
//      （操作 ① 前，ai+1 - an-1 是倒序，由于 ax > ai >= ax+1，因此操作 ① 后，ai+1 - an-1 依然是倒序），
//      而反转后即是在 a0-ai 确定的情况下，最小的排列，eg：124653 -> 124356
// 第 1. 次错误：忘记边界，最大排列的下一个是最小排列，[3,2,1] 的下一个排列是 [1,2,3]
// 第 2. 次错误：思路错，不是 ai 和 an-1 换，因为 an-1 不一定比 ai 大，不一定能将排列变大一点
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while (i >= 0 && nums[i] >= nums[i+1]) { // 第 4. 次错误：>= 是因为 如果有重复元素，跳过去，换重复元素不是新排列 eg：[5,1,1]
            i--;
        }
        if (i == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        int x = n-1;
        while (x > i && nums[x] <= nums[i]) { // 第 3. 次错误：<= 是因为 如果有重复元素，需要跳过去 eg：[1,5,1] -> [5,1,1] 而不是 [1,1,5]
            x--;
        }
        swap(nums, i, x);
        reverse(nums, i+1, n-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// 通过   0 ms	41.9 MB