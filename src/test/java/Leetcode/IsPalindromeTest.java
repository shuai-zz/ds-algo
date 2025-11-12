package Leetcode;

import org.example.algo.Leetcode.IsPalindrome;
import org.example.algo.Leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsPalindromeTest {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

    @Test
    @DisplayName("翻转一半")
    public void isPalindromeTest1() {
        Assertions.assertTrue(IsPalindrome.isPalindrome(head));
    }

    @Test
    @DisplayName("优化后")
    public void isPalindromeTest2() {
        Assertions.assertTrue(IsPalindrome.isPalindromeRefactor(head));

    }


}
