package Leetcode;

import org.example.algo.Leetcode.ListNode;
import org.example.algo.Leetcode.ReverseList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReverseListTest {
    @Test
    @DisplayName("双指针")
    public void reverseListDoublePointerDoublePointerTest() {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        ListNode n1=new ReverseList().reverseListDoublePointer(o1);
        System.out.println(n1.toString());
    }

    @Test
    @DisplayName("递归")
    public void reverseListRecursiveTest(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        ListNode n1=new ReverseList().reverseListRecursive(o1);
        System.out.println(n1.toString());
    }
}
