package org.example.algo.Leetcode;

public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode prev=head;
        ListNode cur;
        while((cur=prev.next)!=null) {
            if(prev.val == cur.val) {
                prev.next=cur.next;
                continue;
            }
            prev=prev.next;
        }
        return head;
    }

    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head==null||head.next==null) return head;
        var node=deleteDuplicatesRecursive(head.next);
        if(node.val==head.val) {
            return node;
        }else{
            head.next=node;
            return head;
        }
    }
}
