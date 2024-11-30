package com.tyc.collectionintersection;

public class IntersectionService {

    private CollectionGenerator collectionGenerator;
    private int[] collectionA;
    private int[] collectionB;
    private boolean hashCollectionA;


    public IntersectionService(int sizeA, int sizeB, int maxValue, boolean hashCollectionA) {
        this.collectionGenerator = new CollectionGenerator(maxValue);
        this.collectionA = this.collectionGenerator.generateCollection(sizeA);
        this.collectionB = this.collectionGenerator.generateCollection(sizeB);
        this.hashCollectionA = hashCollectionA;
    }

    public int getIntersectionSize() {
        if (this.hashCollectionA) {
            return CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(this.collectionA, this.collectionB).size();
        } else {
            return CollectionIntersectionCalculator.calculateIntersectionSizeWithHash(this.collectionB, this.collectionA).size();
        }
    }

    public int getTimeToCalculateIntersection() {
        final int runs = 10; // run 10 times to get a good average
        if (this.hashCollectionA) {
            return CollectionIntersectionCalculator.timeToCalculateIntersectionWithHashing(this.collectionA, this.collectionB, runs);
        } else {
            return CollectionIntersectionCalculator.timeToCalculateIntersectionWithHashing(this.collectionB, this.collectionA, runs);
        }
    }
}
