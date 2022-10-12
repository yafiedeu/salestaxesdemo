package com.itemis.salestaxesdemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    private Product product;
    private int amount;
    private String article;
    private Double price;

    @Before
    public void setUp() {
        amount = 2;
        article = "Eclat Perfume 950";
        price = 11.49;
        product = new Product(amount, article, price);
    }

    @Test
    public void getAmountReturnsAccurateAmount() throws Exception {
        assertEquals(amount, product.getAmount());
    }

    @Test
    public void getArticleReturnsAccurateArticle() throws Exception {
        assertEquals(article, product.getArticle());
    }

    @Test
    public void getPriceReturnsAccuratePrice() throws Exception {
        assertEquals(price, product.getPrice());
    }

    @Test
    public void getAfterTaxIsNullIfNotSet() throws Exception {
        assertEquals(null, product.getAfterTax());
    }
    
    @Test
    public void setAfterTaxReturnsAccurateAfterTaxPrice() throws Exception {
        Double amount = 2.00;

        product.setAfterTax(amount);

        assertEquals(amount, product.getAfterTax());
    }
    
    @Test
    public void ImportedIsCorrectlyConfigured() throws Exception {
        String importedArticle = "imported articles";

        Product importedProduct = new Product( amount, importedArticle, price);

        assertEquals(true, importedProduct.Imported());
        assertEquals(false, product.Imported());
    }

    @Test
    public void ExceptedIsCorrectlyConfigured() throws Exception {
        String exceptedArticle = "pills, chocolate and book ";

        Product exceptedProduct = new Product( amount, exceptedArticle, price);

        assertEquals(true, exceptedProduct.Excepted());
        assertEquals(false, product.Excepted());
    }


}