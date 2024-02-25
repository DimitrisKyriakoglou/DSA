package arrayProblems;


import java.util.Arrays;

public class Main {
    public static int maxProfit(int[] prices) {
        // Initialize minPrice with the highest possible integer value.
        int minPrice = Integer.MAX_VALUE;

        // Initialize maxProfit with 0, assuming no profit at the beginning.
        int maxProfit = 0;

        // Loop through each price in the array.
        int profit = 0;
        for (int price : prices) {
            // If current price is lower than minPrice, update minPrice.
            minPrice = Math.min(minPrice, price);


            // Calculate potential profit for current price.
            profit = price - minPrice;


            // If current profit is more than maxProfit, update maxProfit.
            maxProfit = Math.max(maxProfit, profit);
        }
        System.out.println(minPrice);
        System.out.println(profit);

        // After checking all prices, return the maximum profit.
        return maxProfit;
    }

    public static void main(String[] args){
        RemoveElement removeEl= new RemoveElement();
        FindMaxMin findMxMn= new FindMaxMin();
        FindTheLongestString findTheLongestStr= new FindTheLongestString();
        RemoveDublicates  removeDubl = new RemoveDublicates();
        Rotate rot= new Rotate();
        MaxSubArray maxSb= new MaxSubArray();


        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeEl.removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                "\nNew length: " + newLength1);

        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMxMn.findMaxMin(myList1);
        System.out.println("Test case : MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

        String[] stringList4 = {"javaaaaaaaaaaaa", "python", "javascript", "c"};
        String longest4 = findTheLongestStr.findLongestString(stringList4);
        System.out.println("Test case 3: Longest string: " + longest4);  // prints "javascript"

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newLength2 = removeDubl.removeDuplicates(nums2);

        System.out.println("Test case 1: New length: " + newLength2);
        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"


        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 2;
        rot.rotate(nums5, k5);
        System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"


        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result6 = maxSb.maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result6);


    }
}
