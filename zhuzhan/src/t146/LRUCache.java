package t146;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache/
 * @author xzq
 * @create 2022-05-02-10:12
 */
class LRUCache {

    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            int delKey = cache.keySet().iterator().next();
            cache.remove(delKey);
        }
        cache.put(key, value);
    }
}
// 通过   62 ms	120.7 MB

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
