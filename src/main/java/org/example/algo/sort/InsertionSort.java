package org.example.algo.sort;

public class InsertionSort {
    public static int[] insertionSortRecrutive(int[] arr) {
        insertionRecrusive(arr, 1, arr.length - 1);
        return arr;
    }
    private static void insertionRecrusive(int[] arr, int low, int high) {
        if (low == high+1) {
            return;
        }
        int insertValue = arr[low];
        int i = low - 1;//已排序区域右边界
        while (i >= 0 && arr[i] > insertValue) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = insertValue;
        insertionRecrusive(arr, low + 1, high);
    }


}
