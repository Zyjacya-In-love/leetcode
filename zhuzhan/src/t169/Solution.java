package t169;

/**
 * @title 169. 多数元素
 * @link https://leetcode.cn/problems/majority-element/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-25-18:16
 */
// 没想出来  O(n)  O(1) 的算法
// 摩尔投票法
// 设 超过半数的元素 为 1，其余元素为 -1，那么所有元素加和 结果 必然大于 0
// 当 cnt = 0 的时候，指定当前元素为 candidate
// 若 当前元素 和 candidate 相等，则 cnt++
// 若 当前元素 和 candidate 不等，则 cnt--
// 这样的话，最后的剩下的 candidate 就是 超过半数的 元素，因为其余必然会相互抵消或者和 超过半数的元素 抵消，
// 并且由于 超过半数的元素 大于 一半，它甚至可以抵消所有其余元素，并由有剩余，所以最后剩下的一定是 超过半数的元素
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return candidate;
    }
}
// 通过   1 ms	44.9 MB