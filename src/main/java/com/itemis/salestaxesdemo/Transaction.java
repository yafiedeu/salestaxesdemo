package com.itemis.salestaxesdemo;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Product> catalogue = new ArrayList<Product>();

    public Product addProduct(int amount, String article, Double price) {
        Product product = new Product(amount, article, price);
        this.catalogue.add(product);
        return product;
    }

    public List<Product> getCatalogue(){
        return this.catalogue;
    }

}