package org.example.algo.Leetcode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleNode m = new MiddleNode();
        ListNode l1 = ListNode.of(1, 2, 3, 4, 5);
        ListNode l2 = m.middleNode(l1);
        System.out.println(l1);
    }
}
