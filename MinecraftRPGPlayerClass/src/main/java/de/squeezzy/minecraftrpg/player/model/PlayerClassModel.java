package de.squeezzy.minecraftrpg.player.model;

public class PlayerClassModel {

    private String uuid;
    private int player_class;
    private int level;

    public PlayerClassModel(String uuid, int player_class, int level) {
        this.uuid = uuid;
        this.player_class = player_class;
        this.level = level;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPlayer_class() {
        return player_class;
    }

    public void setPlayer_class(int player_class) {
        this.player_class = player_class;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
