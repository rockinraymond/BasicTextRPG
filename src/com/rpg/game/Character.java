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
    public Character(String name, String race, String charClass, int level,  int maxHitPoints, int strength,int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.level = level;
        this.xp = 0;
        this.strength = strength;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

        this.maxHitPoints = maxHitPoints + calculateAbilityBonus(this.constitution);
        this.hitPoints = this.maxHitPoints;
        this.armorClass = 11;
        this.attackBonus = 0;
        this.inventory = new Inventory(); // Initialize an empty inventory

        int [] savingThrows = assignStartingSavingThrows(charClass,race);
        this.deathRayPoisonSave = savingThrows[0];
        this.magicWandSave = savingThrows[1];
        this.paralysisSave = savingThrows[2];
        this.dragonBreathSave = savingThrows[3];
        this.spellSave = savingThrows[4];

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
            System.out.println("You equip " + this.weaponHeld.getName());
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
            System.out.println("You equip " + this.armorWorn.getName());
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
            System.out.println("You equip " + this.shieldWorn.getName());
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
                    equipWeapon(item);
                    break;
                case "Armor":
                    equipArmor(item);
                    break;
                case "Shield":
                    equipShield(item);
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

    // Function to assign stating saving throws based on class and race.
    public static int[] assignStartingSavingThrows(String chosenClass, String chosenRace) {
        int[] savingThrows = new int[5]; // DeathRay, Wands, Paralysis, DragonBreath, Spells

        switch (chosenClass) {
            case "Fighter":
                savingThrows[0] = 12;
                savingThrows[1] = 13;
                savingThrows[2] = 14;
                savingThrows[3] = 15;
                savingThrows[4] = 17;
                break;
            case "Magic User":
                savingThrows[0] = 13;
                savingThrows[1] = 14;
                savingThrows[2] = 13;
                savingThrows[3] = 16;
                savingThrows[4] = 15;
                break;
            case "Thief":
                savingThrows[0] = 13;
                savingThrows[1] = 14;
                savingThrows[2] = 13;
                savingThrows[3] = 16;
                savingThrows[4] = 15;
                break;
            case "Cleric":
                savingThrows[0] = 11;
                savingThrows[1] = 12;
                savingThrows[2] = 14;
                savingThrows[3] = 16;
                savingThrows[4] = 15;
                break;
            default:
                System.out.println("Unknown class. No saving throws assigned.");
                break;
        }

        switch (chosenRace) {
            case "Dwarf":
            case "Halfling":
                savingThrows[0] -= 4;
                savingThrows[1] -= 4;
                savingThrows[2] -= 4;
                savingThrows[3] -= 3;
                savingThrows[4] -= 4;
                break;
            case "Elf":
                savingThrows[1] -= 2;
                savingThrows[2] -= 1;
                savingThrows[4] -= 2;
                break;
        }
        return savingThrows;
    }

    public void printEquipment(){
        System.out.println("Equipped Items:");

        String weaponName = "NONE";
        if (this.weaponHeld != null){
            weaponName = this.weaponHeld.getName();
        }
        System.out.println("Weapon: " + weaponName);

        String armorName = "NONE";
        if (this.armorWorn != null){
            armorName = this.armorWorn.getName();
        }
        System.out.println("Armor: " + armorName);

        String shieldName = "NONE";
        if (this.shieldWorn != null){
            shieldName = this.shieldWorn.getName();
        }
        System.out.println("Shield: " + shieldName);
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
        System.out.println("Strength: " + strength + "(" + calculateAbilityBonus(strength) + ")");
        System.out.println("Intelligence: " + intelligence + "(" + calculateAbilityBonus(intelligence) + ")");
        System.out.println("Wisdom: " + wisdom + "(" + calculateAbilityBonus(wisdom) + ")");
        System.out.println("Dexterity: " + dexterity + "(" + calculateAbilityBonus(dexterity) + ")");
        System.out.println("Constitution: " + constitution + "(" + calculateAbilityBonus(constitution) + ")");
        System.out.println("Charisma: " + charisma + "(" + calculateAbilityBonus(charisma) + ")");
        System.out.println();
        System.out.println("Saving Throws");
        System.out.println("Death Ray/Poison: " + deathRayPoisonSave);
        System.out.println("Magic Wands:" + magicWandSave);
        System.out.println("Paralysis: " + paralysisSave);
        System.out.println("Dragon Breath: " + dragonBreathSave);
        System.out.println("Rods/Staves/Spells: " + spellSave);
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
}
