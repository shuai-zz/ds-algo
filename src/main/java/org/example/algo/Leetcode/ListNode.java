package org.example.algo.Leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val;this.next = next;}

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
}
