package com.pluralsight.application;

import com.pluralsight.models.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderScreen {
    private List<Product> products;

    public OrderScreen() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printOrder() {
        System.out.println("Order Details:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total: $" + calculateTotal());
    }

    public List<Product> getProducts() {
        return products;
    }
}
