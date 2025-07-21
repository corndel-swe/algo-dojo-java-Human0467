package com.corndel.trees.task_counter;

import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCounterTest {

    private final Task tasks = TaskMapper.jsonToTask("task.json");

    @Test
    public void countIterative() {
        int count = TaskCounter.countIterative(tasks);
        assertEquals(16, count);
    }

    @Test
    public void countRecursive() {
        int count = TaskCounter.countRecursive(tasks);
        assertEquals(16, count);
    }
}