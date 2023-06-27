package de.squeezzy.minecraftrpg.player.inventories.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {


    public ItemStack whiteGlasPane() {

        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack barrier() {

        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§l§4Reset Class");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§cThis action will reset your class and level!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
