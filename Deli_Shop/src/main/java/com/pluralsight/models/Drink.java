package com.pluralsight.models;
import com.pluralsight.models.Product;
import com.pluralsight.ui.Colors;

public class Drink extends Product {
    private String size;

    public Drink(String size) {
        super("Drink");
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        return size + " " + super.getName() ;
    }
}
