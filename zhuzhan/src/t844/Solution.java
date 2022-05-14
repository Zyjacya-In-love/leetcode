package t844;

/**
 * 844. 比较含退格的字符串
 * https://leetcode.cn/problems/backspace-string-compare/
 * @author xzq
 * @create 2022-05-14-10:32
 */
//class Solution {
//    public boolean backspaceCompare(String s, String t) {
//        char[] sArr = s.toCharArray();
//        char[] tArr = t.toCharArray();
//        int sLen = backspace(sArr);
//        int tLen = backspace(tArr);
//        if (sLen != tLen) {
//            return false;
//        }
//        for (int i = 0; i < sLen; i++) {
//            if (sArr[i] != tArr[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int backspace(char[] a) {
//        int n = a.length;
//        int slow = 0;
//        int fast = 0;
//        while (fast < n) {
//            if (a[fast] == '#') {
//                slow = Math.max(slow-1, 0);
//            } else {
//                a[slow] = a[fast];
//                slow++;
//            }
//            fast++;
//        }
//        return slow;
//    }
//}
// 通过   0 ms	39.5 MB

// 从后向前遍历，计数退格数量，空间 O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int sSkip = 0;
        int tSkip = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkip++;
                } else {
                    if (sSkip > 0) {
                        sSkip--;
                    } else {
                        break;
                    }
                }
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkip++;
                } else {
                    if (tSkip > 0) {
                        tSkip--;
                    } else {
                        break;
                    }
                }
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
// 通过   0 ms	39.3 MB