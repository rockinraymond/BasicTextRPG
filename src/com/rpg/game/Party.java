package com.rpg.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Party {
    private List<Character> members;

    // Constructor
    public Party() {
        this.members = new ArrayList<>();
    }

    // Method to add an Character to the party
    public void addCharacter(Character Character) {
        if (Character != null && !members.contains(Character)) {
            members.add(Character);
            System.out.println(Character.getName() + " has been added to the party.");
        } else {
            System.out.println("Character is already in the party or is invalid.");
        }
    }

    // Method to remove a Character from the party by name
    public boolean removeCharacterByName(String name) {
        Iterator<Character> iterator = members.iterator();
        while (iterator.hasNext()) {
            Character Character = iterator.next();
            if (Character.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println(name + " has been removed from the party.");
                return true;
            }
        }
        System.out.println("Character with name " + name + " not found in the party.");
        return false;
    }

    // Method to list all members of the party
    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("The party is currently empty.");
        } else {
            System.out.println("Current members of the party:");
            for (Character character : members) {
                character.printStatsInParty();
            }
        }
    }

    // Getter for members (optional, if needed)
    public List<Character> getMembers() {
        return members;
    }

    // Method to get an array of all party members in an Actor Array(for encounters)
    public Actor[] getPartyMembersArray() {
        return members.toArray(new Actor[0]);
    }

    public boolean hasAliveMember() {
        for (Character character : members) {
            if (character.getHitPoints() > 0) {
                return true;
            }
        }
        return false;
    }
}
