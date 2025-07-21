package com.corndel.two_pointers.array_filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class ArrayFilterTest {

    private static final List<TestCase> TEST_CASES = List.of(
            new TestCase(new int[]{}, new int[]{}),
            new TestCase(new int[]{1}, new int[]{1}),
            new TestCase(new int[]{1, 1, 1, 1}, new int[]{1}),
            new TestCase(new int[]{1, 2, 2, 3, 3, 3, 4}, new int[]{1, 2, 3, 4}),
            new TestCase(new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5}, new int[]{1, 2, 3, 4, 5})
    );

    @TestFactory
    Stream<DynamicTest> testGetDistinctNumbersBruteForce() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("getDistinctNumbersBruteForce(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ArrayFilter.getDistinctNumbersBruteForce(testCase.arr()));
                                }
                        )
                );
    }

    @TestFactory
    Stream<DynamicTest> testGetDistinctNumbersTwoPointers() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("getDistinctNumbersTwoPointers(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    int[] arrCopy = Arrays.copyOf(testCase.arr(), testCase.arr().length);

                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ArrayFilter.getDistinctNumbersTwoPointers(arrCopy));
                                }
                        )
                );
    }

    private record TestCase(int[] arr, int[] expected) {
    }
}
