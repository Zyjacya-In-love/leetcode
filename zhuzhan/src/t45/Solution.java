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
//class Solution {
//    public int jump(int[] nums) {
//        int n = nums.length;
//        int farthest = 0;
//        int end = 0;
//        int steps = 0;
//        for (int i = 0; i < n - 1; i++) {
//            farthest = Math.max(farthest, i+nums[i]);
//            if (i == end) {
//                end = farthest;
//                steps++;
//            }
//        }
//        return steps;
//    }
//}
// 通过   1 ms	42.1 MB


/*
 * @create 2022-06-03-21:32
 */
//      贪心：想让每一步跳的尽可能的远，这样汇总起来，每步都跳到最远，最终到达终点就是最少的步数
//              维护当前跳跃最远距离，和下一步跳跃最远距离，如果当前跳到当前最远距离，则步数+1并更新当前最远距离
//                  如果下一步可以跳到终点，则直接返回当前步数即是最小步数
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) { // 这个判断必须有，因为下面的算法 n==1的时候返回1
            return 0;
        }
        int ans = 0;
        int currMaxJump = 0;
        int nextMaxJump = 0;
        for (int i = 0; i < n; i++) {
            nextMaxJump = Math.max(nextMaxJump, i+nums[i]);
            if (i == currMaxJump) {
                ans++;
                if (nextMaxJump >= n-1) {
                    return ans;
                }
                currMaxJump = nextMaxJump;
            }
        }
        return -1; // 到不了终点
    }
}
// 通过   1 ms	42 MB