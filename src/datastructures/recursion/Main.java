package datastructures.recursion;


public class Main {

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int fibClassic(int n) {
        // Stop condition
        if (n == 0)
            return 0;

        // Stop condition
        if (n == 1 || n == 2) {

            return 1;

            // Recursion function
        }
        return   (fibClassic(n - 1) + fibClassic(n - 2));
    }

    static Integer[] memo = new Integer[100];

    //Fib from Up to Bottom of the tree  Recursive
    public static int fibTopBottom(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        // Stop condition
        if (n == 0)
            return 0;
        // Stop condition
        if (n == 1 || n == 2) {
            return 1;
        }
        // Recursion function
        memo[n] = (fibTopBottom(n - 1) + fibTopBottom(n - 2));
        return memo[n];
    }

    //Fib from Bottom to Up Iterable
    public static int fibBottomUp(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int index = 2; index <= n; index++) {
            fibList[index] = fibList[index - 1] + fibList[index - 2];
        }
        return fibList[n];
    }


    public static void main(String[] args) {

        System.out.println(factorial(3));

        // Initialize variable n.
        int n = 5;
        System.out.print("Fibonacci series of 5 numbers is: ");

        // for loop to print the fibonacci series.
        for (int i = 0; i < n; i++) {
            System.out.print(fibClassic(i) + " ");
        }


    }
}
