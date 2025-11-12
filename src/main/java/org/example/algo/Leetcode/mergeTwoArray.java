package org.example.algo.Leetcode;

import java.util.Arrays;

public class mergeTwoArray {
    public int[] mergeTwoArrays(int[] a,int m, int[] b,int n) {
        if(m==0) return b;
        if(n==0) return a;
        System.arraycopy(b,0,a,m,n);
        Arrays.sort(a);
        return a;

    }

    public static void main(String[] args) {
        int[] a={1,2,3,0,0,0};
        int[] b={2,5,6};
        int m=3;
        int n=b.length;
        System.out.println(Arrays.toString(new mergeTwoArray().mergeTwoArrays(a, m, b, n)));
    }
}
