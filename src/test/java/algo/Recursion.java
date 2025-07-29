package algo;

import org.example.algo.recursion.HanoiTower;
import org.example.algo.recursion.PascalTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.algo.recursion.Factorial.factorial;
import static org.example.algo.recursion.Fibonacci.fibonacci;
import static org.example.algo.recursion.Fibonacci.fibonacciV2;
import static org.example.algo.recursion.ReversePrintString.reversePrintStringIterative;
import static org.example.algo.recursion.ReversePrintString.reversePrintStringRecursive;

public class Recursion {

    @Test
    @DisplayName("求阶乘")
    public void factorialTest(){
        Assertions.assertEquals(120, factorial(5));
    }

    @Test
    @DisplayName("反向打印字符串")
    public void reversePrintStringTest(){
        String str = "abc";
        reversePrintStringRecursive(0,str);
        System.out.println();
        reversePrintStringIterative(str);
    }

    @Test
    @DisplayName("斐波那契数列")
    public void fibonacciTest(){
        Assertions.assertEquals(21,fibonacci(8));


        Assertions.assertEquals(1,fibonacciV2(2));
        Assertions.assertEquals(2,fibonacciV2(3));
        Assertions.assertEquals(5,fibonacciV2(5));
    }

    @Test
    @DisplayName("汉诺塔")
    public void HanoiTest(){
        HanoiTower.hanoi(3);
    }

    @Test
    @DisplayName("杨辉三角")
    public void  PascalTriangleTest(){
        PascalTriangle.print(5);
        PascalTriangle.printV2(5);
        PascalTriangle.printV3(5);
    }

}
