package org.example.dataStructure.linear;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    //懒惰初始化
    private int[] array = {};

    /**
     * 向最后位置添加数据
     *
     * @param element
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 向某一位置添加数据
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        checkAndGrow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //扩容1.5倍
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * 返回某一位置的数据
     *
     * @param index
     * @return array[index]
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    /**
     * 删除某一位置元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return removed;
    }


    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {//有无下一个元素
                return i < size;
            }

            @Override
            public Integer next() {//返回当前元素，并返回下一个元素
                return array[i++];
            }
        };
    }


    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
