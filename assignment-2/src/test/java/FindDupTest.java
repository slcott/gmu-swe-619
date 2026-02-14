package swe619;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindDupTest {

    @Test
    void test1() {
        // given
        assertEquals(
            1,
            Assignment2.findDup(new int[] { 7, 13, 5 }, new int[] { 5, 13, 5 })
        );
    }

    @Test
    void matchAtFirstIndex() {
        assertEquals(
            0,
            Assignment2.findDup(new int[] { 7, 13, 5 }, new int[] { 7, 13, 5 })
        );
    }

    @Test
    void matchAtLastIndex() {
        assertEquals(
            2,
            Assignment2.findDup(new int[] { 7, 13, 5 }, new int[] { 5, 12, 5 })
        );
    }
}
