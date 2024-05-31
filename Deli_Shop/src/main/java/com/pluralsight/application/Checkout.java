package com.pluralsight.application;

import com.pluralsight.ui.Colors;

import java.util.Scanner;

public class Checkout {
    private OrderScreen currentOrder;
    private Scanner scanner;

    public Checkout(OrderScreen currentOrder) {
        this.currentOrder = currentOrder;
        this.scanner = new Scanner(System.in);
        processCheckout();
    }

    private void processCheckout() {
        System.out.print(Colors.WHITE +"Please enter your name for the order: "+ Colors.RESET);
        String customerName = scanner.nextLine().toUpperCase();
        displayOrder(customerName);
        saveOrder(customerName);
    }

    private void displayOrder(String customerName) {
        System.out.println(Colors.WHITE + "\nOrder for: " + customerName + Colors.RESET);
        currentOrder.printOrder();
    }

    private void saveOrder(String customerName) {
        Receipts.saveOrder(currentOrder);
        System.out.println(Colors.WHITE + "Order has been saved for " + customerName + ". Thank you!"+ Colors.RESET);
    }
}
