# EffortTotaller

## The Problem

Each task in the tree has an `effort` value, which is a number. Your job is to complete the two methods on the
`EffortTotaller` class to return the total effort of the root task and all its descendants.

You should write two versions:

* `EffortTotaller.totalIterative`: uses an iterative approach
* `EffortTotaller.totalRecursive`: uses recursion

---

## Iterative Approach: `EffortTotaller.totalIterative`

This method uses an explicit stack to traverse the tree. It processes
each node, adding its `effort` to a running total, and then pushes its children onto the stack for later processing.

### Basic Steps

* Initialise a `total` variable.
* Add a guard clause.
  * If the initial `Task` root is null, return `0`.
* Create a stack and push the root `task` node onto it.
* While the stack is not empty:
    * Remove the top node from the stack.
    * Add its `effort` value to the `total`.
    * For each child `Task` in the current node's `children` list, push that child onto the stack.
* Return the `total` effort.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum number of nodes that can be
  in the stack at any given time (in the worst case, a skewed tree).

---

## Recursive Approach: `EffortTotaller.totalRecursive`

This method calculates the total effort by summing the current node's effort with the recursively calculated efforts of
all its children. The call stack handles the traversal management.

### Basic Steps

* If the current `task` node is null, return `0`.
* Initialise a `total` variable with the `effort` of the current node.
* For each child `Task` in the current node's `children` list:
    * Recursively call this method with the child `Task`.
    * Add the result of this recursive call to your `total`.
* Return the final `total` effort.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum depth of the call stack (in
  the worst case, a skewed tree).