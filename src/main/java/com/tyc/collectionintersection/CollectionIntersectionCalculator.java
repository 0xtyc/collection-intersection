
package com.tyc.collectionintersection;

import java.util.HashSet;

public class CollectionIntersectionCalculator {
    static public HashSet<Integer> calculateIntersectionSizeWithHash(int[] collectionToHash, int[] collectionToCheck) {
        HashSet<Integer> collectionSet = new HashSet<>();
        for (int num : collectionToHash) {
            collectionSet.add(num);
        }
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : collectionToCheck) {
            if (collectionSet.contains(num)) {
                intersectionSet.add(num);
            }
        };
        return intersectionSet;
    }

    static public int timeToCalculateIntersectionWithHashing(int[] collectionToHash, int[] collectionToCheck, int runs) {
        int totalTime = 0;
        for (int i = 0; i < runs; i++) {
            totalTime += ExecutionTimer.timeExecution(() -> {
                calculateIntersectionSizeWithHash(collectionToHash, collectionToCheck);
                return null;
            });
        }
        return totalTime / runs;
    }
}
