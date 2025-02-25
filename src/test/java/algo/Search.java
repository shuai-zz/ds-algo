package algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.algo.search.BinarySearch.*;
import static org.example.algo.search.LinearSearch.linearSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Search {
    int[] arr = {7, 13, 21, 30, 30, 30, 38, 44, 52, 53};

    @Test
    @DisplayName("二分查找")
    public void binarySearchTest() {
        //基础实现
        assertEquals(0, binarySearchBasic(arr, 7));
        assertEquals(-1, binarySearchBasic(arr, 7878));

        //修改实现
        assertEquals(0, binarySearchAlternative(arr, 7));
        assertEquals(-1, binarySearchAlternative(arr, 7878));

        //平衡实现：减少比较次数
        assertEquals(0, binarySearchBalanced(arr, 7));
        assertEquals(-1, binarySearchBalanced(arr, 7878));

        //没找到时返回-(low + 1)，即应插入到哪里
        assertEquals(0, Arrays.binarySearch(arr, 7));
        assertEquals(-11, Arrays.binarySearch(arr, 7878));

        //最左|右元素
        assertEquals(3,binarySearchLeftmost(arr, 30));
        assertEquals(5,binarySearchRightmost(arr, 30));
        assertEquals(3,binarySearchLeftmostV2(arr, 30));
        assertEquals(5,binarySearchRightmostV2(arr, 30));
        assertEquals(-1,binarySearchLeftmost(arr, 7878));

        //递归实现
        assertEquals(0,binarySearch(arr, 7));
        assertEquals(-1,binarySearch(arr, 7878));
    }

    @Test
    @DisplayName("线性查找")
    public void linearSearchTest() {
        assertEquals(0, linearSearch(arr, 7));

    }

}
