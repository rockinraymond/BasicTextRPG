package com.rpg.game;

public class Monster extends Actor{

    private int hitDice;
    private int numAttacks;
    private int damageDie;
    private int numberDamDie;

    private int morale;
    private char treasureType;
    private int XP;

    public Monster(String name, int armorClass, int hitDice, int damageDie, int numberDamDie, int movement, String saveClass, int saveLevel, int morale, char treasureType, int XP) {
        DiceRoller dieRoller = new DiceRoller();
        this.name = name;
        this.armorClass = armorClass;
        this.hitDice = hitDice;
        this.maxHitPoints = hitDice * dieRoller.rollDie(8);
        this.hitPoints = this.maxHitPoints;
        this.damageDie = damageDie;
        this.numberDamDie = numberDamDie;
        this.attackBonus= calculateAttackBonus(this.hitDice);

        int [] savingThrows = assignSavingThrows(saveClass,saveLevel);
        this.deathRayPoisonSave = savingThrows[0];
        this.magicWandSave = savingThrows[1];
        this.paralysisSave = savingThrows[2];
        this.dragonBreathSave = savingThrows[3];
        this.spellSave = savingThrows[4];

        this.movement = movement;
        this.morale = morale;
        this.treasureType = treasureType;
        this.XP = XP;
    }

    public int rollDamage(){
        return new DiceRoller().rollMultipleDice(this.numberDamDie,damageDie) + attackBonus;
    }

    public static int calculateAttackBonus(int hitDice) {
        int attackBonus = 0;

        if (hitDice == 1) attackBonus = 1;
        else if (hitDice == 2) attackBonus = 2;
        else if (hitDice == 3) attackBonus = 3;
        else if (hitDice == 4) attackBonus = 4;
        else if (hitDice == 5) attackBonus = 5;
        else if (hitDice == 6 || hitDice == 7) attackBonus = 6;
        else if (hitDice == 8 || hitDice == 9) attackBonus = 7;
        else if (hitDice == 10 || hitDice == 11) attackBonus = 8;
        else if (hitDice == 12 || hitDice == 13) attackBonus = 9;
        else if (hitDice == 14 || hitDice == 15) attackBonus = 10;
        else if (hitDice == 16 || hitDice == 17) attackBonus = 11;
        else if (hitDice == 18 || hitDice == 19) attackBonus = 12;
        else if (hitDice >= 20 && hitDice <= 23) attackBonus = 13;
        else if (hitDice >= 24 && hitDice <= 27) attackBonus = 14;
        else if (hitDice >= 28 && hitDice <= 31) attackBonus = 15;
        else if (hitDice >= 32) attackBonus = 16;

        return attackBonus;
    }

    public static int[] assignSavingThrows(String chosenClass, int level) {
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

        return savingThrows;
    }
}
