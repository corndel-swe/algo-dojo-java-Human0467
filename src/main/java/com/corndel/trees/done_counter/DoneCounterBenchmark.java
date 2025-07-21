package com.corndel.trees.done_counter;

import com.corndel.benchmark.BenchmarkConfig;
import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class DoneCounterBenchmark extends BenchmarkConfig {

    public Task task;

    @Setup(Level.Trial)
    public void setupTrial() {
        task = TaskMapper.jsonToTask("task.json");
    }

    @Benchmark
    public void countIterative(Blackhole bh) {
        int count = DoneCounter.countIterative(task);
        bh.consume(count);
    }

    @Benchmark
    public void countRecursive(Blackhole bh) {
        int count = DoneCounter.countRecursive(task);
        bh.consume(count);
    }

}
