# ArrayReverser

## The Problem

You're given an integer array. Your task is to complete the two methods on the `ArrayReverser` class to return a new
array with the elements in reverse order.

## Brute Force Solution: `ArrayReverser.reverseBruteForce`

This approach involves creating a new array and populating it by iterating through the original array from its end to
its beginning.

### Basic Steps

* Create an empty list to store the reversed elements.
* Loop through the original array starting from its last element down to the first.
* In each iteration, add the current element to your result list.
* Convert your result list into an array and return it.

### Complexity

* **Time complexity**: O(n) - We iterate through the array once.
* **Space complexity**: O(n) - A new list (and then array) is created to store the reversed elements.

---

## Two-Pointer Solution: `ArrayReverser.reverseTwoPointers`

This approach efficiently reverses the array in-place (on a copy to preserve the original) by using two pointers that
move towards each other from opposite ends of the array, swapping elements as they go.

### Basic Steps

* Create a mutable copy of the input array to avoid modifying the original directly.
* Initialise a `left` pointer at index 0 and a `right` pointer at the last index of the array.
* While the `left` pointer is less than the `right` pointer:
    * Swap the elements at the `left` and `right` pointer positions.
    * Update the `left` & `right` pointers, one will be incremented the other decremented.
* Return the modified array.

### Complexity

* **Time complexity**: O(n) - The pointers traverse approximately half the array.
* **Space complexity**: O(n) - Due to the initial copy of the array; however, no significant additional space is
  allocated during the swapping process itself.