package com.corndel.trees.effort_totaller;

import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EffortTotallerTest {

    private final Task tasks = TaskMapper.jsonToTask("task.json");

    @Test
    void totalIterative() {
        int total = EffortTotaller.totalIterative(tasks);
        assertEquals(100, total);
    }

    @Test
    void totalRecursive() {
        int total = EffortTotaller.totalRecursive(tasks);
        assertEquals(100, total);
    }
}