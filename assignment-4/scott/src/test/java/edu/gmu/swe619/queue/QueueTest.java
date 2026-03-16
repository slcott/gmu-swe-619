package edu.gmu.swe619.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testEnqueueAndDequeue() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        
        queue.enQueue("A");
        queue.enQueue("B");
        assertFalse(queue.isEmpty());
        
        assertEquals("A", queue.deQueue());
        assertEquals("B", queue.deQueue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueEmpty() {
        Queue<String> queue = new Queue<>();
        assertThrows(IllegalStateException.class, queue::deQueue);
    }
}
