package Leetcode;

import org.example.algo.Leetcode.ListNode;
import org.example.algo.Leetcode.RemoveNthFromEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoveNthFromEndTest {
    ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
    @Test
    @DisplayName("递归实现")
    public void removeNthFromEndRecursiveTest(){
        var newHead=RemoveNthFromEnd.removeNthFromEndRecursive(head,2);
        System.out.println(newHead);
    }

    @Test
    @DisplayName("双指针实现")
    public void removeNthFromEndDoublePointerTest(){
        var newHead=RemoveNthFromEnd.removeNthFromEndDoublePointer(head,2);
        System.out.println(newHead);
    }
}
