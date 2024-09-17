package com.rpg.game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    // Constructor
    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Add an item to the inventory
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " has been added to your inventory.");
    }

    // Remove an item from the inventory (if it exists)
    public void removeItem(String itemName) {
        Item itemToRemove = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
            System.out.println(itemToRemove.getName() + " has been removed from your inventory.");
        } else {
            System.out.println("Item not found in your inventory.");
        }
    }

    // Display the list of items in the inventory
    public void viewInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory:");
            for (Item item : items) {
                item.displayItem();
                System.out.println(); // Blank line for readability
            }
        }
    }

    // Use an item (if it's in the inventory)
    public Item useItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }

        System.out.println("Item not found in your inventory.");
        return null;
    }

    // Check if inventory contains a specific item
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
}

