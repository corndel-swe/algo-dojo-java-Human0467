package com.corndel.two_pointers.array_reverser;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class ArrayReverserBenchmark extends BenchmarkConfig {
    @Param({"1000", "10000"})
    public int arraySize;

    private int[] array;

    @Setup(Level.Trial)
    public void setup() {
        array = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt();
        }
    }

    @Benchmark
    public void reverseBruteForce(Blackhole bh) {
        int[] reversed = ArrayReverser.reverseBruteForce(array);
        bh.consume(reversed);
    }

    @Benchmark
    public void reverseTwoPointers(Blackhole bh) {
        int[] reversed = ArrayReverser.reverseTwoPointers(array);
        bh.consume(reversed);
    }
}
