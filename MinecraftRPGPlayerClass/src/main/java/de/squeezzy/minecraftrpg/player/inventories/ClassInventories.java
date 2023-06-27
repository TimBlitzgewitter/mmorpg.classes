package de.squeezzy.minecraftrpg.player.inventories;

import de.squeezzy.minecraftrpg.player.inventories.items.Mage;
import de.squeezzy.minecraftrpg.player.inventories.items.Swordsman;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class ClassInventories {
Swordsman swordsman = new Swordsman();
Mage mage = new Mage();
    public PlayerInventory swordsman(Player p) {

        PlayerInventory inv = p.getInventory();
        inv.setItem(0, swordsman.sword());

        return inv;
    }

    public PlayerInventory mage(Player p) {

        PlayerInventory inv = p.getInventory();
        inv.setItem(0, mage.staff());

        return inv;
    }
}
