package com.example;

public class DeluxPizza extends Pizza {
    public DeluxPizza(String type, int price) {
        super(type, price);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 100 + 20; // Extra cheese and toppings included
    }
}
