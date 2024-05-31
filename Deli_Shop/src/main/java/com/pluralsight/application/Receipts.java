package com.pluralsight.application;

import com.pluralsight.models.Product;
import com.pluralsight.ui.Colors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipts {
    public static void saveOrder(OrderScreen order) {
        String directoryPath = "receipts";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        try (FileWriter writer = new FileWriter(directoryPath + "/" + timestamp + ".txt")) {
            writer.write("Recent Order Details:\n\n");
            for (Product product : order.getProducts()) {
                writer.write(product.toString() + "\n");
            }
            writer.write( "Total: $" + order.calculateTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
