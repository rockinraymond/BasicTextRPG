package com.rpg.game;

public class Character {
    private String name;
    private String race;
    private String charClass;

    private int level;
    private int xp;
    private int attackBonus;
    private int hitPoints;
    private int maxHitPoints;
    private int armorClass;

    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int wisdom;
    private int charisma;

    private int deathRayPoisonSave;
    private int magicWandSave;
    private int paralysisSave;
    private int dragonBreathSave;
    private int spellSave;

    private Inventory inventory;
    private Item weaponHeld;
    private Item shieldWorn;
    private Item armorWorn;

    // Constructor
    public Character(String name, String race, String charClass, int level,  int maxHitPoints, int strength, int intelligence, int wisdom, int dexterity, int constitution, int charisma) {
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.level = level;
        this.xp = 0;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.strength = strength;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.armorClass = 11;
        this.attackBonus = 0;
        this.inventory = new Inventory(); // Initialize an empty inventory

        this.deathRayPoisonSave = 10;
        this.magicWandSave = 10;
        this.paralysisSave = 10;
        this.dragonBreathSave = 10;
        this.spellSave = 10;

        this.weaponHeld = null;
        this.shieldWorn = null;
        this.armorWorn = null;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void takeDamage(int damage) {
        this.hitPoints -= damage;
        if (this.hitPoints < 0) this.hitPoints = 0;
    }

    public void heal(int amount) {
        this.hitPoints += amount;
        if(this.hitPoints > this.maxHitPoints){
            this.hitPoints = this.maxHitPoints;
        }
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

    public void equipWeapon(Item item) {
        if (item.getType().equals("Weapon")) {
            if (this.weaponHeld != null) {
                this.addItemToInventory(this.weaponHeld);
            }
            this.weaponHeld = item;
            this.removeItemFromInventory((item.getName()));
        } else {
            System.out.println("You cannot wield this item!");
        }
    }

    public void equipArmor(Item item) {
        if (item.getType().equals("Armor")){
            if (this.armorWorn != null)
            {
                this.addItemToInventory(this.armorWorn);
            }
            this.armorWorn = item;
            this.removeItemFromInventory((item.getName()));
        }else{
            System.out.println("You cannot wear this item!");
        }
    }

    public void equipShield(Item item) {
        if (item.getType().equals("Shield")){
            if (this.shieldWorn != null)
            {
                this.addItemToInventory(this.shieldWorn);
            }
            this.shieldWorn = item;
            this.removeItemFromInventory((item.getName()));
        }else{
            System.out.println("You cannot wear this item!");
        }
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
        System.out.println("Level " + level + " " + race + " " + charClass);
        System.out.println("XP: " + xp);
        System.out.println();
        System.out.println("HP: " + hitPoints + "/" + maxHitPoints);
        System.out.println("AB: " + attackBonus);
        System.out.println("AC: " + armorClass);
        System.out.println();
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Wisdom: " + wisdom);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Constitution: " + constitution);
        System.out.println("Charisma: " + charisma);
        System.out.println();
        System.out.println("Saving Throws");
        System.out.println("Death Ray/Poison: " + deathRayPoisonSave);
        System.out.println("Magic Wands:" + magicWandSave);
        System.out.println("Paralysis: " + paralysisSave);
        System.out.println("Dragon Breath: " + dragonBreathSave);
        System.out.println("Rods/Staves/Spells: " + spellSave);

    }
}
