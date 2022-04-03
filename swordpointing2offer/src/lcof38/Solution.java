package lcof38;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @author xzq
 * @create 2022-04-02-22:00
 */
// 迭代
class Solution {
    public String[] permutation(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        List<String> ans = new ArrayList<>();
        do {
            ans.add(new String(sArr));
        } while (nextPermutation(sArr));
        return ans.toArray(new String[ans.size()]);
    }
    private boolean nextPermutation(char[] sArr) {
        int n = sArr.length;
        int i = n-2;
        while (i >= 0 && sArr[i] >= sArr[i+1]) i--;
        if (i < 0) return false;
        int j = n-1;
        while (sArr[i] >= sArr[j]) j--;
        swap(sArr, i, j);
        reverse(sArr, i+1, n-1);
        return true;
    }
    private void swap(char[] sArr, int i, int j) {
        char tmp = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = tmp;
    }
    private void reverse(char[] sArr, int i, int j) {
        while (i < j) {
            swap(sArr, i, j);
            i++;
            j--;
        }
    }
}
// dfs
//class Solution {
//    private StringBuilder res;
//    private boolean[] vis;
//    private List<String> ans;
//    private String s;
//    public String[] permutation(String s) {
//        res = new StringBuilder();
//        vis = new boolean[s.length()];
//        ans = new ArrayList<>();
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        this.s = new String(arr);
//        dfs();
//        return ans.toArray(new String[ans.size()]);
//    }
//    private void dfs() {
//        if (res.length() == s.length()) {
//            ans.add(res.toString());
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (vis[i] || (i > 0 && !vis[i-1] && s.charAt(i) == s.charAt(i-1))) continue;
//            vis[i] = true;
//            res.append(s.charAt(i));
//            dfs();
//            res.deleteCharAt(res.length()-1);
//            vis[i] = false;
//        }
//    }
//}
