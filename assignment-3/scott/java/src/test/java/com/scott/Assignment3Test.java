package com.scott;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Assignment3Test {

    @Test
    public void testSecondFuncThrows() {
        Exception exception = assertThrows(Exception.class, () -> {
            Assignment3.secondFunc();
        });
        assertEquals("Test error in secondFunc", exception.getMessage());
    }

    @Test
    public void testFirstFuncNoCause() {
        Exception exception = assertThrows(Exception.class, () -> {
            Assignment3.firstFunc();
        });
        assertEquals("Test error in firstFunc", exception.getMessage());
        assertNull(exception.getCause(), "firstFunc should NOT have a cause set");
    }

    @Test
    public void testModFirstFuncWithCause() {
        Exception exception = assertThrows(Exception.class, () -> {
            Assignment3.modFirstFunc();
        });
        assertEquals("Test error in modFirstFunc", exception.getMessage());
        assertNotNull(exception.getCause(), "modFirstFunc SHOULD have a cause set");
        assertEquals("Test error in secondFunc", exception.getCause().getMessage());
    }
}
