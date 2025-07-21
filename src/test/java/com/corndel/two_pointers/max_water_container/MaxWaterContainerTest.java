package com.corndel.two_pointers.max_water_container;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class MaxWaterContainerTest {

    private static final List<TestCase> TEST_CASES = List.of(
            new TestCase(new int[]{}, 0),
            new TestCase(new int[]{1}, 0),
            new TestCase(new int[]{1, 1}, 1),
            new TestCase(new int[]{1, 2, 1}, 2),
            new TestCase(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
            new TestCase(new int[]{4, 3, 2, 1, 4}, 16),
            new TestCase(new int[]{1, 2, 4, 3}, 4)
    );

    @TestFactory
    Stream<DynamicTest> testMostWaterBruteForce() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("mostWaterBruteForce(%s) === %d", Arrays.toString(testCase.arr()), testCase.expected()),
                                () -> {
                                    Assertions.assertEquals(testCase.expected(), MaxWaterContainer.mostWaterBruteForce(testCase.arr()));
                                }
                        )
                );
    }

    @TestFactory
    Stream<DynamicTest> testMostWaterTwoPointers() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("mostWaterTwoPointers(%s) === %d", Arrays.toString(testCase.arr()), testCase.expected()),
                                () -> {
                                    Assertions.assertEquals(testCase.expected(), MaxWaterContainer.mostWaterTwoPointers(testCase.arr()));
                                }
                        )
                );
    }

    private record TestCase(int[] arr, int expected) {
    }
}