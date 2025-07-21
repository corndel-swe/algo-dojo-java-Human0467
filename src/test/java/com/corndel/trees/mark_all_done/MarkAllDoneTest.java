package com.corndel.trees.mark_all_done;

import com.corndel.trees.dto.Task;
import com.corndel.trees.dto.TaskMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkAllDoneTest {

    private final Task expected = TaskMapper.jsonToTask("completed-task.json");
    private Task tasks;

    @BeforeEach
    public void setUp() {
        tasks = TaskMapper.jsonToTask("task.json");
    }

    @Test
    void iterative() {
        MarkAllDone.iterative(tasks);
        assertEquals(expected, tasks);
    }

    @Test
    void recursive() {
        MarkAllDone.recursive(tasks);
        assertEquals(expected, tasks);
    }
}