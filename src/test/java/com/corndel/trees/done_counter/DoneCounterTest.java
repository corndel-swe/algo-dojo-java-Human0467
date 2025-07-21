package com.corndel.trees.done_counter;

import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoneCounterTest {

    private final Task tasks = TaskMapper.jsonToTask("task.json");

    @Test
    void countIterative() {
        int count = DoneCounter.countIterative(tasks);
        assertEquals(7, count);
    }

    @Test
    void countRecursive() {
        int count = DoneCounter.countRecursive(tasks);
        assertEquals(7, count);
    }
}