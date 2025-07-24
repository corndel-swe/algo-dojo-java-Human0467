package com.corndel.trees.done_counter;

import com.corndel.trees.dto.Task;

import java.util.Stack;

public class DoneCounter {

    public static int countIterative(Task task) {
        int totalDone = 0;

        Stack<Task> taskStack = new Stack<>();
        taskStack.push(task);

        while(!taskStack.isEmpty()){
            Task currentNode = taskStack.pop();
            if(currentNode.isDone()){
                totalDone++;
            }
            for(Task child : currentNode.getChildren() ){
                taskStack.push(child);
            }
        }
        return totalDone;
    }

    public static int countRecursive(Task task) {
        int currentCount = 0;
        if(task.isDone()){
            currentCount++;
        }
        for(Task child : task.getChildren() ){
            currentCount += countRecursive(child);
        }
        return currentCount;
    }

}
