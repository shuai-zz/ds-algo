package org.example.algo.recrusion;

import java.util.Arrays;

public class Fibonacci {
    public static int fibonacci(int n) {
        if(n == 0||n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacciV2(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return memoization(n,cache);
    }

    /**
     * 使用Memoization改进
     * @param n - 第n项
     * @param cache
     * @return 第n项的值
     */
    private static int memoization(int n,int[] cache) {
        if(cache[n] != -1){
            return cache[n];
        }
        int x = memoization(n-1,cache);
        int y = memoization(n-2,cache);
        cache[n]=x+y;
        return cache[n];
    }
}
