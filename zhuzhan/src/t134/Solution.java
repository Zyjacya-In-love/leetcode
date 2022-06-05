package t134;

/**
 * 134. 加油站
 * https://leetcode.cn/problems/gas-station/
 * @author xzq
 * @create 2022-06-05-20:23
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int tmp = gas[i]-cost[i];
            currSum += tmp;
            totalSum += tmp;
            if (currSum < 0) {
                currSum = 0;
                start = i+1;
            }
        }
        return totalSum < 0 ? -1 : start;
    }
}
// 通过   1 ms	61.1 MB