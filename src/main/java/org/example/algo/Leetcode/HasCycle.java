package org.example.algo.Leetcode;

public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                slow = head;
                while (true) {
                    if (slow == fast) {
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;

                }
            }
        }
        return null;
    }
}
