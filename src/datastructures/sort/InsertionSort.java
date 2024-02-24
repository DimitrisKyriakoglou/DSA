package datastructures.sort;

public class InsertionSort {

    public  void insertionSort(int[] array) {
        // Outer loop: Iterate through all elements in the array, starting from the second element
        for (int i = 1; i < array.length; i++) {

            // Store the first element in the unsorted part of the array in a temporary variable
            int temp = array[i];

            // Initialize j to store the index of the last element in the sorted part of the array
            int j = i - 1;

            // Inner loop: Check whether the temporary value should be inserted in the sorted part
            while (j > -1 && temp < array[j]) {

                // Shift the element at index j one position to the right in the sorted part
                array[j+1] = array[j];

                // Assign the temporary value to the element at the index j
                array[j] = temp;

                // Decrement j to move towards the beginning of the sorted part of the array
                j--;
            }
        }
    }

}
