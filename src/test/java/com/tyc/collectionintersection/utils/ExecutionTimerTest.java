package com.tyc.collectionintersection.utils;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutionTimerTest {

    @Test
    public void testTimeExecution() {
        long executionTime = ExecutionTimer.timeExecution(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return null; 
        });

        assertTrue(executionTime >= 100_000_000, "Execution time should be at least 100 milliseconds");
        assertTrue(executionTime < 120_000_000, "Execution time should be less than 120 milliseconds");
    }
}