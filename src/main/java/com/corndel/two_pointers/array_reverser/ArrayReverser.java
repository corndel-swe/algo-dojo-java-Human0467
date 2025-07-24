package com.corndel.two_pointers.array_reverser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReverser {
    public static int[] reverseBruteForce(int[] arr) {
        if(arr.length == 0) {
            return arr;
        }

        List<Integer> tempReversedList = new ArrayList<>();

        for(int i = arr.length; i > 0; i--) {
            tempReversedList.add(arr[i - 1]);
        }

        int[] reversedArray = tempReversedList.stream().mapToInt(Integer::intValue).toArray();

        return reversedArray;
    }


    public static int[] reverseTwoPointers(int[] arr) {
        if(arr.length == 0) {
            return arr;
        }

        int[] arrayCopy = Arrays.copyOf(arr, arr.length);
        int left = 0;
        int right = arrayCopy.length - 1;

        while(left < right){
            int temp = arrayCopy[left];
            arrayCopy[left] = arrayCopy[right];
            arrayCopy[right] = temp;
            left++;
            right--;
        }

        return arrayCopy;
    }

}
