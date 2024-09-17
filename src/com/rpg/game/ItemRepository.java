package com.rpg.game;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    private static final Map<String, Item> items = new HashMap<>();

    static {
        // Miscellaneous Items
        items.put("backpack", new Item("Backpack (Standard or Halfling)", "Misc", "A standard backpack", 4, 1, 0, 'M', 0, 0, 0, 0));
        items.put("belt pouch", new Item("Belt Pouch", "Misc", "A small pouch for coins or other small items", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("bit and bridle", new Item("Bit and Bridle", "Misc", "Used to control a horse", 15, 3, 0, 'M', 0, 0, 0, 0));
        items.put("candles", new Item("Candles, 12", "Misc", "A set of 12 candles", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("chalk", new Item("Chalk, small bag", "Misc", "A bag with small pieces of chalk", 2, 1, 0, 'S', 0, 0, 0, 0));
        items.put("cloak", new Item("Cloak", "Misc", "A cloak to protect against the weather", 2, 1, 0, 'M', 0, 0, 0, 0));
        items.put("common clothing", new Item("Clothing, common outfit", "Misc", "A common outfit", 4, 1, 0, 'M', 0, 0, 0, 0));
        items.put("glass bottle", new Item("Glass bottle or vial", "Misc", "A small glass bottle", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("grappling hook", new Item("Grappling Hook", "Misc", "Used to scale walls or buildings", 2, 4, 0, 'M', 0, 0, 0, 0));
        items.put("holy symbol", new Item("Holy Symbol", "Misc", "A symbol of divine power", 25, 1, 0, 'S', 0, 0, 0, 0));
        items.put("holy water", new Item("Holy Water, per vial", "Misc", "A vial of holy water", 10, 1, 0, 'S', 0, 0, 0, 0));
        items.put("horseshoes", new Item("Horseshoes & shoeing", "Misc", "Shoes for horses", 1, 10, 0, 'M', 0, 0, 0, 0));
        items.put("ink", new Item("Ink, per jar", "Misc", "A jar of ink", 8, 1, 0, 'S', 0, 0, 0, 0));
        items.put("iron spikes", new Item("Iron Spikes, 12", "Misc", "A set of 12 iron spikes", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("ladder", new Item("Ladder, 10 ft.", "Misc", "A 10-foot wooden ladder", 1, 20, 0, 'L', 0, 0, 0, 0));
        items.put("lantern", new Item("Lantern", "Misc", "A simple lantern", 5, 2, 0, 'M', 0, 0, 0, 0));
        items.put("bullseye lantern", new Item("Lantern, Bullseye", "Misc", "A bullseye lantern", 14, 3, 0, 'M', 0, 0, 0, 0));
        items.put("hooded lantern", new Item("Lantern, Hooded", "Misc", "A hooded lantern", 8, 2, 0, 'M', 0, 0, 0, 0));
        items.put("manacles", new Item("Manacles", "Misc", "Manacles without a padlock", 6, 4, 0, 'M', 0, 0, 0, 0));
        items.put("map case", new Item("Map or Scroll Case", "Misc", "A case for maps or scrolls", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("mirror", new Item("Mirror, small metal", "Misc", "A small metal mirror", 7, 1, 0, 'S', 0, 0, 0, 0));
        items.put("oil", new Item("Oil, per flask", "Misc", "A flask of oil", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("padlock", new Item("Padlock", "Misc", "A padlock with two keys", 12, 1, 0, 'S', 0, 0, 0, 0));
        items.put("paper", new Item("Paper, sheet", "Misc", "A single sheet of paper", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("quill", new Item("Quill", "Misc", "A quill for writing", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("quill knife", new Item("Quill Knife", "Misc", "A knife for sharpening quills", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("quiver", new Item("Quiver or Bolt Case", "Misc", "A case for arrows or bolts", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("rations", new Item("Rations, Dry, one night", "Misc", "A week's worth of dry rations", 2, 2, 0, 'M', 0, 0, 0, 0));
        items.put("rope hemp", new Item("Rope, Hemp (50 ft.)", "Misc", "50 feet of hemp rope", 1, 5, 0, 'M', 0, 0, 0, 0));
        items.put("rope silk", new Item("Rope, Silk (50 ft.)", "Misc", "50 feet of silk rope", 10, 2, 0, 'M', 0, 0, 0, 0));
        items.put("sack large", new Item("Sack, Large", "Misc", "A large sack", 1, 1, 0, 'M', 0, 0, 0, 0));
        items.put("sack small", new Item("Sack, Small", "Misc", "A small sack", 5, 1, 0, 'S', 0, 0, 0, 0));
        items.put("saddle pack", new Item("Saddle, Pack", "Misc", "A pack saddle", 5, 15, 0, 'M', 0, 0, 0, 0));
        items.put("saddle riding", new Item("Saddle, Riding", "Misc", "A riding saddle", 10, 35, 0, 'M', 0, 0, 0, 0));
        items.put("saddlebags", new Item("Saddlebags, pair", "Misc", "A pair of saddlebags", 4, 7, 0, 'M', 0, 0, 0, 0));
        items.put("spellbook", new Item("Spellbook (128 pages)", "Misc", "A 128-page spellbook", 25, 1, 0, 'M', 0, 0, 0, 0));
        items.put("tent large", new Item("Tent, Large (ten men)", "Misc", "A large tent for ten men", 25, 20, 0, 'L', 0, 0, 0, 0));
        items.put("tent small", new Item("Tent, Small (one man)", "Misc", "A small tent for one man", 5, 10, 0, 'M', 0, 0, 0, 0));
        items.put("thieves picks", new Item("Thieves' Picks and Tools", "Misc", "A set of thieves' tools", 25, 1, 0, 'S', 0, 0, 0, 0));
        items.put("tinderbox", new Item("Tinderbox", "Misc", "A tinderbox with flint and steel", 3, 1, 0, 'S', 0, 0, 0, 0));
        items.put("torches", new Item("Torches, 6", "Misc", "A set of 6 torches", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("whetstone", new Item("Whetstone", "Misc", "A stone used for sharpening blades", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("whistle", new Item("Whistle", "Misc", "A small whistle", 1, 1, 0, 'S', 0, 0, 0, 0));
        items.put("waterskin", new Item("Waterskin", "Misc", "A skin for carrying liquid", 1, 2, 0, 'M', 0, 0, 0, 0));
        items.put("winter blanket", new Item("Winter Blanket", "Misc", "A blanket for cold weather", 1, 3, 0, 'M', 0, 0, 0, 0));

        // Armor and Shields
        items.put("leather armor", new Item("Leather Armor", "Armor", "Light leather armor", 20, 15, 13, 'M', 0, 0, 0, 0));
        items.put("chain mail", new Item("Chain Mail", "Armor", "Chain mail armor", 60, 40, 15, 'M', 0, 0, 0, 0));
        items.put("plate mail", new Item("Plate Mail", "Armor", "Heavy plate mail armor", 300, 50, 17, 'L', 0, 0, 0, 0));
        items.put("shield", new Item("Shield", "Shield", "A basic shield", 7, 5, 1, 'M', 0, 0, 0, 0));

        // Weapons
        items.put("hand axe", new Item("Hand Axe", "Weapon", "A small hand axe", 4, 5, 6, 'S', 10, 20, 30, 0));
        items.put("battle axe", new Item("Battle Axe", "Weapon", "A medium-sized battle axe", 7, 7, 8, 'M', 10, 20, 30, 0));
        items.put("great axe", new Item("Great Axe", "Weapon", "A large two-handed axe", 14, 15, 10, 'L', 10, 20, 30, 0));
        items.put("shortbow", new Item("Shortbow", "Weapon", "A small shortbow", 25, 2, 6, 'M', 50, 100, 150, 0));
        items.put("longbow", new Item("Longbow", "Weapon", "A large longbow", 60, 3, 8, 'L', 70, 140, 210, 0));
        items.put("light crossbow", new Item("Light Crossbow", "Weapon", "A light crossbow", 30, 7, 6, 'M', 60, 120, 180, 0));
        items.put("heavy crossbow", new Item("Heavy Crossbow", "Weapon", "A heavy crossbow", 50, 14, 8, 'L', 80, 160, 240, 0));
        items.put("dagger", new Item("Dagger", "Weapon", "A small dagger", 2, 1, 4, 'S', 10, 20, 30, 0));
        items.put("shortsword", new Item("Shortsword", "Weapon", "A short sword", 6, 3, 6, 'S', 0, 0, 0, 0));
        items.put("longsword", new Item("Longsword", "Weapon", "A long sword or scimitar", 10, 4, 8, 'M', 0, 0, 0, 0));
        items.put("two-handed sword", new Item("Two-Handed Sword", "Weapon", "A large two-handed sword", 18, 10, 10, 'L', 0, 0, 0, 0));
        items.put("warhammer", new Item("Warhammer", "Weapon", "A small warhammer", 4, 6, 6, 'S', 10, 20, 30, 0));
        items.put("mace", new Item("Mace", "Weapon", "A medium-sized mace", 6, 10, 8, 'M', 0, 0, 0, 0));
        items.put("maul", new Item("Maul", "Weapon", "A large maul", 10, 16, 10, 'L', 0, 0, 0, 0));
        items.put("club", new Item("Club", "Weapon", "A medium-sized club", 2, 1, 4, 'M', 0, 0, 0, 0));
        items.put("walking staff", new Item("Walking Staff", "Weapon", "A medium-sized walking staff", 2, 1, 4, 'M', 0, 0, 0, 0));
        items.put("quarter staff", new Item("Quarter Staff", "Weapon", "A long quarterstaff", 2, 4, 6, 'L', 0, 0, 0, 0));
        items.put("pole arm", new Item("Pole Arm", "Weapon", "A large pole arm", 9, 15, 10, 'L', 0, 0, 0, 0));
        items.put("sling", new Item("Sling", "Weapon", "A small sling", 1, 1, 4, 'S', 30, 60, 90, 0));
        items.put("spear", new Item("Spear", "Weapon", "A medium-sized spear", 5, 5, 6, 'M', 10, 20, 30, 0));


    }

    // Retrieve an item by name
    public static Item getItem(String itemName) {
        return items.getOrDefault(itemName.toLowerCase(), null);
    }
}

