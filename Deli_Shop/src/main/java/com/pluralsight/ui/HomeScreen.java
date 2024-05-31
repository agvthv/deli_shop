package com.pluralsight.ui;

import com.pluralsight.application.Checkout;
import com.pluralsight.application.OrderScreen;
import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Sides;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private static Scanner userInput = new Scanner(System.in);
    private static OrderScreen currentOrder;

    public static void opening() {
        System.out.println(Colors.DARK_GREEN + "● ".repeat(19) + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "●" + " ".repeat(35) + Colors.DARK_GREEN + "● " + Colors.RESET);
        System.out.println(Colors.GREEN + "●  Welcome to Jung 'n' Juicy Deli   ● " + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "●" + " ".repeat(35) + Colors.DARK_GREEN + "● " + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "● ".repeat(19) + Colors.RESET);

        System.out.println(Colors.WHITE + "How would you like to proceed?\n\n" + Colors.RESET +
                Colors.WHITE + " 1) New Order\n" + Colors.RESET +
                Colors.PINK + " 2) Exit\n" + Colors.RESET);
        System.out.print(Colors.WHITE + "Please enter your choice here: " + Colors.RESET);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        switch (choice) {
            case 1:
                currentOrder = new OrderScreen();
                order();
                break;
            case 2:
                System.out.println(Colors.PINK + "Application shutting down" + Colors.RESET);
                for (int i = 0; i < 20; i++) {
                    int repeat = i % 5;
                    System.out.print(".".repeat(repeat) + "\r");
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("See you next time.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                opening();
                break;
        }
    }

    public static void order() {
        System.out.println(Colors.WHITE + "What would you like to do: \n" + Colors.RESET);
        System.out.println(Colors.WHITE + "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Add Sides\n5) Checkout\n0) Cancel Order\n" + Colors.RESET);
        System.out.print(Colors.WHITE + "Please enter your choice here: " + Colors.RESET);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        switch (choice) {
            case 1:
                addSandwich();
                break;
            case 2:
                addDrink();
                break;
            case 3:
                addChips();
                break;
            case 4:
                addSides();
                break;
            case 5:
                new Checkout(currentOrder);
                break;
            case 0:
                opening();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                order();
                break;
        }
    }

    private static void addSandwich() {
        System.out.println(Colors. GREEN + "Select bread: white, wheat, rye, wrap" +Colors.RESET);
        String bread = userInput.nextLine();
        System.out.println();
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println(Colors.WHITE + "Select size: 4\", 8\", 12\"" + Colors.RESET);
        String size = userInput.nextLine();
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();

        List<String> meats = new ArrayList<>();
        boolean extraMeat = false;
        System.out.println(Colors.WHITE + "Select meats: steak, ham, salami, roast beef, chicken, bacon" + Colors.RESET);
        System.out.println((Colors.RED +"Type 'done' to finish: " + Colors.RESET));
        while (true) {
            String meat = userInput.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            meats.add(meat);
            System.out.println(Colors.WHITE + "Would you like extra meat for " + meat + "? (yes/no)" + Colors.RESET);
            if (userInput.nextLine().equalsIgnoreCase("yes")) {
                extraMeat = true;
            }
        }

        List<String> cheeses = new ArrayList<>();
        boolean extraCheese = false;
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Select cheeses : american, provolone, cheddar, swiss" + Colors.RESET);
        System.out.println((Colors.RED +"Type 'done' to finish: " + Colors.RESET));
        while (true) {
            String cheese = userInput.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;
            cheeses.add(cheese);
            System.out.println(Colors.WHITE +"Would you like extra cheese for " + cheese + "? (yes/no)" + Colors.RESET);
            if (userInput.nextLine().equalsIgnoreCase("yes")) {
                extraCheese = true;
            }
        }

        List<String> regularToppings = new ArrayList<>();
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Select toppings: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms" + Colors.RESET);
        System.out.println((Colors.RED +"Type 'done' to finish: " + Colors.RESET));
        while (true) {
            String topping = userInput.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            regularToppings.add(topping);
        }

        List<String> sauces = new ArrayList<>();
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Select sauces: mayo, mustard, ketchup, ranch, thousand islands, vinaigrette" + Colors.RESET);
        System.out.println((Colors.RED +"Type 'done' to finish: " + Colors.RESET));
        while (true) {
            String sauce = userInput.nextLine();
            if (sauce.equalsIgnoreCase("done")) break;
            sauces.add(sauce);


        }
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Would you like the sandwich toasted? (yes/no)" + Colors.RESET);
        boolean toasted = userInput.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, meats, cheeses, regularToppings, sauces, toasted, extraMeat, extraCheese);
        currentOrder.addProduct(sandwich);
        order();

    }

    private static void addDrink() {
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Select coke size: Small, Medium, Large" + Colors.RESET);
        String size = userInput.nextLine();
        Drink drink = new Drink(size);
        currentOrder.addProduct(drink);
        order();

    }

    private static void addChips()
    {
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Would you like to add chips for $1.50?: " + Colors.RESET);
        String type = userInput.nextLine();
        Chips chips = new Chips(type);
        currentOrder.addProduct(chips);
        order();
    }
    private static void addSides() {
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        System.out.println();
        System.out.println(Colors.GREEN + "Pick a side: Au Jus, Sauce, none " + Colors.RESET);
        String size = userInput.nextLine();
        Sides sides = new Sides(size);
        currentOrder.addProduct(sides);
        order();

    }
}
