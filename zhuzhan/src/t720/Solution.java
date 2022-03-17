package t720;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 720. 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * @author xzq
 * @create 2022-03-17-10:10
 */
public class Solution {
    private HashSet<String> wordSet;
    private String ans = "";
    public String longestWord(String[] words) {
        wordSet = new HashSet<String>(Arrays.asList(words));
        dfs(new StringBuilder());
        return ans;
    }
    private void dfs(StringBuilder now) {
        for (int i = 0; i < 26; i++) {
            now.append((char) ('a'+i));
            if (wordSet.contains(now.toString())) {
                dfs(now);
            }
            now.deleteCharAt(now.length()-1);
        }
        if (now.length() > ans.length()) {
            ans = now.toString();
        }
    }
}
