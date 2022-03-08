package lcof2108;

import java.util.*;

/**
 * 剑指 Offer II 108. 单词演变
 * https://leetcode-cn.com/problems/om3reC/
 * @author xzq
 * @create 2022-03-08-10:07
 */
class Solution {
    private HashMap<String, Integer> wordId = new HashMap<>();
    private List<List<Integer>> edge = new ArrayList<>();
    private int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);

        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        Deque<Integer> q = new LinkedList<>();
        q.offer(beginId);
        int ans = 0;
        boolean[] vis = new boolean[nodeNum];
        vis[beginId] = true;
        while (!q.isEmpty()) {
            int len = q.size();
            ans++;
            for (int i = 0; i < len; i++) {
                int now = q.poll();
                for (int neighbor : edge.get(now)) {
                    if (vis[neighbor]) continue;
                    if (neighbor == endId) {
                        return ans/2 + 1;
                    }
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return 0;
    }
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char tmp = wordArray[i];
            wordArray[i] = '*';
            String newWord = new String(wordArray);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            wordArray[i] = tmp;
        }
    }
    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
