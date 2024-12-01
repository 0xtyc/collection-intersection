package com.tyc.collectionintersection.utils;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionIntersectionCalculatorTest {

    @Test
    public void testCalculateIntersectionSizeWithHash() {
        // Test input arrays
        int[] collectionA = {1, 2, 3, 4, 5, 4, 5};
        int[] collectionB = {3, 4, 5, 6, 7, 4};

        // Expected intersection
        HashSet<Integer> expectedIntersection = new HashSet<>();
        expectedIntersection.add(3);
        expectedIntersection.add(4);
        expectedIntersection.add(5);

        // Assert the result for both orders
        assertEquals(expectedIntersection, CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(collectionA, collectionB));
        assertEquals(expectedIntersection, CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(collectionB, collectionA));
    }
}