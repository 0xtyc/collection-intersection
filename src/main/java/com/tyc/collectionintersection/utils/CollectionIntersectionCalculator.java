
package com.tyc.collectionintersection.utils;

import java.util.HashSet;

public class CollectionIntersectionCalculator {
    /**
     * Calculate the intersection of two collections using a HashSet.
     * @param collectionToHash The collection to hash.
     * @param collectionToCheck The collection to check for intersection.
     * @return A HashSet containing the intersection of the two collections.
     */

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
}
