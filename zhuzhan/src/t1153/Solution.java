package t1153;

import java.util.*;

/**
 * @title 1153. 字符串转化
 * @link https://leetcode.cn/problems/string-transforms-into-another-string/
 * @from weilai-yfh exam 10.3
 * @author xzq
 * @create 2022-10-04-11:46
 */
// ① str1中的相同的字符 对应的str2 位置的字符必须也是一样的，因为 str1中初始相同的字符必然是一起变的，
//      如果 str1中相同的字符对应 str2的字符不同，str1怎么变这几个字符都是相同的，没法变成str2中不一样的字符
// ② str2中包含 26 个字符，不可能转化，因为str2中不一样的字符，对应str1中必然不一样，
//      也就是说 str1 中包含26个字符，无论怎么转换，都会变成现有字符一样的字符，然后就违背了 ① str1相同的字符对应在str2中字符不同
//      并且，只要str2中没包含26个字符，一定可以通过先转成不存在的字符再转换成str2中字符，来完成转换，如果存在转换链 abc->bca 通过不存在的字符打断链即可完成转换
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (!map.containsKey(ch1)) {
                map.put(ch1, ch2);
            } else {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            }
            set.add(ch2);
        }
        return set.size() != 26;
    }
}
// 通过   0 ms	41.6 MB