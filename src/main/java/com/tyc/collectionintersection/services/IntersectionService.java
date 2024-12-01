package com.tyc.collectionintersection.services;

import com.tyc.collectionintersection.utils.CollectionGenerator;
import com.tyc.collectionintersection.utils.CollectionIntersectionCalculator;
import com.tyc.collectionintersection.utils.ExecutionTimer;

public class IntersectionService {

    private CollectionGenerator collectionGenerator;
    private int[] collectionToHash;
    private int[] collectionToCheck;

    public IntersectionService(int sizeA, int sizeB, int maxValue, boolean hashCollectionA) {
        this.collectionGenerator = new CollectionGenerator(maxValue);
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

    public int getIntersectionSize() {
        return CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(this.collectionToHash, this.collectionToCheck).size();
    }

    public int getTimeToCalculateIntersection() {
        final int runs = 10; // run 10 times to get a good average
        int totalTime = 0;
        for (int i = 0; i < runs; i++) {
            totalTime += ExecutionTimer.timeExecution(() -> {
                CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(collectionToHash, collectionToCheck);
                return null;
            });
        }
        return totalTime / runs;
    }
}
