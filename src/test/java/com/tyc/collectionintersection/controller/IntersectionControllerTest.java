package com.tyc.collectionintersection.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IntersectionControllerTest {

    private IntersectionController controller = Mockito.spy(new IntersectionController());

    @Test
    void testValidateCollectionSize() {
        assertEquals(false, controller.validateCollectionSize("100", "invalid"));
        assertEquals(false, controller.validateCollectionSize("100", "-1"));
        assertEquals(true, controller.validateCollectionSize("100", "100"));
    }

    @Test
    void testValidateUpperBound() {
        when(controller.getSizeA()).thenReturn(100);
        when(controller.getSizeB()).thenReturn(10);
        assertEquals(false, controller.validateUpperBound("10"));
        assertEquals(false, controller.validateUpperBound("-1"));
        assertEquals(true, controller.validateUpperBound("200"));
    }
}
