package lcof2114;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 114. 外星文字典
 * https://leetcode-cn.com/problems/Jf1JuT/
 * @author xzq
 * @create 2022-03-08-10:09
 */
public class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        List<List<Integer>> charEdge = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            charEdge.add(new ArrayList<>());
            inDegree[i] = -1;
        }
        for (int i = 0; i < words.length-1; i++) {
            boolean isSubSame = true;
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    // i j -> i+1 j
                    int source = words[i].charAt(j)-'a';
                    int destination = words[i+1].charAt(j)-'a';
                    if (!charEdge.get(source).contains(destination)) {
                        charEdge.get(source).add(destination);
                        if (inDegree[source] == -1) inDegree[source] = 0;
                        if (inDegree[destination] == -1) inDegree[destination] = 0;
                        inDegree[destination]++;
                    }
                    isSubSame = false;
                    break;
                }

            }
            if (isSubSame && words[i].length() > words[i + 1].length()) {
                return "";
            }
        }
//        for (int i = 0; i < 26; i++) {
//            System.out.println(charEdge.get(i).toString());
//        }

        boolean[] isExist = new boolean[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                isExist[words[i].charAt(j)-'a'] = true;
            }
        }
        StringBuffer ans = new StringBuffer();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now  = queue.poll();
            ans.append((char)('a'+now));
            isExist[now] = false;
            for (int neighbor : charEdge.get(now)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                return "";
            }
        }
//        System.out.println(ans);
        for (int i = 0; i < isExist.length; i++) {
            if (isExist[i]) {
                ans.append((char) (i+'a'));
            }
        }
        return ans.toString();
    }
}
