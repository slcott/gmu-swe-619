package swe619;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindDupSafeTest {

    // *** Normal cases; same as previous tests ***

    @Test
    void test1() {
        // given
        assertEquals(
            1,
            Assignment2.findDup2(new int[] { 7, 13, 5 }, new int[] { 5, 13, 5 })
        );
    }

    @Test
    void matchAtFirstIndex() {
        assertEquals(
            0,
            Assignment2.findDup2(new int[] { 7, 13, 5 }, new int[] { 7, 13, 5 })
        );
    }

    @Test
    void matchAtLastIndex() {
        assertEquals(
            2,
            Assignment2.findDup2(new int[] { 7, 13, 5 }, new int[] { 5, 5, 5 })
        );
    }

    @Test
    void singleElementArrays() {
        assertEquals(
            0,
            Assignment2.findDup2(new int[] { 13 }, new int[] { 13 })
        );
    }

    // new tests;
    // previously not handled if precondition is not satisfied

    @Test
    void firstNull() {
        assertEquals(-1, Assignment2.findDup2(null, new int[] { 1, 2, 3 }));
    }

    @Test
    void secondNull() {
        assertEquals(-1, Assignment2.findDup2(new int[] { 1, 2, 3 }, null));
    }

    @Test
    void bothNull() {
        assertEquals(-1, Assignment2.findDup2(null, null));
    }

    @Test
    void noMatchingElements() {
        assertEquals(
            -1,
            Assignment2.findDup2(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 })
        );
    }

    @Test
    void emptyFirstArray() {
        assertEquals(
            -1,
            Assignment2.findDup2(new int[] {}, new int[] { 1, 2, 3 })
        );
    }

    @Test
    void emptySecondArray() {
        assertEquals(
            -1,
            Assignment2.findDup2(new int[] { 1, 2, 3 }, new int[] {})
        );
    }

    @Test
    void bothArraysEmpty() {
        assertEquals(-1, Assignment2.findDup2(new int[] {}, new int[] {}));
    }

    @Test
    void differentLengthsWithMatch() {
        assertEquals(
            1,
            Assignment2.findDup2(new int[] { 1, 2, 3, 4 }, new int[] { 0, 2 })
        );
    }

    @Test
    void differentLengthsNoMatch() {
        assertEquals(
            -1,
            Assignment2.findDup2(new int[] { 1, 2, 3, 4 }, new int[] { 0 })
        );
    }
}
