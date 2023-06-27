package de.squeezzy.minecraftrpg.player;

import de.squeezzy.minecraftrpg.player.commands.ChooseClass;
import de.squeezzy.minecraftrpg.player.db.Database;
import de.squeezzy.minecraftrpg.player.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;

public final class PlayerClass extends JavaPlugin {

    private Database database;

    @Override
    public void onEnable() {

        try {
            this.database  = new Database();
            database.initializeDatabase();
        } catch (SQLException ex) {
            System.out.println("Unable to connect to database and create tables.");
            ex.printStackTrace();
        }
        Objects.requireNonNull(getCommand("chooseclass")).setExecutor(new ChooseClass());
        getServer().getPluginManager().registerEvents(new Listeners(this), this);


    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
