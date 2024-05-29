package com.pluralsight.ui;

import com.pluralsight.application.OrderScreen;

import java.util.Scanner;

public class HomeScreen
{
    private static Scanner userInput = new Scanner(System.in);

    public static void opening()
    {
        System.out.println(Colors.DARK_GREEN + "● ".repeat(19) + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "●"+ " ".repeat(35) + Colors.DARK_GREEN + "● " + Colors.RESET);
        System.out.println(Colors.GREEN + "●  Welcome to Jung 'n' Juicy Deli   ● " + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "●"+ " ".repeat(35)+Colors.DARK_GREEN + "● " + Colors.RESET);
        System.out.println(Colors.DARK_GREEN + "● ".repeat(19) + Colors.RESET);

        System.out.println(Colors.WHITE + "How would you like to proceed?\n\n" + Colors.RESET +
                Colors.WHITE + " 1) New Order\n" + Colors.RESET +
                Colors.PINK + " 2) Exit\n" + Colors.RESET);
        System.out.print(Colors.WHITE +"Please enter your choice here: " + Colors.RESET);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println(Colors.GREEN + "-".repeat(30) + Colors.RESET);
        switch(choice) {
            case 1:
                new OrderScreen();
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
        }

    }
}
