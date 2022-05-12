package t1011;

/**
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 * @author xzq
 * @create 2022-05-12-22:23
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 1, t = (int) 25e6 + 1;
        while (s < t) {
            int m = ((s+t)>>1);
            if (isOk(weights, m, days)) {
                t = m;
            } else {
                s = m+1;
            }
        }
        return s;
    }

    private boolean isOk(int[] weights, int maxSupport, int days) {
        int sum = 0;
        int needDay = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > maxSupport) {
                return false;
            }
            sum += weights[i];
            if (sum > maxSupport) {
                needDay++;
                sum = 0;
                i--;
            }
        }
        if (sum > 0) needDay++;
        return needDay <= days;
    }
}
// 通过   9 ms	45.2 MB