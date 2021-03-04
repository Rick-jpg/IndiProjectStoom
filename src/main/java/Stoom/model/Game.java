package Stoom.model;

import java.util.Objects;

public class Game {
    private int gameID;
    private String gameName;
    private String category;

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    private User creator;  //The person who made the game

    public Game(int gameID, String gameName, String category, User creator) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.category = category;
        this.creator = creator;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameID == game.gameID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gameID);
    }


    @Override
    public String toString() {
        return "Game{" +
                "Id=" + gameID +
                ", name='" + gameName + '(' +
                ", category=" + category + ')' +
                " made by" + creator +
                '}';
    }
}
