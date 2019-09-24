package com.payment;

import org.junit.Before;
import org.junit.Test;

public class PriceServiceTest {

    private PriceService instance;

    @Before
    public void setUp() {
        instance = new PriceService();
    }

    @Test
    public void correctPrice() {
        instance.validatePrice(42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroPrice() {
        instance.validatePrice(0);
    }

    @Test
    public void negativePrice() {
        instance.validatePrice(-42);
    }
}