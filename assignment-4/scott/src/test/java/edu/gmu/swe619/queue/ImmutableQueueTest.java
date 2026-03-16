package edu.gmu.swe619.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableQueueTest {

    @Test
    void testEnqueueAndDequeue() {
        ImmutableQueue<String> q1 = new ImmutableQueue<>();
        assertTrue(q1.isEmpty());

        ImmutableQueue<String> q2 = q1.enQueue("A");
        ImmutableQueue<String> q3 = q2.enQueue("B");

        assertTrue(q1.isEmpty());
        assertFalse(q2.isEmpty());
        assertFalse(q3.isEmpty());

        assertEquals("A", q2.getFirst());
        assertEquals("A", q3.getFirst());

        ImmutableQueue<String> q4 = q3.deQueue();
        assertEquals("B", q4.getFirst());
        
        ImmutableQueue<String> q5 = q4.deQueue();
        assertTrue(q5.isEmpty());
    }

    @Test
    void testEmptyQueueOperations() {
        ImmutableQueue<String> q = new ImmutableQueue<>();
        assertThrows(IllegalStateException.class, q::getFirst);
        assertThrows(IllegalStateException.class, q::deQueue);
    }
}
