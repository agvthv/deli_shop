package com.pluralsight.models;
import com.pluralsight.models.Product;
import com.pluralsight.ui.Colors;

public class Chips extends Product {
    public Chips(String type) {
        super("Lays");
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
