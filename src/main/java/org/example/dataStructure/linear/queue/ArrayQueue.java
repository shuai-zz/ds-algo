package org.example.dataStructure.linear.queue;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;


    public ArrayQueue() {
    }

    @SuppressWarnings("all")
    public ArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int curr=head;
            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public E next() {
                E value = array[curr];
                curr = (curr + 1) % array.length;
                return value;
            }
        };
    }
}
