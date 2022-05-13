package t45;

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 * @author xzq
 * @create 2022-05-13-10:33
 */
//class Solution {
//    public int jump(int[] nums) {
//        int step = 0;
//        int maxJump = 0;
//        int nextMaxJump = 0;
//        // 我们不访问最后一个元素，这是因为在访问最后一个元素之前，
//        // 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
//        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，
//        // 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
//        for (int i = 0; i < nums.length-1; i++) {
//            nextMaxJump = Math.max(nextMaxJump, i+nums[i]);
//            if (nextMaxJump >= nums.length-1) {
//                return step+1;
//            }
//            if (i == maxJump) {
//                maxJump = nextMaxJump;
//                step++;
//            }
//        }
//        return -1;
//    }
//}
// 通过   1 ms	41.6 MB

// labuladong，记录最远到达位置，维护边界
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (i == end) {
                end = farthest;
                steps++;
            }
        }
        return steps;
    }
}
// 通过   1 ms	42.1 MB