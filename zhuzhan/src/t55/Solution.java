package t55;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 * @author xzq
 * @create 2022-05-13-10:05
 */
//class Solution {
//    public boolean canJump(int[] nums) {
//        int maxJump = nums[0];
//        int nextMaxJump = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            nextMaxJump = Math.max(nextMaxJump, i+nums[i]);
//            if (i == maxJump) {
//                maxJump = nextMaxJump;
//            }
//        }
//        return maxJump >= nums.length-1;
//    }
//}
// 通过   3 ms	41.5 MB

// 维护最远可达位置
//class Solution {
//    public boolean canJump(int[] nums) {
//        int maxJump = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > maxJump) break;
//            maxJump = Math.max(maxJump, i+nums[i]);
//            if (maxJump >= nums.length-1) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
// 通过   2 ms	42.1 MB


/*
 * @create 2022-06-03-21:18
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i+nums[i]);
            if (maxJump >= n-1) {
                return true;
            }
        }
        return false;
    }
}
// 通过   2 ms	42 MB