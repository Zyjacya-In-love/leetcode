package t432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 432. 全 O(1) 的数据结构
 * https://leetcode-cn.com/problems/all-oone-data-structure/
 * @author xzq
 * @create 2022-03-16-23:14
 */
class AllOne {

    private HashMap<String, Integer> strCnt;
    private HashMap<Integer, HashSet<String>> numSet;

    public AllOne() {
        strCnt = new HashMap<>();
        numSet = new HashMap<>();
    }

    public void inc(String key) {
        if (!strCnt.containsKey(key)) {
            strCnt.put(key, 1);
        } else {
            int keyCnt = strCnt.get(key);
            numSet.get(keyCnt).remove(key);
            if (numSet.get(keyCnt).isEmpty()) {
                numSet.remove(keyCnt);
            }
            strCnt.put(key, keyCnt+1);
        }

        int keyCnt = strCnt.get(key);
        if (!numSet.containsKey(keyCnt)) {
            numSet.put(keyCnt, new HashSet<>());
        }
        numSet.get(keyCnt).add(key);
    }

    public void dec(String key) {
        if (!strCnt.containsKey(key)) return;
        int keyCnt = strCnt.get(key);
        numSet.get(keyCnt).remove(key);
        if (numSet.get(keyCnt).isEmpty()) {
            numSet.remove(keyCnt);
        }
        if (keyCnt == 1) {
            strCnt.remove(key);
            return;
        }
        keyCnt--;
        strCnt.put(key, keyCnt);

        if (!numSet.containsKey(keyCnt)) {
            numSet.put(keyCnt, new HashSet<>());
        }
        numSet.get(keyCnt).add(key);
    }

    public String getMaxKey() {
        int maxVal = Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry<Integer, HashSet<String>> entry : numSet.entrySet()) {
            if (maxVal < entry.getKey()) {
                maxVal = entry.getKey();
//                System.out.println(entry);
                res = entry.getValue().iterator().next();
            }
        }
        return res;
    }

    public String getMinKey() {
        int minVal = Integer.MAX_VALUE;
        String res = "";
        for (Map.Entry<Integer, HashSet<String>> entry : numSet.entrySet()) {
            if (minVal > entry.getKey()) {
                minVal = entry.getKey();
                res = entry.getValue().iterator().next();
            }
        }
        return res;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
