package org.example.algo.recrusion;

import java.util.LinkedList;
import java.util.List;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * @param n - 圆盘个数
     * @param a - 原柱子
     * @param b - 中间柱子
     * @param c - 目标柱子
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if(n==0) return;//结束递归
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        move(n - 1, b, a, c);
    }

    public static void hanoi(int n){
        init(n);
        print();
        move(n, a, b, c);
    }


    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("----------------------");
    }
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        System.out.println(A);
    }
    public static void main(String[] args) {

    }
}
