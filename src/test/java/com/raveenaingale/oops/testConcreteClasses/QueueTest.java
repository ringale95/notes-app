package com.raveenaingale.oops.testConcreteClasses;

import com.raveenaingale.oops.concreteClasses.Bag;
import com.raveenaingale.oops.concreteClasses.Queue;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    public void testQueueAdd() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        // Adding items to the bag
        queue.enqueue("Item1");
        queue.enqueue("Item2");

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
    }
    @Test
    public void testQueueIterator(){
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);

        Iterator itr = queue.iterator();

        assertNotEquals(null, itr);
        assertTrue(itr.hasNext());
        assertEquals(0, itr.next());

    }
}
