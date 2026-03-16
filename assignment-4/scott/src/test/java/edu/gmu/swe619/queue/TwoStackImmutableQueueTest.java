package edu.gmu.swe619.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoStackImmutableQueueTest {

    @Test
    void testEnqueueAndDequeue() {
        TwoStackImmutableQueue<String> q1 = new TwoStackImmutableQueue<>();
        assertTrue(q1.isEmpty());

        TwoStackImmutableQueue<String> q2 = q1.enQueue("A");
        TwoStackImmutableQueue<String> q3 = q2.enQueue("B");

        assertTrue(q1.isEmpty());
        assertFalse(q2.isEmpty());
        assertFalse(q3.isEmpty());

        assertEquals("A", q2.getFirst());
        assertEquals("A", q3.getFirst());

        TwoStackImmutableQueue<String> q4 = q3.deQueue();
        assertEquals("B", q4.getFirst());
        
        TwoStackImmutableQueue<String> q5 = q4.deQueue();
        assertTrue(q5.isEmpty());
    }

    @Test
    void testAmortizedBehavior() {
        TwoStackImmutableQueue<Integer> q = new TwoStackImmutableQueue<>();
        for (int i = 0; i < 100; i++) {
            q = q.enQueue(i);
        }
        
        for (int i = 0; i < 100; i++) {
            assertEquals(i, q.getFirst());
            q = q.deQueue();
        }
        assertTrue(q.isEmpty());
    }

    @Test
    void testEmptyQueueOperations() {
        TwoStackImmutableQueue<String> q = new TwoStackImmutableQueue<>();
        assertThrows(IllegalStateException.class, q::getFirst);
        assertThrows(IllegalStateException.class, q::deQueue);
    }
}
