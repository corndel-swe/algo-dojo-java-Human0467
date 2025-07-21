package com.corndel.two_pointers.max_water_container;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;

@State(Scope.Benchmark)
public class MaxWaterContainerBenchmark extends BenchmarkConfig {

    @Param({"1000", "10000"})
    public int arraySize;

    private int[] heights;

    @Setup(Level.Trial)
    public void setup() {
        heights = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            heights[i] = random.nextInt(100) + 1; // Heights between 1 and 100
        }
    }

    @Benchmark
    public void mostWaterBruteForce(Blackhole bh) {
        int result = MaxWaterContainer.mostWaterBruteForce(heights);
        bh.consume(result);
    }

    @Benchmark
    public void mostWaterTwoPointers(Blackhole bh) {
        int result = MaxWaterContainer.mostWaterTwoPointers(heights);
        bh.consume(result);
    }
}
