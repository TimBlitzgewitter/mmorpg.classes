package de.squeezzy.minecraftrpg.player.evolveclass;

import de.squeezzy.minecraftrpg.player.PlayerClass;
import de.squeezzy.minecraftrpg.player.inventories.classes.MagicianClass;
import de.squeezzy.minecraftrpg.player.inventories.classes.SwordsmanClass;
import de.squeezzy.minecraftrpg.player.model.PlayerClassModel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.SQLException;

public class EvolveClass {

    private final PlayerClass plugin;

    public EvolveClass(PlayerClass plugin) {
        this.plugin = plugin;
    }

    public void firstEvolveClass(Player p) {
        try {

            PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            Inventory inv;
            //Swordsman
            if (stats.getPlayer_class() == 1) {
                SwordsmanClass sw = new SwordsmanClass();
                inv = sw.firstChoice();
                p.openInventory(inv);
            }
            if (stats.getPlayer_class() == 10) {
                MagicianClass mg = new MagicianClass();
                inv = mg.firstChoice();
                p.openInventory(inv);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }
}
