package de.squeezzy.minecraftrpg.player.inventories.items;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Heads {

    public ItemStack getKnight() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk5MzI4MWU1Yzg0MjAwODMxNDYzODY3OGQzMjhhOGNlMTk5NDk2OGU1YzQxZDAxYmEzMGI5NGFlOTNjYThmNiJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§7§lSwordsmann");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§eChoose §l§6Swordsman §eas your class!");
        m.setLore(lore);
        skull.setItemMeta(m);
        return skull;
    }

    public ItemStack getMage() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYxNjkxZmIwMTgyNWI5ZDllYzFiOGYwNDE5OTQ0MzE0NmFhN2Q1NjI3YWE3NDU5NjJjMDcwNGI2YTIzNjAyNyJ9fX0=";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§7§lMagician");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§eChoose §l§6Magician §eas your class!");
        m.setLore(lore);
        skull.setItemMeta(m);
        return skull;
    }

    public ItemStack getHealer() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGIxYzhjNzIxYjg5YmE2NzY0NTM1MGFjYmZkZTk1ODJlODY2ZGQwMDQxMWNiYjM4NTQzMjE0MTY4MzgzNTRiIn19fQ==";
        SkullCreator.itemFromBase64(base64);
        ItemStack skull = SkullCreator.itemFromBase64(base64);
        ItemMeta m = skull.getItemMeta();
        assert m != null;
        m.setDisplayName("§7§lHealer");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§eChoose §l§6Healer §eas your class!");
        m.setLore(lore);
        skull.setItemMeta(m);
        return skull;
    }

}
