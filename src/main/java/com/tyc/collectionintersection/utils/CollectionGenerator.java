package com.tyc.collectionintersection.utils;

public class CollectionGenerator {

    private int upperBound;

    public CollectionGenerator() {
        this.upperBound = Integer.MAX_VALUE;
    }

    public CollectionGenerator(int upperBound) {
        this.upperBound = upperBound;
    }

    protected int getUpperBound() {
        return this.upperBound;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * this.upperBound);
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
