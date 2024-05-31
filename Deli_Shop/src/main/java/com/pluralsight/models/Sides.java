package com.pluralsight.models;

public class Sides extends Product
{
    private String size;

    public Sides(String size)
    {
        super("Side");
        this.size = size;
    }

    @Override
    public double getPrice()
    {
        switch (size) {
            case "Au Jus":
                return 0;
            case "Sauce":
                return 0;
        }
        return 0;
    }

    @Override
    public String toString()
    {
        return size + " on the " + super.getName();
    }
}
