package org.example.algo.Leetcode;

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return split(lists,0,lists.length-1);
    }

    //返回合并后的列表，i\j代表左右边界
    private static ListNode split(ListNode[] lists,int i,int j){
        if(i==j) return lists[i];
        int m=(i+j)>>>1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return MergeTwoList.mergeTowLists(left, right);
    }
}
