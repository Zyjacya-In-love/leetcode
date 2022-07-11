package t7;

/**
 * 7. 整数反转
 * https://leetcode.cn/problems/reverse-integer/
 * @author xzq
 * @create 2022-07-11-17:02
 */
// 核心逻辑很简单，%10 然后 /=10 就行了，难点在于超 int 范围的判断
// 先把负数转正数，记录一个负数标志位
// 在 x 只有一位数的时候特判：如果当前的答案 ans 已经大于 Integer.MAX_VALUE/10 那直接 返回 0
//                          如果当前的答案 ans 等于 Integer.MAX_VALUE/10，那么判断最后一位数是否 大于 7（正数） 或者 8（负数），大于就返回 0
// 最后按照标志位返回正或负数的答案
class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            flag = -1;
            x = -x;
        }
        int ans = 0;
        int maxDiv10 = Integer.MAX_VALUE/10;
        while (x > 0) {
            if (x < 10) { // 第 2. 次错：if 不能放在 x/=10 的逻辑之后，这样 x 除完 ==0 之后会多执行一次，这样当最后的结果 ans > maxDiv10 时会返回 0，eg：-2147483412
                if (ans > maxDiv10) { // 第 1. 次错：错写成 x > maxDiv10，想判断的是当前答案 ans 是不是超范围了，eg：1534236469
                    return 0;
                }
                if (ans == maxDiv10) { // 第 1. 次错：错写成 x == maxDiv10，想判断的是当前答案 ans 是不是超范围了，eg：1534236469
                    if ((flag == -1 && x > 8) || (flag == 1 && x > 7)) {
                        return 0;
                    }
                }
            }
            ans = ans * 10 + (x%10);
            x /= 10;
        }
        return flag*ans;
    }
}
// 通过   0 ms	38.4 MB