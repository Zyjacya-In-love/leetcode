package t460;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU 缓存
 * https://leetcode-cn.com/problems/lfu-cache/
 * @author xzq
 * @create 2022-05-02-10:35
 */
class LFUCache {

    private final HashMap<Integer, Integer> key2Val;
    private final HashMap<Integer, Integer> key2Freq;
    private final HashMap<Integer, LinkedHashSet<Integer>> freq2Keys;
    private int minFreq;
    private final int capacity;

    public LFUCache(int capacity) {
        key2Val = new HashMap<>();
        key2Freq = new HashMap<>();
        freq2Keys = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!key2Val.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return key2Val.get(key);
    }

    private void increaseFreq(int key) {
        int freq = key2Freq.get(key);
        key2Freq.put(key, freq+1);
        freq2Keys.get(freq).remove(key);
        freq2Keys.putIfAbsent(freq+1, new LinkedHashSet<>());
        freq2Keys.get(freq+1).add(key);
        if (freq2Keys.get(freq).isEmpty()) {
            if (freq == minFreq) {
                minFreq++;
            }
            freq2Keys.remove(freq);
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (key2Val.containsKey(key)) {
            increaseFreq(key);
            key2Val.put(key, value);
            return;
        }
        if (key2Val.size() >= capacity) {
            removeMinFreq();
        }
        key2Val.put(key, value);
        key2Freq.put(key, 1);
        freq2Keys.putIfAbsent(1, new LinkedHashSet<>());
        freq2Keys.get(1).add(key);
        minFreq = 1;
    }

    private void removeMinFreq() {
        int delKey = freq2Keys.get(minFreq).iterator().next();
        key2Val.remove(delKey);
        int freq = key2Freq.get(delKey);
        key2Freq.remove(delKey);
        freq2Keys.get(freq).remove(delKey);
        if (freq2Keys.get(freq).isEmpty()) {
            freq2Keys.remove(freq);
        }
    }
}
// 通过   76 ms	122.2 MB

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
