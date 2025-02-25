package dataStructure;

import org.example.dataStructure.linear.DynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class Array {
    @Test
    @DisplayName("数组")
    public void arrayTest() {
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        //TODO 学习lambd 增强for stream流
        System.out.println("--------Consumer函数接口--------");
        array.foreach((element) -> {
            System.out.println(element);
        });
        
        System.out.println("--------\t增强for循环\t--------");
        for(Integer element : array) {
            System.out.println(element);
        }
        System.out.println("--------\tstream流\t--------");
        array.stream().forEach(System.out::println);

        System.out.println("--------\t删除操作\t--------");
        int removed= array.remove(2);
        assertEquals(3,removed);
        assertIterableEquals(List.of(1,2,4,5,6,7,8,9),array);
    }
}
