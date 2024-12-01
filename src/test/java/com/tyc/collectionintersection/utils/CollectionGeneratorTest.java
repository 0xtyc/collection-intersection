package com.tyc.collectionintersection.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionGeneratorTest {

    @Test
    public void testDefaultConstructor() {
        CollectionGenerator generator = new CollectionGenerator();
        assertEquals(Integer.MAX_VALUE, generator.getUpperBound());
    }

    @Test
    public void testParameterizedConstructor() {
        int upperBound = 100;
        CollectionGenerator generator = new CollectionGenerator(upperBound);
        assertEquals(upperBound, generator.getUpperBound());
    }

    @Test
    public void testGenerateCollectionWithValidSize() {
        CollectionGenerator generator = new CollectionGenerator(20);
        int[] collection = generator.generateCollection(5);
        assertEquals(5, collection.length);
        for (int num : collection) {
            assertTrue(num >= 0 && num < 20);
        }
    }

    @Test
    public void testGenerateCollectionWithNegativeSize() {
        CollectionGenerator generator = new CollectionGenerator();
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateCollection(-1);
        });
    }
}