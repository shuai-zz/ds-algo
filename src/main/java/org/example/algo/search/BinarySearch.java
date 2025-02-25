package org.example.algo.search;

public class BinarySearch {
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    /**
     * 二分查找改动版
     *
     * @param arr    升序数组
     * @param target 目标
     * @return 找到 ? i : -1
     */
    public static int binarySearchAlternative(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (i < j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找平衡版：减少循环内的比较次数
     *
     * @param arr
     * @param target
     * @return 找到 ? i : -1
     * @O(log_n)
     */
    public static int binarySearchBalanced(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (1 < j - i) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        if (arr[i] == target) {
            return i;
        } else {
            return -1;
        }
    }


    /**
     * 二分查找最左|右：当target有相同元素时返回最左|右侧元素
     *
     * @param arr
     * @param target
     * @return candidate：最左侧target的索引
     */
    public static int binarySearchLeftmost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                //找到target后，记录此时索引mid，并在其左侧继续查找
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }

    public static int binarySearchRightmost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

    public static int binarySearchLeftmostV2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target <= arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static int binarySearchRightmostV2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int i, int j) {
        if (i > j) return -1;
        int mid = (i + j) >>> 1;
        if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, i, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, j);
        } else {
            return mid;
        }
    }
}
