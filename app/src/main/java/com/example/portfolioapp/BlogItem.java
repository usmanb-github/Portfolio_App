package com.example.portfolioapp;

import android.graphics.Color;

public class BlogItem {

    static String item;
    Color description;

    public BlogItem(String item, Color description) {
        this.item = item;
        this.description = description;
    }

    public BlogItem(String item) {
        this.item = item;
    }

    public  String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Color getDescription() {
        return description;
    }

    public void setDescription(Color description) {
        this.description = description;
    }
}
