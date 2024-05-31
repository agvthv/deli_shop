package com.pluralsight.application;

import com.pluralsight.models.Product;
import com.pluralsight.ui.Colors;

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
        System.out.println(Colors.WHITE +"Order Details:" + Colors.RESET);
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println(Colors.TRUE_GREEN +"-".repeat(19)+Colors.RESET);
        System.out.println(Colors.WHITE + "Total: $" + calculateTotal() + Colors.RESET);
    }

    public List<Product> getProducts() {
        return products;
    }
}
