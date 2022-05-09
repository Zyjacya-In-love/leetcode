package t341;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode.cn/problems/flatten-nested-list-iterator/
 * @author xzq
 * @create 2022-05-09-15:04
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
//public class NestedIterator implements Iterator<Integer> {
//
//    private List<NestedInteger> nestedList;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.nestedList = nestedList;
//    }
//
//    @Override
//    public Integer next() {
//        Integer ans = nestedList.get(0).getInteger();
//        nestedList.remove(0);
//        return ans;
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!nestedList.isEmpty() && !nestedList.get(0).isInteger()) {
//            List<NestedInteger> list = nestedList.get(0).getList();
//            nestedList.remove(0);
//            for (int i = list.size()-1; i >= 0; i--) {
//                nestedList.add(0, list.get(i));
//            }
//            System.out.println();
//        }
//        return !nestedList.isEmpty();
//    }
//
//}
// 通过   3 ms	42.7 MB

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// LinkedList 优化头插
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return nestedList.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!nestedList.isEmpty() && !nestedList.getFirst().isInteger()) {
            List<NestedInteger> list = nestedList.removeFirst().getList();
            for (int i = list.size()-1; i >= 0; i--) {
                nestedList.addFirst(list.get(i));
            }
        }
        return !nestedList.isEmpty();
    }

}
// 通过   3 ms	43.6 MB