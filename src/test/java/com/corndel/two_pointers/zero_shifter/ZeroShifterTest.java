package com.corndel.two_pointers.zero_shifter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ZeroShifterTest {

    private static final List<TestCase> TEST_CASES = List.of(
            new TestCase(new int[]{}, new int[]{}),
            new TestCase(new int[]{0}, new int[]{0}),
            new TestCase(new int[]{1}, new int[]{1}),
            new TestCase(new int[]{0, 1, 0, 2, 3}, new int[]{1, 2, 3, 0, 0}),
            new TestCase(new int[]{1, 0, 2, 0, 3, 0}, new int[]{1, 2, 3, 0, 0, 0}),
            new TestCase(new int[]{0, 0, 0, 1, 2}, new int[]{1, 2, 0, 0, 0}),
            new TestCase(new int[]{1, 2, 3}, new int[]{1, 2, 3})
    );

    @TestFactory
    Stream<DynamicTest> testShiftZerosBruteForce() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("shiftZerosBruteForce(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ZeroShifter.shiftZerosBruteForce(testCase.arr()));
                                }
                        )
                );
    }

    @TestFactory
    Stream<DynamicTest> testShiftZerosTwoPointers() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("shiftZerosTwoPointers(%s) === %s",
                                        Arrays.toString(testCase.arr()), Arrays.toString(testCase.expected())),
                                () -> {
                                    Assertions.assertArrayEquals(testCase.expected(),
                                            ZeroShifter.shiftZerosTwoPointers(testCase.arr()));
                                }
                        )
                );
    }

    private record TestCase(int[] arr, int[] expected) {
    }
}