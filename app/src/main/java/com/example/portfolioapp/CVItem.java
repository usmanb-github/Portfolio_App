package com.example.portfolioapp;

public class CVItem {

    static String item;
     String description;

    public CVItem(String item, String description) {
        this.item = item;
        this.description = description;
    }
    public CVItem() {

    }

    public  String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
