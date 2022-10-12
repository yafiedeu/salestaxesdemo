package com.itemis.salestaxesdemo;

import com.itemis.salestaxesdemo.ComputePrice;
import com.itemis.salestaxesdemo.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputOutputTest {
    private Transaction transaction;
    private ComputePrice counter;
    private Double expectedTotalCost;
    private Double expectedTaxCost;
    private Double totalCost;
    private Double taxCost;


    @Before
    public void setUp(){
        transaction = new Transaction();
    }

    @Test
    public void inputOutput1()throws Exception {
        transaction.addProduct(1, "book", 12.49);
        transaction.addProduct(1, "music CD", 14.99);
        transaction.addProduct(1, "chocolate bar", 0.85);
        counter = new ComputePrice(transaction.getCatalogue());
        expectedTotalCost = 29.83;
        expectedTaxCost = 1.50;

        totalCost = (double) Math.round(counter.getTotalCost() * 100) / 100;
        taxCost  = (double) Math.round(counter.getTaxCost() * 100) / 100;

        assertEquals(expectedTotalCost, totalCost);
        assertEquals(expectedTaxCost, taxCost);

    }


    @Test
    public void inputOutput2()throws Exception {
        transaction.addProduct(1, "imported box of chocolates", 10.00);
        transaction.addProduct(1, "imported bottle of perfume", 47.50);
        counter = new ComputePrice(transaction.getCatalogue());
        expectedTotalCost = 65.15;
        expectedTaxCost = 7.65;

        totalCost = (double) Math.round(counter.getTotalCost() * 100) / 100;
        taxCost  = (double) Math.round(counter.getTaxCost() * 100) / 100;

        assertEquals(expectedTotalCost, totalCost);
        assertEquals(expectedTaxCost, taxCost);
        
    }

    @Test
    public void inputOutput3()throws Exception {
        transaction.addProduct(1, "imported bottle of perfume", 27.99);
        transaction.addProduct(1, "bottle of perfume", 18.99);
        transaction.addProduct(1, "packet of headache pills", 9.75);
        transaction.addProduct(1, "box of imported chocolates", 11.25);
        counter = new ComputePrice(transaction.getCatalogue());
        expectedTotalCost = 74.68;
        expectedTaxCost = 6.70;

        totalCost = (double) Math.round(counter.getTotalCost() * 100) / 100;
        taxCost  = (double) Math.round(counter.getTaxCost() * 100) / 100;

        assertEquals(expectedTotalCost, totalCost);
        assertEquals(expectedTaxCost, taxCost);
    }

}