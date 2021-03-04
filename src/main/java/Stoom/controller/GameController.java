package Stoom.controller;
import Stoom.datastorage.FakeDataStorage;
import Stoom.model.Game;
import Stoom.model.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    private static final FakeDataStorage fakeDS = new FakeDataStorage();

    @GetMapping("{id}")
    public ResponseEntity<Game> getGamePath(@PathVariable(value = "id") int id) {
        Game game = fakeDS.getGame(id);

        if(game != null) {
            return ResponseEntity.ok().body(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(@PathVariable(value = "user")Optional<String> user)
    {
        List<Game> games = null;
        if(user.isPresent())
        {
            User u = fakeDS.getUser(user.hashCode());
            games = fakeDS.getGames(u);
        }
        else
        {
            games = fakeDS.getGames();
        }
        if(games != null) {
            return ResponseEntity.ok().body(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{category}")
    public ResponseEntity<List<Game>> getAllGamesWithCategory(@PathVariable(value = "category") String category) {
        List<Game> games = null;
        games = fakeDS.getGames(category);

        if(games != null) {
            return ResponseEntity.ok().body(games);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
