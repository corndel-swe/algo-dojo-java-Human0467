package com.corndel.sorting;

public class BubbleSort {
    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * In each pass, adjacent elements are compared and swapped if they are in the wrong order,
     * effectively "bubbling" the largest elements to the end of the array.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then array is sorted
            if (!swapped) {
                break;
            }
        }
    }
}
