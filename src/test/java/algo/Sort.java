package algo;

import org.example.algo.sort.BubbleSort;
import org.example.algo.sort.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Sort {
    int[] array={74,9,30,11,43,22,66,78,2,49,80};
    int[] newArray= Arrays.stream(array).sorted().toArray();

    @Test
    @DisplayName("冒泡排序")
    void bubbleSortTest() {
        int[] arraySorted = BubbleSort.bubbleSortIterative(array);
        Assertions.assertArrayEquals(newArray, arraySorted);

        int[] arraySorted2 = BubbleSort.bubbleSortRecursive(array);
        Assertions.assertArrayEquals(newArray, arraySorted2);
    }

    @Test
    @DisplayName("插入排序")
    void insertionSortTest() {
        int[] arraySorted= InsertionSort.insertionSortRecrutive(array);
        System.out.println(Arrays.toString(arraySorted));
    }
}
