package dataStructure;

import org.example.dataStructure.linear.queue.LinkedListQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueueTest {
    @Test
    @DisplayName("offer/isEmpty/peek/poll方法测试")
    public void offerTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //offer
        Assertions.assertIterableEquals(List.of(1,2,3),queue);
        Assertions.assertFalse(queue.offer(4));
        //isEmpty
        Assertions.assertFalse(queue.isEmpty());
        //peek
        Assertions.assertEquals(1, queue.peek());
        //poll
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertIterableEquals(List.of(2,3),queue);

    }


}
