package datastructures.sort.oOFnlogn;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        // Base case: If the input array has only one element, it
        // is already sorted, so return the array as is.
        if (array.length == 1) return array;

        // Find the middle index of the array by dividing its length by 2.
        int midIndex = array.length/2;

        // Recursively call the mergeSort method on the left half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing
        // the elements from index 0 (inclusive) to the middle index (exclusive).
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));

        // Recursively call the mergeSort method on the right half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing the
        // elements from the middle index (inclusive) to the end of the array (exclusive).
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        // Merge the two sorted halves (left and right) using the merge method,
        // and return the resulting sorted array.
        return merge(left, right);

    }


    public static int[] merge(int[] array1, int[] array2) {
        // Create a new combined array with a size equal to the sum
        // of the lengths of the input arrays
        int[] combined = new int[array1.length + array2.length];

        // Initialize index, i, and j to keep track of positions
        // in combined, array1, and array2 respectively
        int index = 0;
        int i = 0;
        int j = 0;

        // Merge elements from both arrays until one of them reaches its end
        while (i < array1.length && j < array2.length) {
            // If the current element in array1 is smaller, add it to the combined array
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                // Otherwise, add the current element from array2 to the combined array
                combined[index] = array2[j];
                index++;
                j++;
            }
        }

        // If there are remaining elements in array1, add them to the combined array
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        // If there are remaining elements in array2, add them to the combined array
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        // Return the final merged and sorted combined array
        return combined;
    }

}
