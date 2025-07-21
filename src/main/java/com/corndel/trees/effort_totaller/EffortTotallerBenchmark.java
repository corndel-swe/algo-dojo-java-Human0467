package com.corndel.trees.effort_totaller;

import com.corndel.benchmark.BenchmarkConfig;
import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class EffortTotallerBenchmark extends BenchmarkConfig {

    private Task task;

    @Setup(Level.Trial)
    public void setupTrial() {
        task = TaskMapper.jsonToTask("task.json");
    }

    @Benchmark
    public void iterative(Blackhole bh) {
        int result = EffortTotaller.totalIterative(task);
        bh.consume(result);
    }

    @Benchmark
    public void recursive(Blackhole bh) {
        int result = EffortTotaller.totalRecursive(task);
        bh.consume(result);
    }
}