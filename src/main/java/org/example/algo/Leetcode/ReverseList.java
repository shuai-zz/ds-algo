package org.example.algo.Leetcode;

public class ReverseList {
    public ListNode reverseListDoublePointer(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            var temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseListRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

}
