package org.example.algo.Leetcode;

public class MergeTwoList {
    public static ListNode mergeTowLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next=l1==null?l2:l1;
        return dummyHead.next;
    }

    public static ListNode mergeTowListsRecursively(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next=mergeTowListsRecursively(l1.next, l2);
            return l1;

        }else{
            l2.next=mergeTowListsRecursively(l1, l2.next);
            return l2;
        }

    }
}
