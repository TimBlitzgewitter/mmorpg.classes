package de.squeezzy.minecraftrpg.player.db;

import de.squeezzy.minecraftrpg.player.model.PlayerClassModel;

import java.sql.*;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException{

        if (connection != null) {
            return connection;
        }

        String url = "jdbc:mysql://localhost/player";
        String user = "root";
        String password = "";

        this.connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to the Player Class Database.");

        return this.connection;
    }

    public void initializeDatabase() throws SQLException{

            Statement statement = getConnection().createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS player_class(uuid varchar(36) primary key, player_class int, level int)";
            statement.execute(sql);

            statement.close();

            System.out.println("Created the Class table in the database.");

    }

    public PlayerClassModel findPlayerByUUID(String uuid) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_class WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet results = statement.executeQuery();

        if(results.next()){

            int player_class = results.getInt("player_class");
            int level = results.getInt("level");

            PlayerClassModel playerClassModel = new PlayerClassModel(uuid, player_class, level);

            statement.close();

            return playerClassModel;


        }
        statement.close();

        return null;
    }

    public void createPlayerStats(PlayerClassModel stats) throws SQLException{

        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO player_class(uuid, player_class, level) VALUES (?, ?, ?)");

        statement.setString(1, stats.getUuid());
        statement.setInt(2, stats.getPlayer_class());
        statement.setInt(3, stats.getLevel());

        statement.executeUpdate();

        statement.close();

    }

    public void updatePlayerStats(PlayerClassModel stats) throws SQLException{

        PreparedStatement statement = getConnection()
                .prepareStatement("UPDATE player_class SET player_class = ?, level = ? WHERE uuid = ?");


        statement.setInt(1, stats.getPlayer_class());
        statement.setInt(2, stats.getLevel());
        statement.setString(3, stats.getUuid());

        statement.executeUpdate();

        statement.close();

    }
}
