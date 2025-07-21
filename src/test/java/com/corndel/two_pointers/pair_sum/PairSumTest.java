package com.corndel.two_pointers.pair_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PairSumTest {

    private static final List<TestCase> TEST_CASES = List.of(
            new TestCase(new int[]{1, 2, 3, 4, 5}, 9, true),
            new TestCase(new int[]{1, 2, 3, 4, 5}, 10, false),
            new TestCase(new int[]{}, 0, false),
            new TestCase(new int[]{1}, 1, false),
            new TestCase(new int[]{2, 2, 3, 4}, 4, true),
            new TestCase(new int[]{1, 3, 3, 4}, 6, true)
    );

    @TestFactory
    Stream<DynamicTest> testHasPairSumBruteForce() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("hasPairSumBruteForce(%s, %d) === %b",
                                        Arrays.toString(testCase.arr()), testCase.target(), testCase.expected()),
                                () -> {
                                    Assertions.assertEquals(testCase.expected(),
                                            PairSum.hasPairSumBruteForce(testCase.arr(), testCase.target()));
                                }
                        )
                );
    }

    @TestFactory
    Stream<DynamicTest> testHasPairSumTwoPointers() {
        return TEST_CASES.stream()
                .map(testCase ->
                        DynamicTest.dynamicTest(
                                String.format("hasPairSumTwoPointers(%s, %d) === %b",
                                        Arrays.toString(testCase.arr()), testCase.target(), testCase.expected()),
                                () -> {
                                    Assertions.assertEquals(testCase.expected(),
                                            PairSum.hasPairSumTwoPointers(testCase.arr(), testCase.target()));
                                }
                        )
                );
    }

    private record TestCase(int[] arr, int target, boolean expected) {
    }
}

