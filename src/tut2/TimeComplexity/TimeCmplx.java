package tut2.TimeComplexity;
import tut2.StopWatch.*;

/* This piece of code demonstartes the time taken (time complexity)
 * in terms of big_O notation.
 * 
 * Provided by @MustafaDaraghmeh
*/

public class TimeCmplx {
    public static void main(String[] args){
        int n=10;
        StopWatch watch = new StopWatch(StopWatch.TimeType.nanoSeconds);

        watch.start();
        ConstantTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        LogarithmicTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        LinearTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        NLogNTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        QuadraticTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        CubicTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        ExponentialTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());

        watch.start();
        FactorialTimeFunction(n);
        watch.stop();
        System.out.println("Running time is: " + watch.getTime());
    }

    public static void ConstantTimeFunction(int n){
        //Constant Complexity, then Constant Runtime
        System.out.println("\n**** Constant time ****");
        System.out.println("Your input is: " + n);
        System.out.println("Running time not dependent on input size!");
    }

    public static void LogarithmicTimeFunction(int n) {
        //Logarithmic Complexity, then Logarithmic Runtime
        System.out.println("\n**** Logarithmic Time ****");
        int total=0;
        for (int i = 1; i < n; i = i * 2) {
            // Some O(1) expressions
            total++;
        }
        System.out.println("Loop 1, Total amount of times run: " + total);
        total=0;
        for (int i = n; i > 0; i = i / 2) {
            // Some O(1) expressions
            total++;
        }
        System.out.println("Loop 2, Total amount of times run: " + total);
    }

    public static void LinearTimeFunction(int n){
        //Linear Complexity, then Linear Runtime
        System.out.println("\n**** Linear Time ****");
        int total=0;
        for (int i = 0; i < n; i++) {
            // Some O(1) expressions
            total++;
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static void NLogNTimeFunction(int n) {
        // N Log N Complexity, then N Log N Runtime
        System.out.println("\n**** nlogn Time ****");
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j = j * 2) {
                // Some O(1) expressions
                total++;
            }
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static void QuadraticTimeFunction(int n) {
        // Quadratic Complexity, then Quadratic Runtime
        System.out.println("\n**** Quadratic Time ****");
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Some O(1) expressions
                total++;
            }
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static void CubicTimeFunction(int n) {
        // Cubic Complexity, then Cubic Runtime
        System.out.println("\n**** Cubic Time ****");
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // Some O(1) expressions
                    total++;
                }
            }
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static void ExponentialTimeFunction(int n) {
        // Exponential Complexity, then Exponential Runtime
        System.out.println("\n**** Exponential Time ****");
        int total = 0;
        for (int i = 1; i <= Math.pow(2, n); i++) {
            // Some O(1) expressions
            total++;
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static void FactorialTimeFunction(int n) {
        // Factorial Complexity, then Factorial Runtime
        System.out.println("\n**** Factorial Time ****");
        int total = 0;
        for (int i = 1; i <= factorial(n); i++) {
            // Some O(1) expressions
            total++;
        }
        System.out.println("Total amount of times run: " + total);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
