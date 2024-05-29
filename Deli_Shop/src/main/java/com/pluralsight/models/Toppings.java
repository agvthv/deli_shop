package com.pluralsight.models;

public class Toppings {
    private String type;
    private String name;
    private boolean extra;

    public Toppings(String type, String name, boolean extra) {
        this.type = type;
        this.name = name;
        this.extra = extra;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public double getPrice(String size) {
        double price = 0.0;
        switch (type) {
            case "Meat":
                price = getMeatPrice(size);
                break;
            case "Cheese":
                price = getCheesePrice(size);
                break;
            case "Regular":
            case "Sauce":
                price = 0.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid topping type");
        }
        return price;
    }

    private double getMeatPrice(String size) {
        double basePrice;
        double extraPrice;
        switch (size) {
            case "4 inch":
                basePrice = 1.00;
                extraPrice = 0.50;
                break;
            case "8 inch":
                basePrice = 2.00;
                extraPrice = 1.00;
                break;
            case "12 inch":
                basePrice = 3.00;
                extraPrice = 1.50;
                break;
            default:
                throw new IllegalArgumentException("Invalid sandwich size");
        }
        return basePrice + (extra ? extraPrice : 0);
    }

    private double getCheesePrice(String size) {
        double basePrice;
        double extraPrice;
        switch (size) {
            case "4 inch":
                basePrice = 0.75;
                extraPrice = 0.30;
                break;
            case "8 inch":
                basePrice = 1.00;
                extraPrice = 0.60;
                break;
            case "12 inch":
                basePrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                throw new IllegalArgumentException("Invalid sandwich size");
        }
        return basePrice + (extra ? extraPrice : 0);
    }

    @Override
    public String toString() {
        return "Topping{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", extra=" + extra +
                '}';
    }
}
