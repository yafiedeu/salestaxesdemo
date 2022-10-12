package com.itemis.salestaxesdemo;

import java.util.List;

public class ComputePrice {
	private Double productCost = 0.00;
	private Double taxCost = 0.00;
    private Double totalCost = 0.00;

    public ComputePrice(List<Product> products){
        for(Product product: products){
            this.productCost = this.productCost + (product.getPrice() * product.getAmount());
            this.taxCost = this.taxCost + computeTotalTax(product);
        }
        this.totalCost = this.productCost + this.taxCost;
    }

    private Double computeTotalTax(Product product){
        Double tax = .10;
        if (product.Excepted()){
            tax = .00;
        }

        if (product.Imported()){
            tax = tax + .05;
        }
        Double rounded = roundAmount((product.getPrice()*tax) * product.getAmount());
        product.setAfterTax(rounded + (product.getPrice() * product.getAmount()));
        return rounded;
    }

    public Double getTaxCost() {
        return this.taxCost;
    }

    public Double getTotalCost() {
        return this.totalCost;
    }

    private Double roundAmount(Double amount){
        return Math.ceil((amount * 20.0)) / 20.0;
    }

    private Double computeTotalCost(){
        return this.totalCost = (this.taxCost + this.productCost);
    }
}