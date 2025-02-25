package org.example.dataStructure.linear.linkedList;


import java.util.Iterator;

/**
 * 与无哨兵结点差异：无需特殊处理index=0时的情况
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(777,null);
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    };

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

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

    public void addFirst(int value) {
        insertNode(0, value);
    }

    private Node findLast(){
        Node p;
        for(p = head; p.next != null; p = p.next){}
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index){
        int i=-1;
        for(Node p = head; p != null; p = p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }

    private static IndexOutOfBoundsException illegalIndex(int index) {
        return new IndexOutOfBoundsException(String.format("Index [%d] is illegal", index));
    }

    public int getValueByIndex(int index) throws IllegalArgumentException{
        Node node = findNode(index);
        if(node == null){
            throw illegalIndex(index);
        }
        return node.value;
    }

    public void insertNode(int index, int value) throws IllegalArgumentException{
        Node prev = findNode(index-1);
        if(prev == null){
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeNode(int index) throws IllegalArgumentException{
        Node prev = findNode(index-1);
        if(prev == null){
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if(removed == null){
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    public void removeFirst(){
        removeNode(0);
    }



}
