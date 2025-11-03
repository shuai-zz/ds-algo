package org.example.dataStructure.linear.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LinkedListQueue<E>
        implements Queue<E>, Iterable<E> {
    //节点
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.value = item;
            this.next = next;
        }
    }

    Node<E> head = new Node<E>(null, null);
    Node<E> tail = head;


    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean add(E e) {
        if(e == null) {
            throw new NullPointerException();
        }
        Node<E> added=new Node<>(e,head);
        tail.next=added;
        tail=added;
        return true;
    }

    @Override
    public boolean offer(E e) {
        Node<E> added=new Node<>(e, head);
        tail.next=added;
        tail=added;
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        if(isEmpty()) return null;
        Node<E> removed=head.next;
        head.next=removed.next;
        if(removed==tail) tail=head;
        return removed.value;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head.next;
            @Override
            public boolean hasNext() {
                return current!=head;
            }

            @Override
            public E next() {
                E value=current.value;
                current=current.next;
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


}
