package com.pluralsight.application;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;
import com.pluralsight.ui.Colors;
import com.pluralsight.ui.HomeScreen;

import java.util.Scanner;

public class OrderScreen
{
    public static Scanner userInput = new Scanner(System.in);

    public static void order()
    {
        System.out.println(Colors.WHITE + "What would you like to do: \n" + Colors.RESET);
        System.out.println(Colors.WHITE + "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel Order\n" + Colors.RESET);
        System.out.print(Colors.WHITE + "Please enter your choice here: " + Colors.RESET);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        switch (choice) {
            case 1:
                new Sandwich();
                break;
            case 2:
                new Drink();
                break;
            case 3:
                new Chips();
                break;
            case 4:
                new Checkout();
                break;
            case 0:
                 HomeScreen.opening();
                break;
        }

    }
}
