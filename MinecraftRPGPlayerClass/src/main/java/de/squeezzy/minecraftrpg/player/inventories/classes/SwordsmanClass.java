package de.squeezzy.minecraftrpg.player.inventories.classes;

import de.squeezzy.minecraftrpg.player.inventories.items.Heads;
import de.squeezzy.minecraftrpg.player.inventories.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.Scanner;

public class SwordsmanClass {
    Items items = new Items();
    Heads heads = new Heads();
    public Inventory firstChoice() {
        Inventory inv = Bukkit.createInventory(null, 27, "Level 25");
        for (int i = 0; i < 27; i++) {
        inv.setItem(i, items.whiteGlasPane());
    }
        inv.setItem(12, heads.getKnight());
        inv.setItem(14, heads.getKnight());


        return inv;
    }
}
