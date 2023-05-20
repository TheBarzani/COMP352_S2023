package tut3.Arrays;

import java.util.Random;
import tut2.StopWatch.StopWatch;
import tut2.StopWatch.StopWatch.TimeType;

public class ArrayTest {
    public static void main(String[] args) {
        /* Unnecessary comment: creating an array of integers*/
        Integer[] arr = new Integer[89];
        Random rand = new Random();
        StopWatch watch = new StopWatch(TimeType.nanoSeconds);
        for (int i =0; i<arr.length; i++){
            arr[i] = rand.nextInt(99);
        }
        
        int n = 88;
        System.out.println();
        watch.start();
        System.out.print(n +"th element: "+ arr[n]);
        watch.stop();
        
        
        System.out.println("\nTime taken to access " +n + "th element:" + watch.getTime() + "\n");
    }
}
