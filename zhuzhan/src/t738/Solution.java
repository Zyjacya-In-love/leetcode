package t738;

import java.util.ArrayList;
import java.util.List;

/**
 * 738. 单调递增的数字
 * https://leetcode.cn/problems/monotone-increasing-digits/
 * @author xzq
 * @create 2022-06-05-21:49
 */
//class Solution {
//    public int monotoneIncreasingDigits(int n) {
//        List<Integer> nums = new ArrayList<>();
//        while (n > 0) {
//            nums.add(n%10);
//            n /= 10;
//        }
//        int start = 0;
//        for (int i = 1; i < nums.size(); i++) {
//            if (nums.get(i) > nums.get(i-1)) {
//                nums.set(i, nums.get(i)-1);
//                start = i;
//            }
//        }
//        int end = nums.size()-1;
//        while (end >= start && nums.get(end) == 0) {
//            end--;
//        }
//        int res = 0;
//        for (int i = end; i >= 0; i--) {
//            if (i < start) {
//                res = res*10+9;
//            } else {
//                res = res*10+nums.get(i);
//            }
//        }
//        return res;
//    }
//}
// 通过   1 ms	38.3 MB

// 上面我自己想的纯手写太麻烦了，用用API String.valueOf、Integer.parseInt 会简单很多
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] charNum = String.valueOf(n).toCharArray();
        int start9 = charNum.length;
        for (int i = charNum.length-1; i > 0; i--) {
            if (charNum[i] < charNum[i-1]) {
                charNum[i-1]--;
                start9 = i;
            }
        }
        for (int i = start9; i < charNum.length; i++) {
            charNum[i] = '9';
        }
        return Integer.parseInt(new String(charNum));
    }
}
// 通过   1 ms	38.8 MB