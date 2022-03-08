package lcof2062;

/**
 * 剑指 Offer II 062. 实现前缀树
 * https://leetcode-cn.com/problems/QC3q1f/
 * @author xzq
 * @create 2022-03-08-9:52
 */
class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = prefixLastNode(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return prefixLastNode(prefix) != null;
    }

    public Trie prefixLastNode(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }
}
