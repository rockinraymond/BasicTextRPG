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

        int [] savingThrows = generateSaves(saveClass,saveLevel);
        this.deathRayPoisonSave = savingThrows[0];
        this.magicWandSave = savingThrows[1];
        this.paralysisSave = savingThrows[2];
        this.dragonBreathSave = savingThrows[3];
        this.spellSave = savingThrows[4];

        this.morale = morale;
        this.treasureType = treasureType;
        this.XP = XP;
    }

    public int attack() {
        return 1;
    }

    public int[] generateSaves(String saveClass, int level){
        int[] savingThrows = new int[5];
        return savingThrows;
    }
}
