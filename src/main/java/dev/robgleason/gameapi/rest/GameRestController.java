package dev.robgleason.gameapi.rest;


import dev.robgleason.gameapi.entity.Game;
import dev.robgleason.gameapi.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
