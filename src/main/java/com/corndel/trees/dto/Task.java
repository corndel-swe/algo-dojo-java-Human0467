package com.corndel.trees.dto;

import java.util.List;
import java.util.Objects;

public class Task {
    private String id;
    private String title;
    private boolean done;
    private int effort;
    private List<Task> children;

    public Task() {
    }

    public Task(String id, String title, boolean done, int effort, List<Task> children) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.effort = effort;
        this.children = children;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public List<Task> getChildren() {
        return children;
    }

    public void setChildren(List<Task> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task otherTask = (Task) o;

        if (!Objects.equals(id, otherTask.getId())) return false;
        if (!Objects.equals(title, otherTask.getTitle())) return false;
        if (done != otherTask.isDone()) return false;
        if (effort != otherTask.getEffort()) return false;

        return Objects.equals(children, otherTask.getChildren());
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, done, effort, children);
    }

    @Override
    public String toString() {
        return "Task[" +
                "id=" + id + ", " +
                "title=" + title + ", " +
                "done=" + done + ", " +
                "effort=" + effort + ", " +
                "children=" + children + ']';
    }

}
