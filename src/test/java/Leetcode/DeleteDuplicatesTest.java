package Leetcode;

import org.example.algo.Leetcode.DeleteDuplicates;
import org.example.algo.Leetcode.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteDuplicatesTest {
    ListNode head=new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3)))));
    @Test
    @DisplayName("双指针法")
    public void deleteDuplicatesTest(){
        ListNode newHead= DeleteDuplicates.deleteDuplicates(head);
        System.out.println(newHead);
    }

    @Test
    @DisplayName("递归")
    public void deleteDuplicatesTest2(){
        ListNode newHead=DeleteDuplicates.deleteDuplicatesRecursive(head);
        System.out.println(newHead);
    }
}
