package com.itemis.salestaxesdemo;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ComputePriceTest {
    private Transaction transaction;
    private Product productA;
    private Product productB;
    private Product productC;
    private ComputePrice counter;

    @Before
    public void setUp() {
        transaction = new Transaction();
        productA = transaction.addProduct(1, "book", 12.49);
        productB = transaction.addProduct(1, "music CD", 14.99);
        productC = transaction.addProduct(1, "chocolate bar", 0.85);
        counter = new ComputePrice(transaction.getCatalogue());
    }


    @Test
    public void counterCalculateAccurateTotalCost() throws Exception {
        Double expectedTotalCost = 29.83;
        Double totalCost  = Math.floor(counter.getTotalCost() * 100) / 100;
        assertEquals(expectedTotalCost, totalCost);
    }

    @Test
    public void counterCalculateAccurateTaxCost() throws Exception {
        Double expectedTaxCost = 29.83;
        Double taxCost  = Math.floor(counter.getTotalCost() * 100) / 100;

        assertEquals(expectedTaxCost, taxCost);
    }


}