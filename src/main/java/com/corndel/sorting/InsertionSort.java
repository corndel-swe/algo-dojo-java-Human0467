package com.corndel.sorting;

public class InsertionSort {
    /**
     * Sorts an array of integers using the Insertion Sort algorithm.
     * It builds the final sorted array one item at a time.
     * Each element is inserted into its correct position in the already sorted part of the array.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
