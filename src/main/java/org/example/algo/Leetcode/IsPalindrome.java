package org.example.algo.Leetcode;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        MiddleNode middleNode = new MiddleNode();
        ListNode mid = middleNode.middleNode(head);
        ListNode newHead = reverse(mid);
        System.out.println(head);
        System.out.println(newHead);
        //1->2->3<-2<-1
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindromeRefactor(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev=null;
        ListNode curr = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        if(fast != null) {
            slow = slow.next;
        }
        while(prev != null) {
            if(slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }


}
