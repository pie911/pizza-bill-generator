package com.example;

import java.util.Scanner;

public class BillGenerator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Select Pizza Type:");
            System.out.println("1. Veg Pizza");
            System.out.println("2. Non-Veg Pizza");
            System.out.println("3. Delux Veg Pizza");
            System.out.println("4. Delux Non-Veg Pizza");

            int choice = scanner.nextInt();
            Pizza pizza = null;

            switch (choice) {
                case 1:
                    pizza = new Pizza("Veg Pizza", 300);
                    break;
                case 2:
                    pizza = new Pizza("Non-Veg Pizza", 400);
                    break;
                case 3:
                    pizza = new DeluxPizza("Delux Veg Pizza", 550);
                    break;
                case 4:
                    pizza = new DeluxPizza("Delux Non-Veg Pizza", 650);
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(0);
            }

            System.out.println("Do you want extra cheese? (yes/no)");
            String extraCheese = scanner.next();
            int extraCheeseCost = extraCheese.equalsIgnoreCase("yes") ? 100 : 0;

            System.out.println("Do you want extra toppings? (yes/no)");
            String extraToppings = scanner.next();
            int extraToppingsCost = extraToppings.equalsIgnoreCase("yes") ? 20 : 0;

            System.out.println("Do you want take away? (yes/no)");
            String takeAway = scanner.next();
            int packagingCost = takeAway.equalsIgnoreCase("yes") ? 20 : 0;

            int totalCost = pizza.getPrice() + extraCheeseCost + extraToppingsCost + packagingCost;

            System.out.println("Total Bill: ₹" + totalCost);
        }
    }
}
