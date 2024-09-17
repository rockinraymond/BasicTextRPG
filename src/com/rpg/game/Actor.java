package com.rpg.game;

public class Actor {
    String name;

    int attackBonus;
    int hitPoints;
    int maxHitPoints;
    int armorClass;

    int deathRayPoisonSave;
    int magicWandSave;
    int paralysisSave;
    int dragonBreathSave;
    int spellSave;

    int movement;

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
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

    public int getAttackBonus() {
        return  attackBonus;
    }

    public int getDeathRayPoisonSave() {
        return deathRayPoisonSave;
    }

    public int getMagicWandSave() {
        return magicWandSave;
    }

    public int getDragonBreathSave() {
        return dragonBreathSave;
    }

    public int getParalysisSave() {
        return paralysisSave;
    }

    public int getSpellSave() {
        return spellSave;
    }

    public int getMovement(){
        return movement;
    }
}
