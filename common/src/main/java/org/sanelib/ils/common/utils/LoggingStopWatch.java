package org.sanelib.ils.common.utils;

public class LoggingStopWatch {
    private long start;
    private long stop;

    public LoggingStopWatch() {

    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public long stop() {
        stop = System.currentTimeMillis();
        return stop - start;
    }
}
