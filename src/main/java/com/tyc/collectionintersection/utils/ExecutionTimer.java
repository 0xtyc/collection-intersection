package com.tyc.collectionintersection.utils;

import java.util.function.Supplier;

public class ExecutionTimer {
    /**
     * A utility class to time the execution of a task.
     */

    public static long timeExecution(Supplier<Void> task) {
        long startTime = System.nanoTime();
        task.get();
        long endTime = System.nanoTime();
        return endTime - startTime; 
    }
}