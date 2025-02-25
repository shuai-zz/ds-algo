package algo;

import org.example.algo.recrusion.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.algo.recrusion.Factorial.factorial;
import static org.example.algo.recrusion.ReversePrintString.*;

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
        System.out.println("");
        reversePrintStringIterative(str);
    }

    @Test
    @DisplayName("斐波那契数列")
    public void fibonacciTest(){
        int num = Fibonacci.fibonacci(8);
        System.out.println(num );

    }

}
