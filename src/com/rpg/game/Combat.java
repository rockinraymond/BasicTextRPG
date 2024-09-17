package com.rpg.game;

public class Combat {
    public static void fight(Character player, Enemy enemy) {
        System.out.println("A wild " + enemy.getName() + " appears!");

        while (player.getHitPoints() > 0 && enemy.getHealth() > 0) {
            int playerAttack = player.attack();
            System.out.println(player.getName() + " attacks for " + playerAttack + " damage.");
            enemy.takeDamage(playerAttack);

            if (enemy.getHealth() > 0) {
                int enemyAttack = enemy.attack();
                System.out.println(enemy.getName() + " attacks for " + enemyAttack + " damage.");
                player.takeDamage(enemyAttack);
            } else {
                System.out.println(enemy.getName() + " has been defeated!");
                return;
            }

            System.out.println(player.getName() + " Health: " + player.getHitPoints());
            System.out.println(enemy.getName() + " Health: " + enemy.getHealth());
        }

        if (player.getHitPoints() <= 0) {
            System.out.println("You have been defeated!");
        }
    }
}

