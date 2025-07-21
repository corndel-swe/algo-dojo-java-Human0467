package com.corndel.trees.mark_all_done;

import com.corndel.benchmark.BenchmarkConfig;
import com.corndel.trees.done_counter.DoneCounter;
import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class MarkAllDoneBenchmark extends BenchmarkConfig {

    private Task task;

    @Setup(Level.Iteration)
    public void setupTrial() {
        task = TaskMapper.jsonToTask("task.json");
    }

    @Benchmark
    public void iterative(Blackhole bh) {
        MarkAllDone.iterative(task);
        // The following strategy prevents Dead Code Elimination by accounting for benchmarked methods that modify state in-place without returning a direct result, ensuring the JVM executes the actual work.
        int count = DoneCounter.countRecursive(task);
        bh.consume(count);
    }

    @Benchmark
    public void recursive(Blackhole bh) {
        MarkAllDone.recursive(task);
        int count = DoneCounter.countRecursive(task);
        bh.consume(count);
    }

}
