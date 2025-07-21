# Pair Sum

## The Problem

You're given a **sorted** array of integers and a target number.

Your task is to complete the two methods on the `PairSum` class by determining whether **any two distinct elements** in
the array add up to the target. Return `true` if such a pair exists, otherwise return `false`.

## Brute Force Solution: `PairSum.hasPairSumBruteForce`

This approach uses two nested loops to check every possible pair of distinct elements in the array. For each pair
`(arr[i], arr[j])` where `i < j`, it verifies if their sum equals the `target`.

### Basic Steps

* Loop with an outer pointer `i` from the first element to the end of the array.
* Inside the outer loop, loop with an inner pointer `j` from `i + 1` to the end of the array.
* Calculate the sum of `arr[i]` and `arr[j]`.
* If this sum equals the `target`, immediately return `true`.
* If the loops complete without finding such a pair, return `false`.

### Complexity

* **Time complexity**: O(n²) - Due to the two nested loops, checking every possible pair.
* **Space complexity**: O(1) - Only a few variables are used.

---

## Two-Pointer Solution: `PairSum.hasPairSumTwoPointers`

This approach leverages the fact that the input array is sorted. It uses two pointers, one starting at the
beginning (`left`) and one at the end (`right`), moving them inward based on whether their sum is too small, too large,
or just right. This eliminates many unnecessary comparisons.

### Basic Steps

* Initialise a `left` pointer to the first index of the array.
* Initialise a `right` pointer to the last index of the array.
* While the `left` pointer is less than the `right` pointer:
    * Calculate the `currentSum` as `arr[left] + arr[right]`.
    * If `currentSum` equals the `target`, return `true` (a pair is found).
    * If `currentSum` is less than the `target`, increment the `left` pointer by one (to try a larger sum).
    * If `currentSum` is greater than the `target`, decrement the `right` pointer by one (to try a smaller sum).
* If the loop completes without finding a pair, return `false`.

### Complexity

* **Time complexity**: O(n) - The pointers traverse the array only once.
* **Space complexity**: O(1) - Only a few variables are used.