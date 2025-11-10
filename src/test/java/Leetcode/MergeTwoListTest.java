package Leetcode;

import org.example.algo.Leetcode.ListNode;
import org.example.algo.Leetcode.MergeTwoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeTwoListTest {
    ListNode l1=new ListNode(1, new ListNode(2,new ListNode(4)));
    ListNode l2=new ListNode(1,new ListNode(3, new ListNode(4)));

    @Test
    @DisplayName("迭代实现")
    public void mergeTwoListsTest(){
        ListNode newHead= MergeTwoList.mergeTowLists(l1,l2);
        System.out.println(newHead);
    }

    @Test
    @DisplayName("递归实现")
    public void mergeTwoListsRecursively(){
        ListNode newHead=MergeTwoList.mergeTowListsRecursively(l1,l2);
        System.out.println(newHead);
    }
}
