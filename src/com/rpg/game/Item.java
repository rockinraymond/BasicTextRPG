package com.rpg.game;

public class Item {
    private String name;
    private String type; // e.g., "Weapon", "Armor", "Potion"
    private String description;
    private int value; // monetary value of item
    private int weight; //how much an item weighs
    private int damage; //damage value og weapon
    private int armorClass; //AC value for armor
    private char size; //size of weapon
    private int shortRange;
    private int medRange;
    private int longRange;
    private int attackBonus; //used for magical weapons


    // Constructor
    public Item(String name, String type, String description, int value, int weight, int damOrAC, char size, int shortRange, int medRange, int longRange, int attackBonus) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.value = value;
        this.weight = weight;
        if (this.type.equals("Armor") || this.type.equals("Shield")){
            this.armorClass = damOrAC;
        }
        if (this.type.equals("Weapon")){
            this.damage = damOrAC;
            this.size = size;
            this.shortRange = shortRange;
            this.medRange = medRange;
            this.longRange = longRange;
            this.attackBonus = attackBonus;
        }
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

    public int getWeight() {
        return weight;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getDamage() {
        return damage;
    }

    public char getSize(){
        return size;
    }

    public int getShortRange(){
        return shortRange;
    }

    public int getMedRange() {
        return medRange;
    }

    public int getLongRange() {
        return longRange;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    // Display item information
    public void displayItem() {
        System.out.println("Item: " + name + " (" + type + ")");
        System.out.println("Description: " + description);
        System.out.println("Value: " + value);
    }
}

