package org.example.algo.Leetcode;

public class ListNode {
    int val;
    public ListNode next;
    ListNode(){}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val;this.next = next;}

    // 通用方法：根据任意多个整数创建链表
    public static ListNode of(int... values) {
        // 边界情况：如果没有元素，返回空链表
        if (values.length == 0) {
            return null;
        }

        // 创建头节点（第一个元素）
        ListNode head = new ListNode(values[0]);
        // 当前节点指针，初始指向头节点
        ListNode current = head;

        // 遍历剩余元素，逐个创建节点并连接
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]); // 下一个节点
            current = current.next; // 移动指针到新节点
        }

        return head; // 返回头节点
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this; // 从当前节点开始遍历
        while (curr != null) {
            sb.append(curr.val); // 拼接当前节点的值
            if (curr.next != null) {
                sb.append("->"); // 非尾节点时添加连接符
            }
            curr = curr.next; // 移动到下一个节点
        }
        return sb.toString();
    }


    /**
     * 获取
     * @return val
     */
    public int getVal() {
        return val;
    }

    /**
     * 设置
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * 获取
     * @return next
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * 设置
     * @param next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
}
