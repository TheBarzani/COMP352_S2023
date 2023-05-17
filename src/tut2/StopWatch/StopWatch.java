package tut2.StopWatch;

public class StopWatch {
    /*An enum shall either be in its own file or inside a class */
    public enum TimeType {
        nanoSeconds, milliSeconds, seconds
    }

    public StopWatch(TimeType _timeType) {
        start= 0;
        end=  0;
        timeType=_timeType;
    }

    public void start() {
        if (timeType==TimeType.nanoSeconds)
            start = System.nanoTime();
        else
            start = System.currentTimeMillis();
    }

    public void stop() {
        if (timeType==TimeType.nanoSeconds)
            end = System.nanoTime();
        else
            end = System.currentTimeMillis();
    }

    public long getTime() {
        if (timeType==TimeType.seconds)
            return ((end-start)/1000);
        else
            return end-start;
    }
    long start;
    long end;
    TimeType timeType;
}