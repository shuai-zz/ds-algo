package org.example.algo.sort;

public class InsertionSort {
    public static int[] insertionSortRecursive(int[] arr) {
        insertion(arr, 1, arr.length - 1);
        return arr;
    }
    private static void insertion(int[] arr, int low, int high) {
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
        insertion(arr, low + 1, high);
    }

    public static int[] insertionSortIterative(int[] arr) {
        if(arr==null||arr.length<2) return arr;
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        return arr;
    }


}
