package org.example.algo.sort;

public class BubbleSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] bubbleSortIterative(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            // 当一遍排序后无元素改变=>已有序
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return arr;
    }

    public static int[] bubbleSortRecursive(int[] arr) {
        bubble(arr, arr.length - 1);
        return arr;
    }

    private static void bubble(int[] arr, int j) {
        if(j==0) return;
        int x=0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                x=i;
            }
        }
        bubble(arr, x);
    }

}
