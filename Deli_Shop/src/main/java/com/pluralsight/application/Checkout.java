package com.pluralsight.application;

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
        System.out.print("Please enter your name for the order: ");
        String customerName = scanner.nextLine();
        displayOrder(customerName);
        saveOrder(customerName);
    }

    private void displayOrder(String customerName) {
        System.out.println("\nOrder for: " + customerName);
        currentOrder.printOrder();
    }

    private void saveOrder(String customerName) {

        System.out.println("Order has been saved for " + customerName + ". Thank you!");
    }
}
