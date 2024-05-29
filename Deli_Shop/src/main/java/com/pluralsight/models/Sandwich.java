package com.pluralsight.models;

import java.util.List;

public class Sandwich extends Product
{

    private String size; // e.g., 4 inch, 8 inch, 12 inch
    private String breadType; // e.g., White, Wheat, Rye, Wrap
    private List<Toppings> toppings; // List of toppings

    public Sandwich(String name, String size, String breadType, List<Toppings> toppings)
    {
        super();
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
        setPrice(calculatePrice(size, toppings)); // Recalculate price when size changes
    }

    public String getBreadType()
    {
        return breadType;
    }

    public void setBreadType(String breadType)
    {
        this.breadType = breadType;
    }

    public List<Toppings> getToppings()
    {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings)
    {
        this.toppings = toppings;
        setPrice(calculatePrice(size, toppings));
    }

    @Override
    public String getProductType()
    {
        return "Sandwich";
    }

    @Override
    public String toString()
    {
        return super.toString() + ", size='" + size + "', breadType='" + breadType + "', toppings=" + toppings;
    }

    private static double calculatePrice(String size, List<Toppings> toppings)
    {
        double basePrice;
        switch (size) {
            case "4 inch":
                basePrice = 5.50;
                break;
            case "8 inch":
                basePrice = 7.00;
                break;
            case "12 inch":
                basePrice = 8.50;
                break;
            default:
                throw new IllegalArgumentException("Invalid sandwich size");
        }
        double toppingsPrice = toppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        return basePrice + toppingsPrice;
    }


}


