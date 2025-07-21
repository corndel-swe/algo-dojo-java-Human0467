package com.corndel.two_pointers.zero_shifter;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class ZeroShifterBenchmark extends BenchmarkConfig {

    @Param({"1000", "10000"})
    public int arraySize;

    private int[] array;

    @Setup(Level.Trial)
    public void setup() {
        array = new int[arraySize];
        Random random = new Random(42);

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10);
        }
    }

    @Benchmark
    public void shiftZerosBruteForce(Blackhole bh) {
        int[] result = ZeroShifter.shiftZerosBruteForce(array);
        bh.consume(result);
    }

    @Benchmark
    public void shiftZerosTwoPointers(Blackhole bh) {
        int[] result = ZeroShifter.shiftZerosTwoPointers(array);
        bh.consume(result);
    }
}
