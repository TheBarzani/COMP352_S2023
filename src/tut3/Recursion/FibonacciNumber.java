package tut3.Recursion;

/**
 * FibonacciNumber
 * 
 * Provided by @MustafaDaraghmeh
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        //fibonacci series --> 0,1,1,2,3,5,8,13. . . .
        //fibonacciNumber(0) represents 0th fibonacci number, fibonacciNumber(6) represents 5th fibonacci number with zero based index. i.e., 8
        System.out.println("Fibonacci Series for 19 numbers");
        int fibonacciSeriesLength = 19;
        for (int i = 0; i < fibonacciSeriesLength; i++) {
            int temp= fibonacciNumber(i);
            System.out.print( temp + ",");
        }
    }

    /**
     * <p>Fibonacci Number using Recursion</p>
     * fib(n)    = 0  if(n=0)
     * = 1  if(n=1)
     * = fib(n-1)+fib(n-2)
     *
     * @param n which number in the series.
     * @return returns the value of the number.
     */
    public static int fibonacciNumber(int n) {
        //fibonacci series --> 0,1,1,2,3,5,8,13. . . .
        //base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {   //recursive case
            return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
        }
    }
    
}