# ArrayFilter

## The Problem

You're given a **sorted** array of integers. Your task is to complete the two methods on the `ArrayFilter` class so that
they return a new array where **each element appears only once**, and all duplicates are removed.

The result should preserve the sorted order.

## Brute Force Solution: `ArrayFilter.getDistinctNumbersBruteForce`

This approach iterates through the array, comparing each element to its immediate successor. If an element is different
from the next one, it's considered unique in that comparison and added to a new result list. The last element of the
original array is always added, as it has no successor to compare against.

### Basic Steps

* Create an empty list to store the distinct elements (as it is easier to work with).
* Loop through the array from the first element up to the second-to-last element.
* Inside the loop, if the current element is not equal to the next element, add the current element to your result list.
* After the loop finishes, add the very last element of the original array to your result list (it will always be
  distinct relative to any element after it).
* Convert your result list into an array and return it.

### Complexity

* **Time complexity**: O(N) - We iterate through the array once.
* **Space complexity**: O(N) - A new list (and then array) is created to store the distinct elements.

---

## Two-Pointer Solution: `ArrayFilter.getDistinctNumbersTwoPointers`

This efficient approach uses two pointers to modify the array in-place. A 'read' pointer scans the array, and a 'write'
pointer places unique elements into the correct position. This avoids the overhead of creating a completely new
auxiliary data structure during the primary scanning phase.

### Basic Steps

* Make a mutable copy of the input array to work on as the original array should not be altered. 
  * [The Arrays Class](https://www.baeldung.com/java-array-copy#the-arrays-class)
* Set a `write` pointer to index 1 (assuming the first element is always unique which it will be).
* Loop a `read` pointer from index 1 to the end of the array.
* Inside the loop, if the element at the `read` pointer is different from the element immediately before it (
  `read - 1`), then:
    * Copy the element at the `read` pointer to the position of the `write` pointer.
    * Increment the `write` pointer.
* Create and return a new array that contains elements from the beginning of your mutable array up to the position
  indicated by the `write` pointer.

### Complexity

* **Time complexity**: O(n) - We iterate through the array once.
* **Space complexity**: O(1) extra space (excluding the returned slice) - The modification happens primarily in-place on
  a copy.
* **Note**: The returned value is a new array containing only the unique elements, effectively "slicing" the modified
  portion of the array.