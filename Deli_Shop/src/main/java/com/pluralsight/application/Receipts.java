package com.pluralsight.application;

import com.pluralsight.models.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipts {
    public static void saveOrder(OrderScreen order) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        try (FileWriter writer = new FileWriter("receipts/" + timestamp + ".txt")) {
            writer.write("Order Details:\n");
            for (Product product : order.getProducts()) {
                writer.write(product.toString() + "\n");
            }
            writer.write("Total: $" + order.calculateTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
