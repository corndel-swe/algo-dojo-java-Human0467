package com.corndel.two_pointers.array_reverser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class ArrayReverserTest {
    private static final List<TestCase> TEST_CASES = List.of(
            new TestCase(new int[]{}, new int[]{}),
            new TestCase(new int[]{1}, new int[]{1}),
            new TestCase(new int[]{1, 2}, new int[]{2, 1}),
            new TestCase(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})
    );

    @TestFactory
    Stream<DynamicTest> testReverseBruteForce() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("reverseBruteForce(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ArrayReverser.reverseBruteForce(testCase.arr()));
                                }
                        )
                );
    }

    @TestFactory
    Stream<DynamicTest> testReverseTwoPointers() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("reverseTwoPointers(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ArrayReverser.reverseTwoPointers(testCase.arr()));
                                }
                        )
                );
    }

    private record TestCase(int[] arr, int[] expected) {
    }
}