package com.tyc.collectionintersection;

public class CollectionGenerator {

    private int maxValue;

    public CollectionGenerator() {
        this.maxValue = Integer.MAX_VALUE;
    }

    public CollectionGenerator(int maxValue) {
        this.maxValue = maxValue;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * this.maxValue);
    }

    public int[] generateCollection(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int[] collection = new int[size];
        for (int i = 0; i < size; i++) {
            collection[i] = this.generateRandomNumber();
        }
        return collection;
    }
}
