package com.pluralsight.models;
import com.pluralsight.models.Product;

public class Chips extends Product {
    public Chips(String type) {
        super(type + " Chips");
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
