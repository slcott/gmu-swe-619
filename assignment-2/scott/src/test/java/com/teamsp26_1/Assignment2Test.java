package com.teamsp26_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.teamsp26_1.Assignment2.*;
import static org.junit.jupiter.api.Assertions.*;

class Assignment2Test {

    @ParameterizedTest
    @MethodSource("dupProvider")
    void findDupTestPass(int[] a, int[] b, int expectedIndex) {
        assertEquals(expectedIndex, findDup(a, b));
    }

    @ParameterizedTest
    @MethodSource("dupProviderTransformed")
    void findDupTestFail(int[] a, int[] b, int expectedIndex) {
        assertThrows(Exception.class, () -> findDup(a, b));
    }

    @ParameterizedTest
    @MethodSource("dupProvider")
    @MethodSource("dupProviderTransformed")
    void findDupTransformedTest(int[] a, int[] b, int expectedIndex) {
        // should pass all
        assertEquals(expectedIndex, findDupTransformed(a, b));
    }

    static Stream<Arguments> dupProvider() {
        return Stream.of(
                // valid input with same length arrays with match at index 1
                Arguments.of(new int[]{7, 13, 5}, new int[]{5, 13, 5}, 1),

                // different length arrays with match at index 1
                Arguments.of(new int[]{1, 2, 3}, new int[]{1}, 0),

                // same length, first index match
                Arguments.of(new int[]{ 7, 13, 5 }, new int[]{ 7, 13, 5 }, 0),

                // same length, last index match
                Arguments.of(new int[]{ 7, 13, 5 }, new int[]{ 5, 12, 5 }, 2)
        );
    }

    static Stream<Arguments> dupProviderTransformed() {
        return Stream.of(
                // parameter a null
                Arguments.of(null, new int[]{3, 4}, -1),

                // parameter b null
                Arguments.of(new int[]{3, 4}, null, -1),

                // parameter a empty
                Arguments.of(new int[]{}, new int[]{3, 4}, -1),

                // parameter b empty
                Arguments.of(new int[]{3, 4}, new int[]{}, -1),

                // no match
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, -1)
        );
    }
}