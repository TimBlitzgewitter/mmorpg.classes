package de.squeezzy.minecraftrpg.player.listeners;

import de.squeezzy.minecraftrpg.player.PlayerClass;
import de.squeezzy.minecraftrpg.player.evolveclass.EvolveClass;
import de.squeezzy.minecraftrpg.player.inventories.ChooseClassInventory;
import de.squeezzy.minecraftrpg.player.inventories.GetClassInventory;
import de.squeezzy.minecraftrpg.player.inventories.classes.MagicianClass;
import de.squeezzy.minecraftrpg.player.inventories.classes.SwordsmanClass;
import de.squeezzy.minecraftrpg.player.inventories.items.Heads;
import de.squeezzy.minecraftrpg.player.inventories.items.Items;
import de.squeezzy.minecraftrpg.player.model.PlayerClassModel;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;


public class Listeners implements Listener {

    private final PlayerClass plugin;

    public Listeners(PlayerClass plugin) {
        this.plugin = plugin;
    }

    boolean reset;

    @EventHandler
    public void joinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        try {
            PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());

            if (stats == null) {
                p.sendMessage("1");
                String uuid = p.getUniqueId().toString();
                stats = new PlayerClassModel(uuid, 0, 0);
                this.plugin.getDatabase().createPlayerStats(stats);
                p.sendMessage("2");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @EventHandler
    //KeepInventory = true!
    public void levelUpEvent(PlayerLevelChangeEvent e) {
        EvolveClass evolve = new EvolveClass(this.plugin);
        Player p = e.getPlayer();
        int newLevel = e.getNewLevel();
        int oldLevel = e.getOldLevel();
        try {
            PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
            int levels = newLevel - oldLevel;

            if (!reset) {
            p.sendMessage("§a Du bist " + levels + " Level aufgestiegen §l§a!");

            p.sendMessage("§a Du bist jetzt Level §l§a" + newLevel + "!");

            stats.setLevel(stats.getLevel() + levels);
            this.plugin.getDatabase().updatePlayerStats(stats);

            } else {
                reset = false;
            }

            if (newLevel == 25) {
                evolve.firstEvolveClass(p);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

   /* @EventHandler
    public void drobItem(PlayerDropItemEvent e){
            e.setCancelled(true);
            Player p = e.getPlayer();
            ItemStack item = e.getItemDrop().getItemStack();
            p.getInventory().addItem(item);
            item.setAmount(0);
            p.sendMessage("§4Du kannst keine Items dropen! §aVerkaufe Items bei Händlern oder im Handelszentrum.");
    }

    @EventHandler
    public void itemPickUp(EntityPickupItemEvent e) {
        LivingEntity entity = e.getEntity();
        if (entity instanceof Player) {
            Player p = (Player) e.getEntity();
            ItemStack item = e.getItem().getItemStack();

        }
    }

    @EventHandler
    public void inventoryInteraction(InventoryInteractEvent e){
        ItemStack item = e.getWhoClicked().getItemOnCursor();
        if (!Objects.requireNonNull(item.getItemMeta()).getItemFlags().toString().equals("moveable")){
            e.setCancelled(true);
        }
    }*/

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        ChooseClassInventory cCI = new ChooseClassInventory();
        Heads heads = new Heads();
        Items items = new Items();
        GetClassInventory getClassInv = new GetClassInventory(this.plugin);
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            Inventory inventory = e.getClickedInventory();
            assert inventory != null;
            ItemStack[] content1 = inventory.getContents();
            ItemStack[] content2 = cCI.chooseClass().getContents();
            if (Arrays.equals(content1, content2)) {
                e.setCancelled(true);
                try {
                    PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                    if (Objects.requireNonNull(e.getCurrentItem()).equals(items.barrier())) {
                        p.sendMessage("§l§cYour class and level are now reseted§l§c!");
                        reset = true;

                        p.setLevel(0);
                        p.setTotalExperience(0);
                        p.setExp(0);
                        stats.setPlayer_class(0);
                        stats.setLevel(0);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                    }
                    if (stats.getPlayer_class() == 0) {
                        //get swordsman class
                        if (Objects.requireNonNull(e.getCurrentItem()).equals(heads.getKnight())) {
                            p.sendMessage("§l§aYou are now a §l§7Swordsman§l§a!");
                            stats.setPlayer_class(1);
                            this.plugin.getDatabase().updatePlayerStats(stats);
                            getClassInv.getClassInventory(p);
                        }
                        //get mage class
                        if (Objects.requireNonNull(e.getCurrentItem()).equals(heads.getMage())) {
                            p.sendMessage("§l§aYou are now a §l§7Magician§l§a!");
                            stats.setPlayer_class(10);
                            this.plugin.getDatabase().updatePlayerStats(stats);
                        }
                        //get healer class
                        if (Objects.requireNonNull(e.getCurrentItem()).equals(heads.getHealer())) {
                            p.sendMessage("§l§aYou are now a §l§7Healer§l§a!");
                            stats.setPlayer_class(20);
                            this.plugin.getDatabase().updatePlayerStats(stats);
                        }
                        //reset class and level

                    } else {

                        p.sendMessage("§4You already have a class!");
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void evolveClass1(InventoryClickEvent e) {
        Heads heads = new Heads();
        GetClassInventory getClassInv = new GetClassInventory(this.plugin);
        SwordsmanClass swordsmanClass = new SwordsmanClass();
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            Inventory inventory = e.getClickedInventory();
            assert inventory != null;
            ItemStack[] content1 = inventory.getContents();
            ItemStack[] content2 = swordsmanClass.firstChoice().getContents();
            if (Arrays.equals(content1, content2)) {
                e.setCancelled(true);
                try {
                    PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                    if (stats.getPlayer_class() == 1) {
                        //evolve swordsman class
                        if (Objects.requireNonNull(e.getCurrentItem()).equals(heads.getKnight())) {
                            p.sendMessage("§l§aYou are now a §l§7Advanced Swordsman§l§a!");
                            stats.setPlayer_class(2);
                            this.plugin.getDatabase().updatePlayerStats(stats);
                            getClassInv.getClassInventory(p);
                        }
                    } else {

                        p.sendMessage("§4You already have a class!");
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void evolveClass2(InventoryClickEvent e) {
        Heads heads = new Heads();
        GetClassInventory getClassInv = new GetClassInventory(this.plugin);
        MagicianClass magicianClass = new MagicianClass();
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            Inventory inventory = e.getClickedInventory();
            assert inventory != null;
            ItemStack[] content1 = inventory.getContents();
            ItemStack[] content2 = magicianClass.firstChoice().getContents();
            if (Arrays.equals(content1, content2)) {
                e.setCancelled(true);
                try {
                    PlayerClassModel stats = this.plugin.getDatabase().findPlayerByUUID(p.getUniqueId().toString());
                    if (stats.getPlayer_class() == 10) {
                        //evolve magician class
                        if (Objects.requireNonNull(e.getCurrentItem()).equals(heads.getMage())) {
                            p.sendMessage("§l§aYou are now an §l§7Advanced Magician§l§a!");
                            stats.setPlayer_class(11);
                            this.plugin.getDatabase().updatePlayerStats(stats);
                            getClassInv.getClassInventory(p);
                        }
                    } else {

                        p.sendMessage("§4You already have a class!");
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
