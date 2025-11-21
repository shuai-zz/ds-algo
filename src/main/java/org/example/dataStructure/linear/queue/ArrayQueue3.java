package org.example.dataStructure.linear.queue;


import java.util.Iterator;

/**
 * 仅用head tail判断空满，需要换算成索引值
 * 但当head tail超过int最大值时出错，故需要将余数计算转换为无符号长整型
 * 如果capacity是2^n，则跟2^n-1按位与 如：head&(array.length-1)
 * @param <E>
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;


    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull()) return false;
        array[(int)(Integer.toUnsignedLong(tail)%array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) return null;
        E value=array[(int) (Integer.toUnsignedLong(head)%array.length)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[(int) (Integer.toUnsignedLong(head)%array.length)];
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean isFull() {
        return tail-head==array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int curr=head;
            @Override
            public boolean hasNext() {
                return curr!=tail;
            }

            @Override
            public E next() {
                E value = array[(int) (Integer.toUnsignedLong(curr)%array.length)];
                curr++;
                return value;
            }
        };
    }
}
