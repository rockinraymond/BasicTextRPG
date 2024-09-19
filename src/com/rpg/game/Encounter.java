package com.rpg.game;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Encounter {
    private Actor[] actors;  // Array of actors (both player characters and monsters)
    private int roundNumber; // Tracks the current combat round
    private DiceRoller diceRoller;
    private Scanner scanner;

    public Encounter(Actor[] actors) {
        this.actors = actors;
        this.roundNumber = 0;
        this.diceRoller = new DiceRoller();
        this.scanner = new Scanner(System.in);
    }

    // Start the encounter: Initiates the encounter, rolls for surprise, and checks initiative order.
    public void startEncounter() {
        System.out.println("An encounter begins!");
        checkSurprise();       // Step 1: Determine if any actors are surprised
        rollInitiative();      // Step 2: Roll initiative for all actors
        executeRounds();       // Step 3: Begin the combat rounds
    }

    // Check Surprise: Rolls to see if any actors are surprised and cannot act in the first round.
    private void checkSurprise() {
        System.out.println("\nChecking for surprise...");
        for (Actor actor : actors) {
            int surpriseRoll = diceRoller.roll1d6();
            int surpriseThreshold = 2;  // Example: surprise on a roll of 1-2
            if (surpriseRoll <= surpriseThreshold) {
                actor.setSurprised(true);
                System.out.println(actor.getName() + " is surprised and cannot act in the first round.");
            }
        }
    }

    // Roll Initiative: Rolls for initiative for all actors and determines action order based on Dexterity.
    private void rollInitiative() {
        System.out.println("\nRolling initiative...");
        for (Actor actor : actors) {
            int initiative = diceRoller.roll1d6() + actor.calculateAbilityBonus(actor.getDexterity());
            actor.setInitiative(initiative);
            System.out.println(actor.getName() + " rolls initiative: " + initiative);
        }
        // Sort actors by initiative in descending order
        Arrays.sort(actors, Comparator.comparingInt(Actor::getInitiative).reversed());
        System.out.println("\nInitiative order:");
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " (Initiative: " + actor.getInitiative() + ")");
        }
    }

    // Execute Rounds: Handles the rounds of combat, calling each actor’s turn based on initiative.
    private void executeRounds() {
        while (combatOngoing()) { // Combat continues until one side is defeated or disengages
            roundNumber++;
            System.out.println("\n--- Round " + roundNumber + " ---");
            for (Actor actor : actors) {
                if (actor.getHitPoints() > 0) {
                    takeTurn(actor);  // Each actor takes their turn in order of initiative
                }
            }
        }
        endEncounter(); // End the encounter when combat concludes
    }

    // Check if combat should continue (e.g., enemies are still alive).
    private boolean combatOngoing() {
        boolean playersAlive = Arrays.stream(actors)
                .anyMatch(a -> a instanceof Character && a.getHitPoints() > 0);
        boolean monstersAlive = Arrays.stream(actors)
                .anyMatch(a -> a instanceof Monster && a.getHitPoints() > 0);
        return playersAlive && monstersAlive;
    }

    // Execute a single actor's turn based on whether they are a player character or a monster.
    private void takeTurn(Actor actor) {
        if (actor.isSurprised()) {
            System.out.println(actor.getName() + " is surprised and cannot act this round.");
            actor.setSurprised(false);
        } else if (actor instanceof Character) {
            offerPlayerChoices((Character) actor);  // Offer choices to player characters
        } else if (actor instanceof Monster) {
            performRandomAction((Monster) actor); // Perform random action for monsters
        }
    }

    // Offer Player Choices: Displays choices for player characters and lets them choose their action.
    private void offerPlayerChoices(Character character) {
        System.out.println(character.getName() + ", it's your turn. What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Cast Spell");
        System.out.println("4. Use Item");
        System.out.println("5. Flee");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Actor target = chooseTarget();
                if (target != null) {
                    System.out.println(character.getName() + " Attacks!");
                   // character.attack(target);
                }
                break;
            case 2:
                System.out.println(character.getName() + " Defends!");
                //character.defend();
                break;
            case 3:
                System.out.println(character.getName() + " Casts a spell!");
                //character.castSpell();
                break;
            case 4:
                System.out.println(character.getName() + " uses an item!");
                //character.useItem();
                break;
            case 5:
                System.out.println(character.getName() + " tries to flee!");
                //character.flee();
                break;
            default:
                System.out.println("Invalid choice.");
                offerPlayerChoices(character);
                break;
        }
    }

    // Choose a target for attacking
    private Actor chooseTarget() {
        System.out.println("Choose a target to attack:");
        for (int i = 0; i < actors.length; i++) {
            if (actors[i] instanceof Monster && actors[i].getHitPoints() > 0) {
                System.out.println((i + 1) + ". " + actors[i].getName() + " (HP: " + actors[i].getHitPoints() + ")");
            }
        }
        int targetIndex = scanner.nextInt() - 1;
        if (targetIndex >= 0 && targetIndex < actors.length && actors[targetIndex] instanceof Monster) {
            return actors[targetIndex];
        }
        System.out.println("Invalid target.");
        return null;
    }

    // Perform random actions for monsters
    private void performRandomAction(Actor monster) {
        int randomAction = diceRoller.roll1d6() % 4;
        Actor target = chooseRandomTarget();
        switch (randomAction) {
            case 0:
                System.out.println(monster.getName() + " Attacks!");
                //monster.attack(target);
                break;
            case 1:
                System.out.println(monster.getName() + " Defends!");
                //monster.defend();
                break;
            case 2:
                System.out.println(monster.getName() + " casts a spell!");
                //monster.castSpell();
                break;
            case 3:
                System.out.println(monster.getName() + " uses an item!");
                //monster.useItem();
                break;
            default:
                //monster.attack(target);
        }
    }

    // Choose a random target for the monster to attack
    private Actor chooseRandomTarget() {
        return Arrays.stream(actors)
                .filter(a -> a instanceof Character && a.getHitPoints() > 0)
                .findAny()
                .orElse(null);
    }

    // End the encounter
    private void endEncounter() {
        System.out.println("\nThe encounter has ended.");
        if (Arrays.stream(actors).noneMatch(a -> a instanceof Monster && a.getHitPoints() > 0)) {
            System.out.println("Players have defeated the monsters!");
        } else {
            System.out.println("Monsters have defeated the players.");
        }
    }
}


