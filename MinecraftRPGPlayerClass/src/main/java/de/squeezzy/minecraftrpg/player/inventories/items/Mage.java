package de.squeezzy.minecraftrpg.player.inventories.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mage {

    public ItemStack staff() {

        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§6Wooden Staff");
        item.setItemMeta(meta);

        return item;
    }
}
