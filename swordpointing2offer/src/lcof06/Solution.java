package lcof06;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author xzq
 * @create 2022-03-07-19:34
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            ans.add(curr.val);
            curr = curr.next;
        }
        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
