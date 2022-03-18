package lcof57;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @author xzq
 * @create 2022-03-18-8:58
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{nums[l], nums[r]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
/**
 * 正确性证明：
 * 记每个状态为 S(i, j)S(i,j) ，即 S(i, j) = nums[i] + nums[j]S(i,j)=nums[i]+nums[j] 。假设 S(i, j) < targetS(i,j)<target ，则执行 i = i + 1i=i+1 ，即状态切换至 S(i + 1, j)S(i+1,j) 。
 *
 * 状态 S(i, j)S(i,j) 切换至 S(i + 1, j)S(i+1,j) ，则会消去一行元素，相当于 消去了状态集合 {S(i, i + 1), S(i, i + 2), ..., S(i, j - 2), S(i, j - 1), S(i, j)S(i,i+1),S(i,i+2),...,S(i,j−2),S(i,j−1),S(i,j) } 。（由于双指针都是向中间收缩，因此这些状态之后不可能再遇到）。
 * 由于 numsnums 是排序数组，因此这些 消去的状态 都一定满足 S(i, j) < targetS(i,j)<target ，即这些状态都 不是解 。
 *
 * 结论： 以上分析已证明 “每次指针 ii 的移动操作，都不会导致解的丢失” ，即指针 ii 的移动操作是 安全的 ；同理，对于指针 jj 可得出同样推论；因此，此双指针法是正确的。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */