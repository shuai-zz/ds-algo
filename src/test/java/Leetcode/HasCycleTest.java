package Leetcode;

import org.example.algo.Leetcode.HasCycle;
import org.example.algo.Leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HasCycleTest {
    ListNode n12=new ListNode(12,null);
    ListNode n11=new ListNode(11,n12);
    ListNode n10=new ListNode(10,n11);
    ListNode n9=new ListNode(9,n10);
    ListNode n8=new ListNode(8,n9);
    ListNode n7=new ListNode(7,n8);
    ListNode n6=new ListNode(6,n7);
    ListNode n5=new ListNode(5,n6);
    ListNode n4=new ListNode(4,n5);
    ListNode n3=new ListNode(3,n4);
    ListNode n2=new ListNode(2,n3);
    ListNode head=new ListNode(1,n2);



    @Test
    @DisplayName("判环")
    public void hasCycle() {
        n12.next = n8;
        Assertions.assertTrue(HasCycle.hasCycle(head));

    }

    @Test
    @DisplayName("判环并返回环入口")
    public void hasCycle2() {
        n12.next=n8;
        Assertions.assertEquals(n8,HasCycle.detectCycle(head));
        n12.next=head;
        Assertions.assertEquals(head,HasCycle.detectCycle(head));
    }
}
