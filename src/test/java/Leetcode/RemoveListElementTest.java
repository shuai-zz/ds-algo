package Leetcode;

import org.example.algo.Leetcode.ListNode;
import org.example.algo.Leetcode.RemoveListElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoveListElementTest {
    ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
    @Test
    @DisplayName("迭代实现")
    public void removeListElementIterableTest(){
        System.out.println(head);
        ListNode newHead= RemoveListElement.removeElementsIterable(head,2);
        System.out.println(newHead);
    }

    @Test
    @DisplayName("递归实现")
    public void removeListElementRecursiveTest(){
        ListNode newHead=RemoveListElement.removeElementsRecursive(head,2);
        System.out.println(newHead);
    }
}
