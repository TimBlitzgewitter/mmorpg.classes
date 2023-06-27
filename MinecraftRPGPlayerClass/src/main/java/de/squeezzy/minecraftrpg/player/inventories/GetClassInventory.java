package de.squeezzy.minecraftrpg.player.inventories;

import de.squeezzy.minecraftrpg.player.PlayerClass;
import de.squeezzy.minecraftrpg.player.model.PlayerClassModel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.sql.SQLException;

public class GetClassInventory {
    private final PlayerClass plugin;

    public GetClassInventory(PlayerClass plugin) {
        this.plugin = plugin;
    }

    public void getClassInventory(Player p) {
    ClassInventories classInv = new ClassInventories();
        PlayerInventory inventory;
        try {
            PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            switch (stats.getPlayer_class()) {
                case 1: {
                    inventory = classInv.swordsman(p);
                    p.getInventory().setContents(inventory.getContents());
                    break;
                }
                case 10: {
                    inventory = classInv.mage(p);
                    p.getInventory().setContents(inventory.getContents());
                    break;
                }
            }



        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
