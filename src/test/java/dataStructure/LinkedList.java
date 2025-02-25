package dataStructure;

import org.example.dataStructure.linear.linkedList.CircularDoublyLinkedListSentinel;
import org.example.dataStructure.linear.linkedList.DoublyLinkedListSentinel;
import org.example.dataStructure.linear.linkedList.SinglyLinkedList;
import org.example.dataStructure.linear.linkedList.SinglyLinkedListSentinel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkedList {
    @Test
    @DisplayName("链表")
    public void linkedListTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop(value -> {
            System.out.print(value + " ");
        });
        System.out.println("\n==========\tloopV2\t=========");
        list.loopV2(value -> {
            System.out.print(value + " ");
        });
        System.out.println("\n==========\tIterator\t=========");
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println("\n==========\tloopV3\t=========");
        list.loopV3(value->{
            System.out.print(value + " ");
        });
    }

    @Test
    @DisplayName("链表尾插&获取值测试")
    public void linkedList2Test() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
        Assertions.assertEquals(3, list.getValueByIndex(2));
//        list.getValueByIndex(5); //throw an exception
    }

    @Test
    @DisplayName("链表插入&删除测试")
    public void linkedList3Test() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insertNode(2, 5);
        Assertions.assertIterableEquals(List.of(1, 2, 5, 3, 4), list);
        list.removeFistNode();
        Assertions.assertIterableEquals(List.of(2, 5, 3, 4), list);
        list.removeNode(1);
        Assertions.assertIterableEquals(List.of(2, 3, 4), list);
    }

    @Test
    @DisplayName("哨兵链表插入&获取测试")
    public void linkedListSentinelTest() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
        Assertions.assertEquals(2, list.getValueByIndex(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getValueByIndex(10));

        list.insertNode(0, 0);
        Assertions.assertIterableEquals(List.of(0, 1, 2, 3, 4), list);

    }

    @Test
    @DisplayName("哨兵链表删除测试")
    public void linkedListSentinel2Test() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);

        list.removeNode(1);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(3, 4), list);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeNode(10));
    }

    @Test
    @DisplayName("双向链表插入&获取")
    public void doublyLinkedListSentinelTest() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(4);
        list.insertNode(2, 3);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2, 3, 4), list);
        list.removeLast();
        Assertions.assertIterableEquals(List.of(2, 3), list);
    }

    @Test
    @DisplayName("双向循环链表测试")
    public void circularDoublyLinkedListTest() {
        CircularDoublyLinkedListSentinel list = new CircularDoublyLinkedListSentinel();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);

        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), list);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeLast();
        Assertions.assertIterableEquals(List.of(2, 3, 4), list);
        list.removeByValue(3);
        Assertions.assertIterableEquals(List.of(2, 4), list);

        CircularDoublyLinkedListSentinel list2 = new CircularDoublyLinkedListSentinel();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list2.removeFirst());
    }
}
