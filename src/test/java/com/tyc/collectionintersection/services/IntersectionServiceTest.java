package com.tyc.collectionintersection.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tyc.collectionintersection.utils.CollectionIntersectionCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class IntersectionServiceTest {


    @Mock
    private CollectionIntersectionCalculator mockCalculator;

    private IntersectionService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new IntersectionService(10, 50, 100, true);
    }

    @Test
    public void testIntersectionService() {
        assertEquals(10, service.getCollectionToHash().length);
        assertEquals(50, service.getCollectionToCheck().length);
    }

}

