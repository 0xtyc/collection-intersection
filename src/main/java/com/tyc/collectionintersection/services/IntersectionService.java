package com.tyc.collectionintersection.services;

import com.tyc.collectionintersection.utils.CollectionGenerator;
import com.tyc.collectionintersection.utils.CollectionIntersectionCalculator;
import com.tyc.collectionintersection.utils.ExecutionTimer;

public class IntersectionService {
    private static final int DEFAULT_RUNS = 10;

    private final CollectionGenerator collectionGenerator;
    private final int[] collectionToHash;
    private final int[] collectionToCheck;
  
    public IntersectionService(int sizeA, int sizeB, int upperBound, boolean hashCollectionA) {
        this.collectionGenerator = new CollectionGenerator(upperBound);
        int[] collectionA = this.collectionGenerator.generateCollection(sizeA);
        int[] collectionB = this.collectionGenerator.generateCollection(sizeB);
        if (hashCollectionA){
            this.collectionToHash = collectionA;
            this.collectionToCheck = collectionB;
        } else {
            this.collectionToHash = collectionB;
            this.collectionToCheck = collectionA;
        }
    }

    public int calculateIntersectionSize() {
        return CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(this.collectionToHash, this.collectionToCheck).size();
    }

    public int benchmarkIntersectionCalculation() {
        return benchmarkIntersectionCalculation(DEFAULT_RUNS);
    }

    public int benchmarkIntersectionCalculation(int runs) {
        int totalTime = 0;
        for (int i = 0; i < runs; i++) {
            totalTime += ExecutionTimer.timeExecution(() -> {
                CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(collectionToHash, collectionToCheck);
                return null;
            });
        }
        return totalTime / runs;
    }

    protected int[] getCollectionToHash() {
        return this.collectionToHash;
    }

    protected int[] getCollectionToCheck() {
        return this.collectionToCheck;
    }
}
