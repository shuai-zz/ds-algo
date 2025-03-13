package org.example.algo.recursion;

public class Factorial {
    /**
     * 求阶乘
     *
     * @param n
     * @return n == 1 ? 1 : n * factorial(n - 1)
     */
    public static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
