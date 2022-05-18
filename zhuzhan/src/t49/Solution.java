package t49;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/
 * @author xzq
 * @create 2022-05-18-8:34
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, ans.size());
                ans.add(new ArrayList<>());
            }
            int index = map.get(sortStr);
            ans.get(index).add(str);
        }
        return ans;
    }
}
// 通过   6 ms	44.4 MB
