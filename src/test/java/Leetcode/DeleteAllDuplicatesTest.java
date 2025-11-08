package Leetcode;

import org.example.algo.Leetcode.DeleteAllDuplicates;
import org.example.algo.Leetcode.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteAllDuplicatesTest {
    ListNode head=new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3)))));
    @Test
    @DisplayName("递归实现")
    public void deleteDuplicatesTest() {
        ListNode newHead= DeleteAllDuplicates.deleteDuplicates(head);
        System.out.println(newHead);
    }

    @Test
    @DisplayName("迭代实现")
    public void deleteDuplicates2Test() {
        ListNode newHead=DeleteAllDuplicates.deleteDuplicates(head);
        System.out.println(newHead);
    }
}
