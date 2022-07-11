package t33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @author xzq
 * @create 2022-07-11-15:56
 */
// 参考官解下面评论 wangzhen 老哥的思路：时隔6个月，这哥们的一句话，终于让我写了出来 @HaominYuan
//                                    将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
//                                    此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
// 思路就是 wangzhen 的说法，具体实现范围做成闭区间 [s,t] 方便，首先前半部分是不是有序的，如果不是那后半部分肯定是有序的
// 如果前半部分是有序的后半有序或者无序，那么如果 target 在前半部分的范围里，t=m-1，不在 s=m+1，（因为是有序的，判断在不在范围里只需要看target是不是在首尾值之间即可）
// 后半部分有序同理
// 第 1. 次错：思路错，分当前范围有没有旋转，在没旋转的情况下可能性太多了，换了一个思路，当前必有一半范围是有序的，分前半还是后半有序
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, t = n-1;
        while (s <= t) {
            int m = ((s+t)>>1);
            if (nums[m] == target) {
                return m;
            }
            if (nums[s] <= nums[m]) { // 第 2. 次错： <= == 的情况说明 s == m，并且 nums[m] != target 这种情况下，应该 s = m+1，这在这个 if 代码里是对的，但是如果将这种情况交给 else 处理时有可能会出错，在 target < nums[m] 时，eg：[3,1] 1
                if (target >= nums[s] && target <= nums[m]) {
                    t = m-1;
                } else {
                    s = m+1;
                }
            } else {
                if (target >= nums[m] && target <= nums[t]) {
                    s = m+1;
                } else {
                    t = m-1;
                }
            }
        }
        return (s < n && nums[s] == target) ? s : -1;
    }
}