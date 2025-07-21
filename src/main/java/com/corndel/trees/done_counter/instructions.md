# Count Done Tasks

## The Problem

You are given a tree of tasks. Each task has a `done` property that is either `true` or `false`, and a `children`
property that is a list of `Task` objects.

Complete the two methods on the `DoneCounter` class to return the total number of completed tasks in the given tree,
including the root and all its descendants.

Each method should take a different approach:

* `DoneCounter.countIterative`: uses an iterative approach
* `DoneCounter.countRecursive`: uses a recursive approach

---

## Iterative Approach: `DoneCounter.countIterative`

This method simulates walking through the tree using an explicit stack.
It processes one node at a time, checking its `done` status and adding its children to the stack for future processing.

### Basic Steps

* Create a counter variable.
* Create a stack and add the root `Task` node onto it.
* While the stack is not empty:
    * Remove the top node from the stack.
    * If the node's `done` property is `true`, increment the counter.
    * For each child `Task` in the current node's `children` list, push that child onto the stack.
* Return the final count.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum number of nodes that can be
  in the stack at any given time (in the worst case, a skewed tree).

---

## Recursive Approach: `DoneCounter.countRecursive`

This method leverages the call stack to traverse the tree. The method calls itself for each child node, aggregating
the count of completed tasks from all branches.

### Basic Steps

* Start with a `currentCount` for the given node: if the current node's `done` property is `true`, `currentCount` is 1;
  otherwise, it's 0.
* For each child `Task` in the current node's `children` list:
    * Recursively call this method with the child `Task`.
    * Add the result of this recursive call to your `currentCount`.
* Return the `currentCount`.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum depth of the call stack (in
  the worst case, a skewed tree).