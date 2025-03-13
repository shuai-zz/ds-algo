package org.example.algo.recursion;

public class ReversePrintString {
    /**
     * 翻转字符串（递归）
     *
     * @param n
     * @param str
     */
    public static void reversePrintStringRecursive(int n, String str) {
        if (n == str.length()) {
            return;
        }
        reversePrintStringRecursive(n + 1, str);
        System.out.print(str.charAt(n));
    }

    /**
     * 翻转字符串（循环）
     *
     * @param str
     */
    public static void reversePrintStringIterative(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }


}
