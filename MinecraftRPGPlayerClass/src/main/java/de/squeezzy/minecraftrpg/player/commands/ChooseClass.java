package de.squeezzy.minecraftrpg.player.commands;

import de.squeezzy.minecraftrpg.player.inventories.ChooseClassInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ChooseClass implements CommandExecutor {

    ChooseClassInventory cCI = new ChooseClassInventory();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inventory = cCI.chooseClass();
            player.openInventory(inventory);
        }
        return false;
    }
}
