package com.rpg.game;

import java.util.Random;

public class DiceRoller {
    private Random rand;

    public DiceRoller() {
        rand = new Random();
    }

    // Roll a single die with 'sides' number of sides (e.g., 1D6, 1D20)
    public int rollDie(int sides) {
        return rand.nextInt(sides) + 1;  // Random number between 1 and 'sides'
    }

    // Roll multiple dice with 'sides' number of sides (e.g., roll 3D6)
    public int rollMultipleDice(int numberOfDice, int sides) {
        int sum = 0;
        for (int i = 0; i < numberOfDice; i++) {
            sum += rollDie(sides);
        }
        return sum;
    }

    // Roll 3D6 (special case for rolling three six-sided dice)
    public int roll3D6() {
        return rollMultipleDice(3, 6);  // Roll 3 six-sided dice
    }

    // You can add other roll types here, for example, roll D20
    public int rollD20() {
        return rollDie(20);  // Roll a twenty-sided die
    }

    // Additional dice rolls can be added as needed (D8, D10, etc.)
}