package t707;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * @author xzq
 * @create 2022-05-17-13:21
 */
public class MyLinkedList {

    private int size;
    private Node dummy;
    private Node tail;
    class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next;}
    }

    public MyLinkedList() {
        size = 0;
        dummy = new Node(-1);
        tail = dummy;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = dummy;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node tmp = new Node(val);
        tmp.next = dummy.next;
        dummy.next = tmp;
        if (tail == dummy) {
            tail = tmp;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node tmp = new Node(val);
        tail.next = tmp;
        tail = tmp;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        Node tmp = new Node(val);
        tmp.next = curr.next;
        curr.next = tmp;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        if (index == size-1) {
            tail = curr;
        }
        size--;
    }
}
// 通过   6 ms	42.1 MB

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */