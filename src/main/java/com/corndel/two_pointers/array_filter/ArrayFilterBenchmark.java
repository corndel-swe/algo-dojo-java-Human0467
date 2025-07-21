package com.corndel.two_pointers.array_filter;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.Random;

@State(Scope.Benchmark)
public class ArrayFilterBenchmark extends BenchmarkConfig {

    @Param({"1000", "10000"})
    public int arraySize;

    private int[] array;
    private int[] temp;

    @Setup(Level.Trial)
    public void setup() {
        array = new int[arraySize];
        Random random = new Random(42);

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize / 2);
        }
        Arrays.sort(array);
    }

    @Setup(Level.Iteration)
    public void copy() {
        temp = Arrays.copyOf(array, array.length);
    }

    @Benchmark
    public void getDistinctNumbersBruteForce(Blackhole bh) {
        int[] result = ArrayFilter.getDistinctNumbersBruteForce(temp);
        bh.consume(result);
    }

    @Benchmark
    public void getDistinctNumbersTwoPointers(Blackhole bh) {
        int[] result = ArrayFilter.getDistinctNumbersTwoPointers(array);
        bh.consume(result);
    }
}
