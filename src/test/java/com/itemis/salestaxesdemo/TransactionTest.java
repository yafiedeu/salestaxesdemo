package com.itemis.salestaxesdemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TransactionTest {
    private Transaction transaction;
    private Product product;

    @Before
    public void setUp() {
       transaction = new Transaction();
       product = transaction.addProduct(1, "Rindfleisch Lasagne", 5.99);
    }

    @Test
    public void gettingCatalogueReturnsAList() throws Exception {
        assertEquals(ArrayList.class, transaction.getCatalogue().getClass());
    }
    
    @Test
    public void addingProductsIncrementsCatalogue() throws Exception {
        assertEquals(1, transaction.getCatalogue().size());
    }

    @Test
    public void addingProductsReturnsProducts() throws Exception {
        assertEquals(Product.class, product.getClass());
    }
}