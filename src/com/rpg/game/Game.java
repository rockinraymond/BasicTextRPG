package com.rpg.game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Basic Fantasy RPG!");

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();


        Character player = new Character(name, "Human", "Fighter", 1, 8, 15,7,9,12,13,10); // Initial player stats
        player.printStats();

        // Add some starting items to the player's inventory
        player.addItemToInventory(new Item("Sword", "Weapon", "A sharp blade", 5));
        player.addItemToInventory(new Item("Health Potion", "Potion", "Restores health", 10));

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore");
            System.out.println("2. View Stats");
            System.out.println("3. View Inventory");
            System.out.println("4. Use Item");
            System.out.println("5. Exit Game");

            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    Enemy enemy = generateRandomEnemy();
                    Combat.fight(player, enemy);
                    break;
                case 2:
                    player.printStats();
                    break;
                case 3:
                    player.viewInventory();
                    break;
                case 4:
                    System.out.print("Enter the name of the item you want to use: ");
                    String itemName = scanner.nextLine();
                    player.useItem(itemName);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (player.getHitPoints() <= 0) {
                System.out.println("Game Over!");
                break;
            }
        }

        scanner.close();
    }

    // Optional: Method to generate random enemies
    private static Enemy generateRandomEnemy() {
        String[] enemyNames = {"Goblin", "Orc", "Skeleton", "Troll"};
        String name = enemyNames[(int) (Math.random() * enemyNames.length)];
        int health = 8 + (int) (Math.random() * 5); // Health between 8 and 12
        int attackPower = 3 + (int) (Math.random() * 3); // Attack power between 3 and 5
        return new Enemy(name, health, attackPower);
    }
}
