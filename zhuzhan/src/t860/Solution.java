package t860;

import java.util.HashMap;

/**
 * 860. 柠檬水找零
 * https://leetcode.cn/problems/lemonade-change/
 * @author xzq
 * @create 2022-06-03-12:23
 */
//      贪心：只有 5 10 20，分类讨论：
//          5：直接收
//          10：看有没有 5 块的
//          20：有两种找零方式 5+10 和 3个 5，贪心的先找零第一个种，
//              因为找出去 5 的情况更多，10 只有遇到 20 的时候才会找出去，所以要尽可能的多留 5
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[30];
        for (int bill : bills) {
            if (bill == 10) {
                if (cnt[5] == 0) {
                    return false;
                }
                cnt[5]--;
            } else if (bill == 20) {
                if ((cnt[10] > 0 && cnt[5] == 0) || (cnt[10] == 0 && cnt[5] < 3)) {
                    return false;
                }
                if (cnt[10] > 0) {
                    cnt[10]--;
                    cnt[5]--;
                } else {
                    cnt[5] -= 3;
                }
            }
            cnt[bill]++;
        }
        return true;
    }
}
// 通过   2 ms	52.6 MB