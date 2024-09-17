package com.rpg.game;

public class Combat {
    public static void fight(Character player, Monster monster) {
        System.out.println("A wild " + monster.getName() + " appears!");

        while (player.getHitPoints() > 0 && monster.getHitPoints() > 0) {
            int playerAttack = player.attack();
            System.out.println(player.getName() + " attacks for " + playerAttack + " damage.");
            monster.takeDamage(playerAttack);

            if (monster.getHitPoints() > 0) {
                int enemyAttack = monster.attack();
                System.out.println(monster.getName() + " attacks for " + enemyAttack + " damage.");
                player.takeDamage(enemyAttack);
            } else {
                System.out.println(monster.getName() + " has been defeated!");
                return;
            }

            System.out.println(player.getName() + " Health: " + player.getHitPoints());
            System.out.println(monster.getName() + " Health: " + monster.getHitPoints());
        }

        if (player.getHitPoints() <= 0) {
            System.out.println("You have been defeated!");
        }
    }
}

