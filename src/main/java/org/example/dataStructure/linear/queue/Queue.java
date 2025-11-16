package org.example.dataStructure.linear.queue;

public interface Queue<E> {
    /**
     * 向队列尾部插入值
     * @param e
     * @return
     */
    boolean offer(E e);

    E poll();
    E peek();
    boolean isEmpty();
    boolean isFull();

}
