package com.corndel.trees.task_counter;

import com.corndel.benchmark.BenchmarkConfig;
import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class TaskCounterBenchmark extends BenchmarkConfig {

    private Task task;

    @Setup(Level.Trial)
    public void setupTrial() {
        task = TaskMapper.jsonToTask("task.json");
    }

    @Benchmark
    public void countIterative(Blackhole bh) {
        int count = TaskCounter.countIterative(task);
        bh.consume(count);
    }

    @Benchmark
    public void countRecursive(Blackhole bh) {
        int count = TaskCounter.countRecursive(task);
        bh.consume(count);
    }
}
