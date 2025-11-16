package org.example.dataStructure.linear.queue;

import java.util.Iterator;

public class LinkedListQueue<E>
        implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node() {
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head=new Node<>(null,null);
    Node<E> tail=head;

    public LinkedListQueue() {
        tail.next=head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node=head.next;
            @Override
            public boolean hasNext() {


                return node!=head;
            }

            @Override
            public E next() {
                E value=node.value;
                node=node.next;
                return value;
            }
        };
    }

    @Override
    public boolean offer(E value) {
        Node<E> added=new Node<>(value,head);
        tail.next=added;
        tail=added;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()) return null;
        Node<E> node=head.next;
        head.next=head.next.next;
        if(node==tail) tail=head;
        return node.value;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

}