package com.rpg.game;

public class Character extends Actor{
    private String race;
    private String charClass;

    private int level;
    private int xp;

    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int wisdom;
    private int charisma;

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

        int [] savingThrows = assignSavingThrows(charClass,race,level);
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
            this.updateArmorClass();
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
            this.updateArmorClass();
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
                default:
                    System.out.println("You can't use this item right now.");
            }
        }
    }

    // Function to assign saving throws based on class and race and level.
    public static int[] assignSavingThrows(String chosenClass, String chosenRace, int level) {
        // Death Ray, Wands, Paralysis, Dragon Breath, Spells
        int[] savingThrows = new int[] {13, 14, 15, 16, 18}; // default saving throws for NM characters

        switch (chosenClass) {
            case "Fighter":
                if (level == 1) savingThrows = new int[]{12, 13, 14, 15, 17};
                else if (level >= 2 && level <= 3) savingThrows = new int[]{11, 12, 14, 15, 16};
                else if (level >= 4 && level <= 5) savingThrows = new int[]{11, 11, 13, 14, 15};
                else if (level >= 6 && level <= 7) savingThrows = new int[]{10, 11, 12, 14, 15};
                else if (level >= 8 && level <= 9) savingThrows = new int[]{9, 10, 12, 13, 14};
                else if (level >= 10 && level <= 11) savingThrows = new int[]{9, 9, 11, 12, 13};
                else if (level >= 12 && level <= 13) savingThrows = new int[]{8, 9, 10, 12, 13};
                else if (level >= 14 && level <= 15) savingThrows = new int[]{7, 8, 10, 11, 12};
                else if (level >= 16 && level <= 17) savingThrows = new int[]{7, 7, 9, 10, 11};
                else if (level >= 18 && level <= 19) savingThrows = new int[]{6, 7, 8, 10, 11};
                else if (level == 20) savingThrows = new int[]{5, 6, 8, 9, 10};
                break;

            case "Magic User":
                if (level == 1) savingThrows = new int[]{13, 14, 13, 16, 15};
                else if (level >= 2 && level <= 3) savingThrows = new int[]{13, 14, 13, 15, 14};
                else if (level >= 4 && level <= 5) savingThrows = new int[]{12, 13, 12, 15, 13};
                else if (level >= 6 && level <= 7) savingThrows = new int[]{12, 12, 11, 14, 13};
                else if (level >= 8 && level <= 9) savingThrows = new int[]{11, 11, 10, 14, 12};
                else if (level >= 10 && level <= 11) savingThrows = new int[]{11, 10, 9, 13, 11};
                else if (level >= 12 && level <= 13) savingThrows = new int[]{10, 10, 9, 13, 11};
                else if (level >= 14 && level <= 15) savingThrows = new int[]{10, 9, 8, 12, 10};
                else if (level >= 16 && level <= 17) savingThrows = new int[]{9, 8, 7, 12, 9};
                else if (level >= 18 && level <= 19) savingThrows = new int[]{9, 7, 6, 11, 9};
                else if (level == 20) savingThrows = new int[]{8, 6, 5, 11, 8};
                break;

            case "Cleric":
                if (level == 1) savingThrows = new int[]{11, 12, 14, 16, 15};
                else if (level >= 2 && level <= 3) savingThrows = new int[]{10, 11, 13, 15, 14};
                else if (level >= 4 && level <= 5) savingThrows = new int[]{9, 10, 13, 15, 14};
                else if (level >= 6 && level <= 7) savingThrows = new int[]{9, 10, 12, 14, 13};
                else if (level >= 8 && level <= 9) savingThrows = new int[]{8, 9, 12, 14, 13};
                else if (level >= 10 && level <= 11) savingThrows = new int[]{8, 9, 11, 13, 12};
                else if (level >= 12 && level <= 13) savingThrows = new int[]{7, 8, 11, 13, 12};
                else if (level >= 14 && level <= 15) savingThrows = new int[]{7, 8, 10, 12, 11};
                else if (level >= 16 && level <= 17) savingThrows = new int[]{6, 7, 10, 12, 11};
                else if (level >= 18 && level <= 19) savingThrows = new int[]{6, 7, 9, 11, 10};
                else if (level == 20) savingThrows = new int[]{5, 6, 9, 11, 10};
                break;

            case "Thief":
                if (level == 1) savingThrows = new int[]{13, 14, 13, 16, 15};
                else if (level >= 2 && level <= 3) savingThrows = new int[]{12, 14, 12, 15, 14};
                else if (level >= 4 && level <= 5) savingThrows = new int[]{11, 13, 12, 14, 13};
                else if (level >= 6 && level <= 7) savingThrows = new int[]{11, 13, 11, 13, 13};
                else if (level >= 8 && level <= 9) savingThrows = new int[]{10, 12, 11, 12, 12};
                else if (level >= 10 && level <= 11) savingThrows = new int[]{9, 12, 10, 11, 11};
                else if (level >= 12 && level <= 13) savingThrows = new int[]{9, 10, 10, 10, 11};
                else if (level >= 14 && level <= 15) savingThrows = new int[]{8, 10, 9, 9, 10};
                else if (level >= 16 && level <= 17) savingThrows = new int[]{7, 9, 9, 8, 9};
                else if (level >= 18 && level <= 19) savingThrows = new int[]{7, 9, 8, 7, 9};
                else if (level == 20) savingThrows = new int[]{6, 8, 8, 6, 8};
                break;

            default:
                System.out.println("Unknown class. Default saving throws assigned.");
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

    public void updateArmorClass(){
        int armorClass = 11;
        if (this.armorWorn != null){
            armorClass = this.armorWorn.getArmorClass();
        }
        if (this.shieldWorn != null){
            armorClass += this.shieldWorn.getArmorClass();
        }
        this.armorClass = armorClass;
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
