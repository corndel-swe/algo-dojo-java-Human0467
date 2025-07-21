# ZeroShifter

## The Problem

You're given an array of numbers. Your task is to complete the two methods on the `ZeroShifter` class to move all the
`0`s to the **end of the array**, while maintaining the relative order of the non-zero elements.

Return a new array with the result.

## Brute Force Solution: `ZeroShifter.shiftZerosBruteForce`

This approach involves separating the non-zero elements and zero elements into two distinct lists. Then, these lists are
concatenated to form the final result array, with all non-zeros followed by all zeros, preserving the relative order of
the non-zero elements.

### Basic Steps

* Create two empty lists: one for non-zero numbers and one for zeros.
* Iterate through each number in the input array.
* If a number is 0, add it to the 'zeros' list.
* If a number is not 0, add it to the 'non-zeros' list.
* Create a new result array large enough to hold all elements from both lists.
* Copy all elements from the 'non-zeros' list into the beginning of the result array.
* After that, copy all elements from the 'zeros' list into the remaining positions of the result array.
* Return the combined result array.

### Complexity

* **Time complexity**: O(n) - We iterate through the array once to categorize elements and then once more (effectively)
  to combine them.
* **Space complexity**: O(n) - Two additional lists are created to store elements, and then a new array for the result.

---

## Two-Pointer Solution: `ZeroShifter.shiftZerosTwoPointers`

This approach uses a single `write` pointer to manage the position of the next non-zero element. It iterates
through the array, moving non-zero elements to the front (up to the `write` pointer's position). After all non-zeros
have been placed, the remaining positions in the array (from the `write` pointer to the end) are filled with zeros. This
is often done in-place on a mutable copy of the array.

### Basic Steps

* Create a mutable copy of the input array as the original should not be altered.
* Initialise an `write` pointer, This pointer will track where the next non-zero element should be
  placed.
* Iterate through the array with a `read` pointer (or `i`).
* If the element at the `read` pointer is **not** 0:
    * Copy this non-zero element to the array position indicated by `insertPos`.
    * Increment `insertPos` to point to the next available slot for a non-zero element.
* After the loop finishes (all non-zero elements have been moved to the front), fill the remaining part of the array
  from `insertPos` to the end with zeros.
* Return the modified array.

### Complexity

* **Time complexity**: O(n) - We iterate through the array once to place non-zeros and then a second time (or part of
  it) to fill in zeros.
* **Space complexity**: O(n) - Due to the initial copy of the array; however, the operation itself is performed in-place
  on that copy without significant additional memory allocations during the shifting.