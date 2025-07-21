# Count Tasks

## The Problem

You are given a tree of tasks. Each task has a `children` property that may contain a list of subtasks.

Complete the two methods on the `TaskCounter` class to return the total number of tasks in the tree, including the root
and all its descendants.

You should write two versions:

* `TaskCounter.countIterative`: uses an iterative approach
* `TaskCounter.countRecursive`: uses a recursive approach

---

## Iterative Approach: `TaskCounter.countIterative`

This method uses an explicit stack to simulate traversing the tree. It
processes each node, increments a counter, and then adds the node's children to the stack for further processing.

### Basic Steps

* Initialise a `count` variable to 0.
* Create a stack and push the initial `Task` (root node) onto it.
* While the stack is not empty:
    * Remove the top node from the stack.
    * Increment the `count`.
    * For each child `Task` in the current node's `children` list, push that child onto the stack.
* Return the final `count`.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited and counted
  once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum number of nodes that can be
  in the stack at any given time (in the worst case, a skewed tree).

---

## Recursive Approach: `TaskCounter.countRecursive`

This method leverages the call stack to traverse the tree. The method counts the current node and then recursively
calls itself for each child node, accumulating the total count from all branches.

### Basic Steps

* Start by initializing a `count` variable to 1 for the current `task` node itself. (Assume the current `task` is not
  null).
* For each child `Task` in the current node's `children` list:
    * Recursively call this method with the child `Task`.
    * Add the result of this recursive call (the count of tasks in the child's subtree) to your `count`.
* Return the final `count` for the current subtree (including the current node).

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited and counted
  once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum depth of the call stack (in
  the worst case, a skewed tree).