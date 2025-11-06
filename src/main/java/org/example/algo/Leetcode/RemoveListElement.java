package org.example.algo.Leetcode;

public class RemoveListElement {
    public static ListNode removeElementsIterable(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if(head == null) return null;
        ListNode node=removeElementsRecursive(head.next,val);
        //如果当前结点值与目标值相等，返回下一个结点递归结果
        if(head.val==val){
            return node;
        }else{
            head.next=node;
            //不等，则更新我的next结点，带上后续处理好的结点，再返回我自己
            return head;
        }
    }
}
