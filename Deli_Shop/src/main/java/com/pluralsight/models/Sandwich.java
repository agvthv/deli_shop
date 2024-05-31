package com.pluralsight.models;

import com.pluralsight.ui.Colors;

import java.awt.*;
import java.util.List;

public class Sandwich extends Product {
    private String size;
    private String bread;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private boolean toasted;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String size, String bread, List<String> meats, List<String> cheeses,
                    List<String> regularToppings, List<String> sauces, boolean toasted,
                    boolean extraMeat, boolean extraCheese) {
        super("Sandwich");
        this.size = size;
        this.bread = bread;
        this.meats = meats;
        this.cheeses = cheeses;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
        this.toasted = toasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    @Override
    public double getPrice() {
        double price = 0;
        int meatCount = meats.size();
        int cheeseCount = cheeses.size();

        switch (size) {
            case "4":
                price += 5.50;
                if (meatCount > 0) {
                    price += 1.00 + (meatCount - 1) * 0.50;
                }
                if (cheeseCount > 0) {
                    price += 0.75 + (cheeseCount - 1) * 0.30;
                }
                if (extraMeat) price += 0.50;
                if (extraCheese) price += 0.30;
                break;
            case "8":
                price += 7.00;
                if (meatCount > 0) {
                    price += 2.00 + (meatCount - 1) * 1.00;
                }
                if (cheeseCount > 0) {
                    price += 1.50 + (cheeseCount - 1) * 0.60;
                }
                if (extraMeat) price += 1.00;
                if (extraCheese) price += 0.60;
                break;
            case "12":
                price += 8.50;
                if (meatCount > 0) {
                    price += 3.00 + (meatCount - 1) * 1.50;
                }
                if (cheeseCount > 0) {
                    price += 2.25 + (cheeseCount - 1) * 0.90;
                }
                if (extraMeat) price += 1.50;
                if (extraCheese) price += 0.90;
                break;
        }
        return price;
    }

    @Override
    public String toString() {
        return size + " " + super.getName() + " on " + bread + (toasted ? " (toasted)" : "") +
                " \n + " + String.join(", ", meats)+ (extraMeat ? " (extra meat)" : "") + "\n + "

                + String.join(", ", cheeses)+ (extraCheese ? " (extra cheese)" : "") + "\n + " + String.join(", ", regularToppings)
                + "\n + " + String.join(", ", sauces);
    }
}
