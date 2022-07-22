package t162;

/**
 * @title 162. 寻找峰值
 * @link https://leetcode.cn/problems/find-peak-element/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-22-22:42
 */
// 二分，一直向比较之后较大的区间内收缩，一定能遇到峰值
// 当前值和右边的值比较，nums[m] < nums[m+1] s = m+1
//                     nums[m] > nums[m+1] t = m
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int s = 0, t = n;
        while (s < t) {
            int m = ((s+t)>>1);
            if (m+1 == n || nums[m] > nums[m+1]) {
                t = m;
            } else {
                s = m+1;
            }
        }
        return s;
    }
}
// 通过   0 ms	41.2 MB
// 官解下的一条评论 ChovyChan 下面的评论
/*
圆圆脸的卷心菜
@severalnana 因为起点是负无穷，开始一定是上坡，目标是寻找序列中第一个下降点，序列从左到右是从“不满足”状态到“满足”状态的。如果nums[mid] < nums[mid+1]，说明仍然不满足，不必包含mid，继续向右找，即l = mid +1；如果nums[mid] > nums[mid+1]，说明此时这个mid位置满足了，但不一定是第一个满足的，所以要把mid包含在内，向左找，即r = mid；退出条件是l == r，也就是框出了唯一的一个位置，此时退出，返回l即可。这是一个很经典的二分框架～
 */