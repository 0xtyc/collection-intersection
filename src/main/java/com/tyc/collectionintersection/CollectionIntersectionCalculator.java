
package com.tyc.collectionintersection;

import java.util.HashSet;

public class CollectionIntersectionCalculator {

    private int[] smallerCollection;
    private int[] largerCollection;

    public CollectionIntersectionCalculator(int[] collectionA, int[] collectionB) {
        this.smallerCollection = collectionA.length < collectionB.length ? collectionA : collectionB;
        this.largerCollection = collectionA.length < collectionB.length ? collectionB : collectionA;
    }

    static public int calculateIntersectionSizeWithHash(int[] collectionToHash, int[] collectionToCheck) {
        HashSet<Integer> collectionSet = new HashSet<>();
        for (int num : collectionToHash) {
            collectionSet.add(num);
        }
        int intersectionSize = 0;
        for (int num : collectionToCheck) {
                if (collectionSet.contains(num)) {
                intersectionSize++;
            }
        };
        return intersectionSize;
    }

    private int timeToCalculateIntersectionWithHashing(int runs, int[] collectionToHash, int[] collectionToCheck) {
        for (int i = 0; i < 3; i++) {
            // warm up runs
            calculateIntersectionSizeWithHash(collectionToHash, collectionToCheck);
        }
        long totalTime = 0;
        for (int i = 0; i < runs; i++) {
            totalTime += ExecutionTimer.timeExecution(() -> {
                calculateIntersectionSizeWithHash(collectionToHash, collectionToCheck);
                return null;
            });
        }
        return (int) (totalTime / runs);
    }

    public int timeToCalculateIntersectionWithHashingSmallerCollection(int runs) {
        return timeToCalculateIntersectionWithHashing(runs, this.smallerCollection, this.largerCollection);
    }

    public int timeToCalculateIntersectionWithHashingLargerCollection(int runs) {
        return timeToCalculateIntersectionWithHashing(runs, this.largerCollection, this.smallerCollection);
    }

}
