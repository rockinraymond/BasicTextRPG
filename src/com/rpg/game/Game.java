package com.rpg.game;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        DiceRoller diceRoller = new DiceRoller();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Basic Fantasy RPG!");

        Character player = createNewCharacter(scanner, diceRoller);
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

    private static Character createNewCharacter(Scanner scanner, DiceRoller diceRoller) {
        // List of valid races/classes
        List<String> validRaces = Arrays.asList("Human", "Elf", "Dwarf", "Halfling");
        List<String> validClasses = Arrays.asList("Fighter", "Thief", "Cleric", "Magic-User");
        boolean validInput = false;

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        String race = "";
        // Keep asking until the user enters a valid race
        while (!validInput) {
            System.out.print("Enter your character's race (Human, Elf, Dwarf, Halfling): ");
            race = scanner.nextLine();
            if (validRaces.contains(race)) {
                validInput = true; // Valid race found, exit loop
            } else {
                System.out.println("Invalid race! Please choose again.");
            }
        }

        validInput = false;
        String charClass = "";
        // Keep asking until the user enters a valid race
        while (!validInput) {
            System.out.print("Enter your character's class (Fighter, Thief, Cleric, Magic-User): ");
            charClass = scanner.nextLine();
            if (validClasses.contains(charClass)) {
                validInput = true; // Valid class found, exit loop
            } else {
                System.out.println("Invalid class! Please choose again.");
            }
        }

        int[] abilityScores = rollAbilityScores(diceRoller);
        int[] assignedScores = assignScoresToAttributes(charClass, race, abilityScores);
        int startingHP = assignStartingHP(charClass, race);

        return new Character(name, race, charClass, 1, startingHP, assignedScores[0], assignedScores[1], assignedScores[2], assignedScores[3],assignedScores[4],assignedScores[5]);
    }

    // Function to roll 3D6 six times
    public static int[] rollAbilityScores(DiceRoller diceRoller) {
        int[] abilityScores = new int[6];
        for (int i = 0; i < 6; i++) {
            abilityScores[i] = diceRoller.roll3D6();
        }
        Arrays.sort(abilityScores); // Sort to allow optimal assignment
        return abilityScores;
    }

    public static int calculateAbilityBonus(int abilityScore){
        if (abilityScore == 3) {
            return -3;
        } else if (abilityScore >= 4 && abilityScore <= 5) {
            return -2;
        } else if (abilityScore >= 6 && abilityScore <= 8) {
            return -1;
        } else if (abilityScore >= 9 && abilityScore <= 12) {
            return 0;
        } else if (abilityScore >= 13 && abilityScore <= 15) {
            return 1;
        } else if (abilityScore >= 16 && abilityScore <= 17) {
            return 2;
        } else if (abilityScore == 18) {
            return 3;
        } else {
            throw new IllegalArgumentException("Invalid ability score");
        }
    }

    // Function to assign scores to attributes based on chosen class
    public static int[] assignScoresToAttributes(String chosenClass, String chosenRace, int[] scores) {
        int[] assignedScores = new int[6]; // Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma

        switch (chosenClass) {
            case "Fighter":
                assignedScores[0] = scores[5]; // Highest score to Strength
                assignedScores[1] = scores[4]; // Second highest to Dexterity
                assignedScores[2] = scores[3]; // Third highest to Constitution
                assignedScores[4] = scores[2]; // Wisdom
                assignedScores[3] = scores[1]; // Intelligence
                assignedScores[5] = scores[0]; // Charisma
                break;
            case "Magic User":
                assignedScores[3] = scores[5]; // Highest to Intelligence
                assignedScores[4] = scores[4]; // Second highest to Wisdom
                assignedScores[1] = scores[3]; // Dexterity
                assignedScores[5] = scores[2]; // Charisma
                assignedScores[2] = scores[1]; // Constitution
                assignedScores[0] = scores[0]; // Strength
                break;
            case "Thief":
                assignedScores[1] = scores[5]; // Highest to Dexterity
                assignedScores[0] = scores[4]; // Second highest to Strength
                assignedScores[5] = scores[3]; // Charisma
                assignedScores[3] = scores[2]; // Intelligence
                assignedScores[2] = scores[1]; // Constitution
                assignedScores[4] = scores[0]; // Wisdom
                break;
            case "Cleric":
                assignedScores[4] = scores[5]; // Highest to Wisdom
                assignedScores[2] = scores[4]; // Second highest to Constitution
                assignedScores[5] = scores[3]; // Charisma
                assignedScores[0] = scores[2]; // Strength
                assignedScores[3] = scores[1]; // Intelligence
                assignedScores[1] = scores[0]; // Dexterity
                break;
            default:
                System.out.println("Unknown class. No attributes assigned.");
                break;
        }
        //add race mods
        switch(chosenRace){
            case "Dwarf":
                assignedScores[2] += 1;
                assignedScores[5] -= 1;
                break;
            case "Halfling":
                assignedScores[1] += 1;
                assignedScores[0] -= 1;
                break;
            case "Elf":
                assignedScores[3] += 1;
                assignedScores[2] -= 1;
                break;
        }
        return assignedScores;
    }

    public static int assignStartingHP(String chosenClass, String chosenRace){
    int hitPoints;
    switch (chosenClass){
        case "Fighter":
            hitPoints = 8;
            break;
        case "Cleric":
        case "Thief":
            hitPoints = 6;
            break;
        default: //Magic Users and others
            hitPoints = 4;
            break;
    }
    if (chosenRace.equals("Elf") || chosenRace.equals("Halfling")){
        if (hitPoints > 6){
            hitPoints = 6;
        }
    }
    return hitPoints;
    }
}
