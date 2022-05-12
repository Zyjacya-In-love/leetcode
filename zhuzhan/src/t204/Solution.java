package t204;


/**
 * 204. 计数质数
 * https://leetcode.cn/problems/count-primes/
 * @author xzq
 * @create 2022-05-12-20:36
 */
// 欧拉筛
//class Solution {
//    public int countPrimes(int n) {
//        int[] prime = new int[n];
//        int cnt = 0;
//        boolean[] vis = new boolean[n];
//        for (int i = 2; i < n; i++) {
//            if (!vis[i]) {
//                prime[cnt++] = i;
//            }
//            for (int j = 0; j < cnt; j++) {
//                if ((long) i * prime[j] >= n) break;
//                vis[i * prime[j]] = true;
//                if (i%prime[j] == 0) break;
//            }
//        }
//        return cnt;
//    }
//}
// 通过   149 ms	73.5 MB

// 埃拉托斯特尼筛法，只筛奇数
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isComposite = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (isComposite[i]) continue;
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isComposite[j]) {
                    count--;
                    isComposite[j] = true;
                }
            }
        }
        return count;
    }
}
// 通过   42 ms	45.8 MB