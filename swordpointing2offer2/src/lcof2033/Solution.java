package lcof2033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 剑指 Offer II 033. 变位词组
 * https://leetcode-cn.com/problems/sfvd7V/
 * @author xzq
 * @create 2022-03-08-9:41
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arrayCh = strs[i].toCharArray();
            Arrays.sort(arrayCh);
            String sortedStr = new String(arrayCh);
            mp.putIfAbsent(sortedStr, new ArrayList<>());
            mp.get(sortedStr).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}
