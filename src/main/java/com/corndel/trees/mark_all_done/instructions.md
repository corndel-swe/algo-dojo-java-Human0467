# Mark All Done

## The Problem

You are given a tree of tasks. Each task has a `done` property that is either `true` or `false`.

Complete the two methods on the `MarkAllDone` class to update the given task and all its subtasks so that every `done`
value is set to `true`.

These methods should mutate the original given data structure in place.

You should write two versions:

* `MarkAllDone.iterative`: uses an iterative approach
* `MarkAllDone.recursive`: uses recursion

**`DoneCounter.countRecursive` will need to be completed before this class can be benchmarked**

---

## Iterative Approach: `MarkAllDone.iterative`

This method uses an explicit stack to traverse the tree. It processes
each node by setting its `done` property to `true` and then adds its children to the stack for subsequent processing.

### Basic Steps

* Create a stack and push the initial `Task` root node onto it.
* While the stack is not empty:
    * Remove the top node from the stack.
    * Set the `done` property of that node to `true`.
    * For each child `Task` in the current node's `children` list, push that child onto the stack.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited and modified
  once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum number of nodes that can be
  in the stack at any given time (in the worst case, a skewed tree).

---

## Recursive Approach: `MarkAllDone.recursive`

This method utilises the call stack to traverse and modify the tree. The method sets the `done` property for the
current node and then recursively calls itself for each child node, ensuring all descendants are also marked as done.

### Basic Steps

* Set the `done` property of the current `task` node to `true`.
* For each child `Task` in the current node's `children` list:
    * Recursively call this method with the child `Task`.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited and modified
  once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum depth of the call stack (in
  the worst case, a skewed tree).