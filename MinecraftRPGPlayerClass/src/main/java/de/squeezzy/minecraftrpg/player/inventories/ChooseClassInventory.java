package de.squeezzy.minecraftrpg.player.inventories;

import de.squeezzy.minecraftrpg.player.inventories.items.Heads;
import de.squeezzy.minecraftrpg.player.inventories.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class ChooseClassInventory {
    Items items = new Items();
    Heads heads = new Heads();
    public Inventory chooseClass() {

        Inventory inv = Bukkit.createInventory(null, 45, "Choose a class!");
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, items.whiteGlasPane());
        }
        inv.setItem(10, heads.getKnight());
        inv.setItem(12, heads.getMage());
        inv.setItem(14,heads.getHealer());
        inv.setItem(44, items.barrier());
        return inv;
    }
}
