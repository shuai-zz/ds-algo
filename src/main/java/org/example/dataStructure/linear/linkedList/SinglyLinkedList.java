package org.example.dataStructure.linear.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;//头指针

    /**
     * 内部类
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头添加
     *
     * @param value
     */
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    /**
     * 寻找最后一个元素
     *
     * @return
     */
    private Node findLast() {
        if (head == null) { //空链表
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int getValueByIndex(int index) throws IllegalArgumentException{
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    public void insertNode(int index, int value) throws IllegalArgumentException{
        if(index==0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private static IndexOutOfBoundsException illegalIndex(int index) {
        return new IndexOutOfBoundsException(String.format("Index [%d] is illegal", index));
    }

    public void removeFistNode() throws IllegalArgumentException {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    public void removeNode(int index) throws IllegalArgumentException {
        if (index == 0) {
            removeFistNode();
            return;
        }
        //index > 0
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed=prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    public void loop(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loopV2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    public void loopV3(Consumer<Integer> consumer) {
        recursion(head,consumer);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private void recursion(Node curr, Consumer<Integer> consumer) {
        if(curr==null){
            return;
        }
        consumer.accept(curr.value);
        recursion(curr.next,consumer);
    }
}

