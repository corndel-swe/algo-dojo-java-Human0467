# Max Effort

## The Problem

Each task in the tree has an `effort` number. Complete the two methods on the `MaxEffortFinder` class to return the
largest `effort` value found in the entire tree, including the root and all its descendants.

You should write two versions:

* `MaxEffortFinder.findIterative`: uses an iterative approach
* `MaxEffortFinder.findRecursive`: uses recursion

---

## Iterative Approach: `MaxEffortFinder.findIterative`

This method uses an explicit stack to traverse the tree. It keeps track
of the maximum effort encountered so far as it processes each node.

### Basic Steps

* Initialise a `maxEffort` variable with the `effort` of the initial `Task` root node.
* Create a stack and push the root `task` node onto it.
* While the stack is not empty:
    * Remove the top node from the stack.
    * If the node's `effort` is greater than `maxEffort`, update `maxEffort` to the node's effort.
    * For each child `Task` in the current node's `children` list, push that child onto the stack.
* Return the final `maxEffort` found.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum number of nodes that can be
  in the stack at any given time (in the worst case, a skewed tree).

---

## Recursive Approach: `MaxEffortFinder.findRecursive`

This method finds the maximum effort by comparing the current node's effort with the maximum efforts found in all its
subtrees. The Java call stack handles the traversal management.

### Basic Steps

* Initialise a `maxEffort` variable with the `effort` of the current `task` node.
* For each child `Task` in the current node's `children` list:
    * Recursively call this method with the child `Task` to find the `childMax` effort in that subtree.
    * If `childMax` is greater than `maxEffort`, update `maxEffort` to `childMax`.
* Return the final `maxEffort`.

### Complexity

* **Time complexity**: O(N) - Where N is the total number of nodes in the tree, as each node is visited once.
* **Space complexity**: O(H) - Where H is the height of the tree, representing the maximum depth of the call stack (in
  the worst case, a skewed tree).