package Stoom.datastorage;

import Stoom.model.Game;
import Stoom.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStorage {
    private final List<Game> games = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public FakeDataStorage() {
    User u1 = new User(0,"EpicGames","f0rtnite");
    User u2 = new User(1, "Mediatonic", "f@llguys");
    User u3 = new User(2,"Nintendo", "mar10");
    users.add(u1);
    users.add(u2);
    users.add(u3);

    Game g1 = new Game(0,"Fortnite","Shooter",u1);
    Game g2 = new Game(1,"Fall guys","platformer", u2);
    Game g3 = new Game(2,"Mario", "platformer", u3);
    games.add(g1);
    games.add(g2);
    games.add(g3);
    }

    public List<Game> getGames()
    {
        return games;
    }
    public List<Game> getGames(User user)
    {
        List<Game> filteredgames = new ArrayList<>();
        for (Game game : games)
        {
            if(game.getCreator().equals(user))
            {
                filteredgames.add(game);
            }
        }
        return filteredgames;
    }
    public Game getGame(int id) {
        for (Game game : games)
        {
            if(game.getGameID() == id)
            {
                return game;
            }
        }
        return null;
    }

    public User getUser(int id) {
        for (User user : users)
        {
            if(user.getUserId() == id)
            {
                return user;
            }
        }
        return null;
    }

    public List<Game> getGames(String category) {
        List<Game> filteredgames = new ArrayList<>();
        for (Game game : games)
        {
            if(game.getCategory().equals(category))
            {
                filteredgames.add(game);
            }
        }
        return filteredgames;
    }
}
