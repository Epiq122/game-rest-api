package dev.robgleason.gameapi.rest;


import dev.robgleason.gameapi.entity.Game;
import dev.robgleason.gameapi.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameRestController {

    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

// expose "/games" and return a list of games

    @GetMapping("/games")
    public List<Game> findAll() {
        return gameService.findAll();
    }

    // add mapping for GET /games/{gamesId}
    @GetMapping("/games/{gameId}")
    public Game getGame(@PathVariable int gameId) {
        Game game = gameService.findById(gameId);
        if (game == null) {
            throw new RuntimeException("Game not found - " + gameId);
        }
        return game;
    }

    // add mapping for POST /games/ - add new game

    @PostMapping("/games")
    public Game addGame(@RequestBody Game game) {
        // also just incase they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        game.setId(0);

        Game dbGame = gameService.save(game);

        return dbGame;

    }

    // add a mapping for PUT /games - update a game

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game) {
        Game dbGame = gameService.save(game);
        return dbGame;
    }
}
