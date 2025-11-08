package org.example.algo.Leetcode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEndRecursive(ListNode head, int n) {
        ListNode dummyHead=new ListNode(-1,head);
        cofunction(dummyHead,n);
        return dummyHead.next;
    }
    private static int cofunction(ListNode head, int n) {
        if(head==null) return 0;
        var counter=cofunction(head.next,n);//下一个结点是倒数第counter个
        if(counter==n) head.next=head.next.next;
        return counter+1;
    }

    public static ListNode removeNthFromEndDoublePointer(ListNode head, int n) {
        ListNode dummyHead=new ListNode(-1,head);
        ListNode prev=dummyHead;
        ListNode cur=head;
        for(int i=0;i<n;i++){
            cur=cur.next;
        }
        while(cur!=null){
            prev=prev.next;
            cur=cur.next;
        }
        prev.next=prev.next.next;
        return dummyHead.next;

    }
}
