package arrayProblems;

public class RemoveElement {
//    In this problem, we are given an array of integers nums and a value val.
//    The goal is to remove all occurrences of val in-place from the array and return the new length of the array after removal.
//
//    The method removeElement(int[] nums, int val) takes an array of integers nums and an integer val as input.
//    It modifies the nums array in-place to remove all instances of val and returns the new length of nums after the removal.
//
//    It's important to note that the order of elements can be changed. We don't need to consider elements beyond the new length.

    public  int removeElement(int[] numsInput, int val) {
        // Initialize index i for writing elements in the array
        int i = 0;

        // Traverse the array from the start to end
        for (int j = 0; j < numsInput.length; j++) {
            // If the current element is not equal to the given value...
            if (numsInput[j] != val) {
                // ...copy it to the position of the 'write' index i...
                numsInput[i] = numsInput[j];
                // ...and increment the write index
                i++;
            }
            // If the current element equals val, it is skipped
        }

        // Return the number of elements not equal to val
        return i;
    }



}
