package org.example.algo.Leetcode;

public class DeleteAllDuplicates {
    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        if(head.val==head.next.val){
            ListNode temp=head.next.next;
            while(temp.next!=null&&temp.val==head.val){
                temp=temp.next;
            }
            return deleteDuplicatesRecursive(temp);
        }

        head.next=deleteDuplicatesRecursive(head.next);
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead=new ListNode(-1,head);
        ListNode prev=dummyHead;
        ListNode mid,next;
        while((mid=prev.next)!=null&&(next=mid.next)!=null){
            if(mid.val==next.val){
                while((next=next.next)!=null&&next.val==mid.val){}
                prev.next=next;
            }else{
                prev=next;
            }
        }
        return dummyHead.next;
    }

}
