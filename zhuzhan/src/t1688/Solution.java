package t1688;

/**
 * 1688. 比赛中的配对次数
 * https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 * @author xzq
 * @create 2022-03-08-10:17
 */
class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        while(n > 1) {
            ans += (n/2);
            n = (n+1)/2;
        }
        return ans;
    }
}
