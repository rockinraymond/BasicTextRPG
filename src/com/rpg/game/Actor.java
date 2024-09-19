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
    boolean surprised = false;
    int initiative;

    public String getName() {
        return name;
    }

    public String getRace(){
        return "Unknown";
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

    public void attack(Actor target){
        int targetAC = target.getArmorClass();
        int attackRoll = new DiceRoller().rollD20();
        attackRoll += (this.attackBonus);
        System.out.println(this.getName() + " attacks " + target.getName() + " and rolled a " + attackRoll + "!");
        if (attackRoll > targetAC){
            int damageRoll = this.rollDamage();
            System.out.println(this.getName() + " hits " + target.getName() + " dealing " + damageRoll + " damage!");
            target.takeDamage(damageRoll);
        }else{
            System.out.println(this.getName() + " missed!");
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

    public int getDexterity() {
        return 11;
    }

    public int getInitiative(){
        return initiative;
    }

    public void setInitiative(int initiative){
        this.initiative = initiative;
    }

    public boolean isSurprised(){
        return surprised;
    }

    public void checkSurprise(){
        int surpriseRoll = new DiceRoller().rollDie(6);
        if (surpriseRoll < 3){
            this.surprised = true;
        }
    }

    public void setSurprised(boolean surprised){
            this.surprised = surprised;
    }

    public int rollDamage(){
        return new DiceRoller().rollDie(4);
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
