package com.corndel.sorting;

import com.corndel.benchmark.BenchmarkConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.Random;

@State(Scope.Benchmark)
public class SortingBenchmark extends BenchmarkConfig {

    @Param({"1000", "10000"})
    public int arraySize;
    @Param
    public SortType sorter;
    private int[] originalArrayData;
    private int[] arrayToSort;

    @Setup(Level.Trial)
    public void setupTrial() {
        originalArrayData = new int[arraySize];
        Random random = new Random(arraySize);
        for (int i = 0; i < arraySize; i++) {
            originalArrayData[i] = random.nextInt();
        }
    }

    @Setup(Level.Invocation)
    public void setupInvocation() {
        arrayToSort = Arrays.copyOf(originalArrayData, originalArrayData.length);
    }

    @Benchmark
    public void benchmarkSort(Blackhole bh) {
        sorter.sort(arrayToSort);
        bh.consume(arrayToSort);
    }

    public enum SortType {
        BUBBLE_SORT {
            @Override
            public void sort(int[] arr) {
                new BubbleSort().sort(arr);
            }
        },
        INSERTION_SORT {
            @Override
            public void sort(int[] arr) {
                new InsertionSort().sort(arr);
            }
        },
        MERGE_SORT {
            @Override
            public void sort(int[] arr) {
                new MergeSort().sort(arr);
            }
        },
        QUICK_SORT {
            @Override
            public void sort(int[] arr) {
                new QuickSort().sort(arr);
            }
        };

        public abstract void sort(int[] arr);
    }
}
