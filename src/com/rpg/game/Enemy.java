package com.rpg.game;

public class Enemy {
    private String name;
    private int health;
    private int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

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

    public int attack() {
        return (int) (Math.random() * attackPower);
    }
}
