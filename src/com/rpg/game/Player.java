package com.rpg.game;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int armorClass;
    private Inventory inventory;

    // Constructor
    public Player(String name, int health, int strength, int dexterity, int intelligence, int armorClass) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.armorClass = armorClass;
        this.inventory = new Inventory(); // Initialize an empty inventory
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int attack() {
        return (int) (Math.random() * strength); // Attack based on strength
    }

    // Inventory methods
    public void addItemToInventory(Item item) {
        inventory.addItem(item);
    }

    public void removeItemFromInventory(String itemName) {
        inventory.removeItem(itemName);
    }

    public void viewInventory() {
        inventory.viewInventory();
    }

    public void useItem(String itemName) {
        Item item = inventory.useItem(itemName);
        if (item != null) {
            switch (item.getType()) {
                case "Weapon":
                    System.out.println("You attack with " + item.getName() + "!");
                    // Add weapon's value to strength temporarily
                    break;
                case "Potion":
                    System.out.println("You drink a potion and heal " + item.getValue() + " HP.");
                    heal(item.getValue()); // Heal the player
                    break;
                default:
                    System.out.println("You can't use this item right now.");
            }
        }
    }

    public void printStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Armor Class: " + armorClass);
    }
}
