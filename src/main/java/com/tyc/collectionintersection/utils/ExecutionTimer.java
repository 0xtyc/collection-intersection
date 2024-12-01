package com.tyc.collectionintersection.utils;

import java.util.function.Supplier;

public class ExecutionTimer {

    public static long timeExecution(Supplier<Void> task) {
        long startTime = System.nanoTime();
        task.get();
        long endTime = System.nanoTime();
        return endTime - startTime; 
    }
}