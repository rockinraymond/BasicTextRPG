package com.rpg.game;

public class Item {
    private String name;
    private String type; // e.g., "Weapon", "Armor", "Potion"
    private String description;
    private int value; // This could be the damage for a weapon, defense for armor, healing amount for a potion

    // Constructor
    public Item(String name, String type, String description, int value) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.value = value;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    // Display item information
    public void displayItem() {
        System.out.println("Item: " + name + " (" + type + ")");
        System.out.println("Description: " + description);
        System.out.println("Value: " + value);
    }
}

