package com.corndel.two_pointers.pair_sum;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.Random;

@State(Scope.Benchmark)
public class PairSumBenchmark extends BenchmarkConfig {

    @Param({"1000", "10000"})
    public int arraySize;

    private int[] array;
    private int unreachableTarget;


    @Setup(Level.Trial)
    public void setup() {
        array = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize * 2);
        }

        Arrays.sort(array);

        unreachableTarget = array[arraySize - 1] + array[arraySize - 2] + 1;
    }

    @Benchmark
    public void hasPairSumBruteForce(Blackhole bh) {
        boolean result = PairSum.hasPairSumBruteForce(array, unreachableTarget);
        bh.consume(result);
    }

    @Benchmark
    public void hasPairSumTwoPointers(Blackhole bh) {
        boolean result = PairSum.hasPairSumTwoPointers(array, unreachableTarget);
        bh.consume(result);
    }
}

