package de.squeezzy.minecraftrpg.player.inventories.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Swordsman {

    public ItemStack sword() {

        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§6Wooden Sword");
        item.setItemMeta(meta);

        return item;
    }
}
