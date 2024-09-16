package com.rpg.game;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    private static final Map<String, Item> items = new HashMap<>();

    static {
        // Predefining items
        items.put("sword", new Item("Sword", "Weapon", "A sharp steel sword", 5));
        items.put("dagger", new Item("Dagger", "Weapon", "A quick and deadly dagger", 3));
        items.put("leather armor", new Item("Leather Armor", "Armor", "Light armor made of leather", 2));
        items.put("health potion", new Item("Health Potion", "Potion", "Restores a small amount of health", 10));
    }

    // Retrieve an item by name
    public static Item getItem(String itemName) {
        return items.getOrDefault(itemName.toLowerCase(), null);
    }
}

