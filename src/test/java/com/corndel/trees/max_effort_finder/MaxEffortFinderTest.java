package com.corndel.trees.max_effort_finder;

import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxEffortFinderTest {

    private Task tasks = TaskMapper.jsonToTask("task.json");

    @BeforeEach
    void setUp() {
        tasks = TaskMapper.jsonToTask("task.json");
    }

    @Test
    void findIterative() {
        int max = MaxEffortFinder.findIterative(tasks);
        assertEquals(20, max);
    }

    @Test
    void findRecursive() {
        int max = MaxEffortFinder.findRecursive(tasks);
        assertEquals(20, max);
    }
}