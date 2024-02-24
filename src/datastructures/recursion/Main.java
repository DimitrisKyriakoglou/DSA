package datastructures.recursion;



public class Main {

    public static int factorial(int n){
        if(n==1) return 1;
        return n * factorial(n-1);
    }

   public  static int fib(int n)
    {
        // Stop condition
        if (n == 0)
            return 0;

        // Stop condition
        if (n == 1 || n == 2)
            return 1;

            // Recursion function
        else
            return (fib(n - 1) + fib(n - 2));
    }
    public static void main(String[] args){

        System.out.println(factorial(3));

        // Initialize variable n.
        int n = 5;
        System.out.print("Fibonacci series of 5 numbers is: ");

        // for loop to print the fibonacci series.
        for (int i = 0; i < n; i++)
        {
            System.out.print(fib(i)+" ");
        }


    }
}
