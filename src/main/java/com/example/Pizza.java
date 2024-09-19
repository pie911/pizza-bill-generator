package com.example;

public class Pizza {
    private String type;
    private int price;

    public Pizza(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
