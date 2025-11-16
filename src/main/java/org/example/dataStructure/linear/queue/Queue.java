package org.example.dataStructure.linear.queue;

public interface Queue<E> {
    /**
     * 向队列尾部插入值
     * @return
     */
    boolean offer(E value);

    E poll();
    E peek();
    boolean isEmpty();
    boolean isFull();

}
