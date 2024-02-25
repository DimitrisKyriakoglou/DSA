package arrayProblems;

public class Rotate {
    public static void rotate(int[] nums, int k) {
        // Reduce k to its equivalent value within array length range.
        k = k % nums.length;

        // Reverse the first part of the array (from start to length-k)
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part of the array (from length-k to end)
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            // Swap elements at positions 'start' and 'end'
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
