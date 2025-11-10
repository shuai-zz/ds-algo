package Leetcode;

import org.example.algo.Leetcode.ListNode;
import org.example.algo.Leetcode.MergeKLists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeKListsTest {
    ListNode[] lists={ListNode.of(1,4,5),
            ListNode.of(1,3,4),
            ListNode.of(2,6)
    };
    @Test
    @DisplayName("测试方法")
    public void mergeKLists(){
        ListNode newLists= MergeKLists.mergeKLists(lists);
        System.out.println(newLists);
    }
}
