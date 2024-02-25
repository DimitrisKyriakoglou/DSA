package arrayProblems;

public class FindMaxMin {

    public int[] findMaxMin(int[] myList) {
        // Start with the first element as the initial maximum
        int maximum = myList[0];
        // Also start with the first element as the initial minimum
        int minimum = myList[0];

        // Traverse the list one number at a time
        for (int num : myList) {
            // If current number is greater than the known maximum...
            if (num > maximum) {
                // ...update maximum to this new value
                maximum = num;
            }
            // If current number is less than the known minimum...
            else if (num < minimum) {
                // ...update minimum to this new value
                minimum = num;
            }
        }

        // Return an array of two elements: maximum and minimum
        return new int[]{maximum, minimum};
    }

    public static int[] findMaxMinI(int[] myList) {
        int max = myList[0];
        int min = myList[0];
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
            if (myList[i] < min) {
                min = myList[i];
            }
        }
        return new int[]{max, min};
    }
}
