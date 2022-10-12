package com.itemis.salestaxesdemo;

import java.util.regex.Pattern;

public class Product {
    private int amount;
    private String article;
    private Double price;
    private Double afterTax;
    private Boolean imported = false;
    private Boolean excepted = false;
    

    public Product(int amount, String article, Double price){
        this.amount = amount;
        this.article = article;
        this.price = price;
        setSaleType(article);
    }

    public int getAmount(){
        return this.amount;
    }

    public String getArticle(){
        return this.article;
    }

    public Double getPrice(){
        return this.price;
    }

    public Double getAfterTax(){
        return this.afterTax;
    }

    public Double setAfterTax(Double amount){
        return this.afterTax = amount;
    }

    public Boolean Imported(){
        return this.imported;
    }

    public Boolean Excepted(){
        return this.excepted;
    }

    public void setSaleType(String details){
        Pattern exceptedPattern = Pattern.compile("book|chocolate|headache pills");
        Pattern importedPattern = Pattern.compile("imported");
        if (exceptedPattern.matcher(article).find()) {
            this.excepted = true;
        }

        if (importedPattern.matcher(article).find()) {
            this.imported = true;
        }
    }
}
