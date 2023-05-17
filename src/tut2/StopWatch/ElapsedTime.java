package tut2.StopWatch;

/* This piece code demonstrates how to use the system utilities to measure
 * the time taken to execute a piece of code.
 * 
 * Provided by @MustafaDaraghmeh
 */

public class ElapsedTime {
    public static void main(String[] args) throws Exception {
        /*Available Formats: TimeType.seconds, TimeType.milliSeconds, TimeType.nanoSeconds.*/
        StopWatch watch = new StopWatch(StopWatch.TimeType.nanoSeconds);
        watch.start();
        // some code
        watch.stop();
        System.out.println( "Stopwatch time is: " + watch.getTime() + "ns");

        /*Same as above but done manually.*/
        long startMillis= System.currentTimeMillis();
        {
            // some code
        }
        long endMillis= System.currentTimeMillis();
        System.out.println("Elapsed Time in Millis is: "
                +(endMillis-startMillis));

        long startNano=System.nanoTime();
        {
            //some code
        }
        long endNano=System.nanoTime();
        System.out.println("Elapsed Time in Nano is: "
                + (endNano-startNano));
    }
}

